package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemServicoBussines;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ServicoController {

    @Autowired
    private ServicoBussiness servicoBussines;
    @Autowired
    private ImagemServicoBussines imagemBussines;
    @Autowired
    private UsuarioBusiness userBussines;

    @Autowired
    private TodosCategoriasDAL categoriasDAL;

    private ModelMapper modelMapper;

    public ServicoController(){
        modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ServicoModel, ServicoEntity>() {
            @Override
            protected void configure() {
                //map().setPrestador(userBussines.getUser(source.getIdUsuario()));
                //map().setCategoria(categoriasDAL.getOne(source.getIdCategoria()));
                map().setNome(source.getNome());
                map().setPreco(source.getPreco());
                map().setLocalizacaoFixa(source.isLocalizacaoFixa());
                map().setDescricao(source.getDescricao());
                map().setTempoExecucao(source.getTempoExecucao());
            }
        });
    }

    @GetMapping("/Servico")
    public ResponseEntity<ServicoModel> getServico(@RequestParam("id") int id){
        ServicoModel model = modelMapper.map(servicoBussines.getById(id),ServicoModel.class);
        model.setImagem(imagemBussines.getServiceImages(model.getId()));
        return ResponseEntity.ok(model);
    }

    @GetMapping("/Servicos/Categoria")
    public ResponseEntity<List<ServicoModel>> getServicoByCategory(@RequestParam("categoria") int id,@RequestParam("login") int prestador){
        try {
            List<ServicoModel> services = new ArrayList<>();
            servicoBussines.GetByCategory(id).forEach(x -> {
                if(x.getPrestador().getId() != prestador) {
                    ServicoModel servico = modelMapper.map(x, ServicoModel.class);
                    servico.setIdUsuario(x.getPrestador().getId());
                    try {
                        servico.setImagem(imagemBussines.getServiceImages(x.getId()));
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.toString());
                        servico.setImagem(null);
                    }
                    services.add(servico);
                }
            });
            return ResponseEntity.ok(services);
        }catch (Exception x){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/Servico")
    public ResponseEntity<ServicoModel> insertServico(@RequestBody ServicoModel model){


        ServicoEntity servicoEntity = modelMapper.map(model, ServicoEntity.class);

        servicoEntity.setPrestador(userBussines.getUser(model.getIdUsuario()));
        servicoEntity.setCategoria(categoriasDAL.getOne(model.getIdCategoria()));

        servicoEntity = servicoBussines.insertService(servicoEntity);

        if(model.getImagem() != null) {
            if (!model.getImagem().isEmpty()) {
                for (ImagemServicoModel x : model.getImagem()) {
                    imagemBussines.SaveImage(x, servicoEntity);
                }
                ;
            }
        }

        model = modelMapper.map(servicoEntity, ServicoModel.class);
        model.setIdUsuario(servicoEntity.prestador.getId());
        return ResponseEntity.ok(model);
    }

    @PutMapping("/Servico")
    public ResponseEntity<ServicoModel> updateServico(@RequestBody ServicoModel model){
        ServicoEntity servicoEntity = modelMapper.map(model, ServicoEntity.class);
        servicoEntity.setPrestador(userBussines.getUser(model.getIdUsuario()));
        servicoEntity.setCategoria(categoriasDAL.getOne(model.getIdCategoria()));
        servicoBussines.UpdateService(servicoEntity);
        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/Servico")
    public ResponseEntity<String> deleteServico(@RequestBody ServicoModel model){
        servicoBussines.DeleteService(modelMapper.map(model,ServicoEntity.class));
        return ResponseEntity.ok("Apagado com sucesso");
    }

    @GetMapping("/Prestador/Servicos")
    public ResponseEntity<List<ServicoModel>> getServicesFromPrestador(@RequestParam("id") int id){

            List<ServicoEntity> servicos = servicoBussines.ObterTodosServicosPorPrestadorId(id);

        List<ServicoModel> services = new ArrayList<>();

        for(ServicoEntity servico : servicos){
            ServicoModel service = modelMapper.map(servico,ServicoModel.class);
            if(servico.getImagens() != null){
                service.setImagem(imagemBussines.getServiceImages(servico.getId()));
            }
            services.add(service);
        }

        return ResponseEntity.ok(services);
    }
}
