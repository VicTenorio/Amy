package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.*;
import br.com.Bandtec.RavenCrown.Infra.Business.ContratoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosDatasServicoDAL;
import br.com.Bandtec.RavenCrown.Web.Model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ContratoController {

    @Autowired
    private ContratoBussiness contratoBussiness;

    @Autowired
    private ServicoBussiness servicoBussiness;

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    private ModelMapper mapper;

    public ContratoController() {
        this.mapper = new ModelMapper();

        PropertyMap<UsuarioModel, UsuarioEntity> userMap = new PropertyMap<UsuarioModel, UsuarioEntity>() {
            protected void configure() {
                map().setImagem(null);
                map().getImagem().setUsuario(map());
                map().setEmail(source.getEmail());
                map().setEstadoCivil(source.getEstadoCivil());
                map().setNome(source.getNome());
            }
        };
        mapper.addMappings(userMap);

        PropertyMap<ServicoModel, ServicoEntity> serviceMap = new PropertyMap<ServicoModel, ServicoEntity>() {
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
        };
        mapper.addMappings(serviceMap);
    }


    @PostMapping("/Servico/Agendar")
    public ResponseEntity<ContratoModel> CreateServiceContract(@RequestBody ContratoModel contrato) {
        try {
            ContratoEntity contract = new ContratoEntity();

            contract.setServico(servicoBussiness.getById(contrato.getIdServico()));
            contract.setPrestador(contract.getServico().getPrestador());
            contract.setConsumidor(usuarioBusiness.getUser(contrato.getIdConsumidor()));
            contract.setAprovadoPrestador(false);
            contract.setAprovadoConsumidor(false);

            List<DataServicoEntity> datas = new ArrayList<>();
            for (DataServicoModel x : contrato.getDatas()) {
                DataServicoEntity data = new DataServicoEntity();
                data.setPrestador(contract.getPrestador());
                data.setConsumidor(contract.getConsumidor());
                data.setDtAgendamento(x.getDtAgendamento());
                data.setTipoReserva(x.getTipoReserva());
                data.setDemanda(null);
                data.setServico(contract.getServico());
                datas.add(data);
            }
            contract.setDatas(datas);
            contract.setValorFinal(contrato.getValorFinal());
            contract.setEndereco(contrato.getEndereco() != null ? new ModelMapper().map(contrato.getEndereco(), EnderecoEntity.class) : null);

            contract = contratoBussiness.CreateContract(contract);

            contrato.setAprovadoConsumidor(contract.isAprovadoConsumidor());
            contrato.setAprovadoPrestador(contract.isAprovadoPrestador());
            contrato.setEndereco(contrato.getEndereco() != null ? new ModelMapper().map(contract.getEndereco(), EnderecoModel.class) : null);
            contrato.setIdContrato(contract.getId());
            return ResponseEntity.ok(contrato);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Servico/Consumidor/Aprovar")
    public ResponseEntity<String> AprovarAgendamentoConsumidor(@RequestParam("id") int idContrato, @RequestParam("aprovacao") boolean aprovacao) {
        try {
            boolean sucesso = contratoBussiness.AprovarConsumidor(idContrato, aprovacao);
            String messagem = "Aprovação relizada com" + (sucesso ? "Sucesso" : "Falha, Datas não mais disponiveis");
            return ResponseEntity.ok(messagem);

        } catch (Exception ex) {
            return new ResponseEntity("Erro ao aprovar :" + ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/Servico/Prestador/Aprovar")
    public ResponseEntity<String> AprovarAgendamentoPrestador(@RequestParam("id") int idContrato, @RequestParam("aprovacao") boolean aprovacao) {
        try {
            boolean sucesso = contratoBussiness.AprovarPrestador(idContrato, aprovacao);
            String messagem = "Aprovação relizada com" + (sucesso ? "Sucesso" : "Falha, Datas não mais disponiveis");
            return ResponseEntity.ok(messagem);

        } catch (Exception ex) {
            return new ResponseEntity("Erro ao aprovar :" + ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Usuario/Contratos")
    public ResponseEntity<List<VisualizacaoContratoModel>> ObterTodosContratos(@RequestParam("id") int id) {
        try {
            List<VisualizacaoContratoModel> lista = new ArrayList<>();

            for (ContratoEntity contratoEntity : contratoBussiness.ObterTodosContratosPorConsumidor(id)) {
                VisualizacaoContratoModel model = new VisualizacaoContratoModel();

                model = mapper.map(contratoEntity, VisualizacaoContratoModel.class);

                model.setIdContrato(contratoEntity.getId());
                model.setServicoModel(mapper.map(contratoEntity.getServico(), ServicoModel.class));
                model.setPrestador(mapper.map(contratoEntity.getServico().getPrestador(), UsuarioModel.class));
                List<DataServicoModel> datas = new ArrayList<>();
                contratoEntity.getDatas().forEach(x -> {
                    datas.add(mapper.map(x, DataServicoModel.class));
                });
                model.setDatas(datas);
                lista.add(model);
            }

            return ResponseEntity.ok(lista);


        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Prestador/Contratos")
    public ResponseEntity<List<VisualizacaoContratoModel>> ObterTodosContratosdePrestador(@RequestParam("id") int id) {
        try {
            List<VisualizacaoContratoModel> lista = new ArrayList<>();

            for (ContratoEntity contratoEntity : contratoBussiness.ObterTodosContratosPorPrestador(id)) {
                VisualizacaoContratoModel model = new VisualizacaoContratoModel();

                model = mapper.map(contratoEntity, VisualizacaoContratoModel.class);

                List<DataServicoModel> datas = new ArrayList<>();
                contratoEntity.getDatas().forEach(x -> {
                    datas.add(mapper.map(x, DataServicoModel.class));
                });
                model.setDatas(datas);
                lista.add(model);
            }

            return ResponseEntity.ok(lista);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return new ResponseEntity(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}