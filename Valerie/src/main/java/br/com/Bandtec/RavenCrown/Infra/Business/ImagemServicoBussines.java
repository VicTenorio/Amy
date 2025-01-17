package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.ImageServiceDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemServicoDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagemServicoBussines {

    @Autowired
    private TodosImagemServicoDAL repositorio;

    public List<ImagemServicoModel> getServiceImages(int idServico){

        List<ImagemServicoModel> images = new ArrayList<ImagemServicoModel>();
        ImageServiceDAO imageDAO = new ImageServiceDAO();
        List<ImagemServicoEntity> entities = repositorio.GetAllByServiceId(idServico);
        entities.forEach(X -> {
            ImagemServicoModel imagemModel = new ImagemServicoModel();
            imagemModel.setImage(imageDAO.getImage(X.getUrl()));
            imagemModel.setUrl(X.getUrl());
            imagemModel.setIdServico(X.getId());
            imagemModel.setIdUsuario(X.getUsuario().getId());
            images.add(imagemModel);
        });

        return  images;
    }

    public void SaveImage (ImagemServicoModel imagem, ServicoEntity entity){
        ImageServiceDAO imageDAO = new ImageServiceDAO();

        imagem.setUrl(imageDAO.saveImage(imagem));

        ImagemServicoEntity imagemServicoEntity = new ImagemServicoEntity(
                0,entity,entity.getPrestador(),imagem.getUrl()
        );

        repositorio.save(imagemServicoEntity);
    }

}
