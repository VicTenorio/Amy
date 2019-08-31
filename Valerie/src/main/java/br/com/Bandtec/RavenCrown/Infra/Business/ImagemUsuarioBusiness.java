package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.ImageUserDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemUsuairoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemUsuarioModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagemUsuarioBusiness {

    @Autowired
    private TodosImagemUsuairoDAL imagensDal;

    @Autowired
    private TodosUsuariosDAL userDAL;


    private final ImageUserDAO fileDAO;


    public ImagemUsuarioBusiness(){
        this.fileDAO = new ImageUserDAO(RepositoriesAdress.USER_IMAGE.toString());
    }

    public ImagemUsuarioModel GetUserImage(int Idusuario){

        ModelMapper mapper = new ModelMapper();

        mapper.addMappings(new PropertyMap<ImagemUsuarioEntity,ImagemUsuarioModel>(){
            @Override
            protected void configure() {
                map().setId(source.getUsuario().getId());
                map().setUrl(source.getUrl());
                map().setImage(null);
            }
        });

        ImagemUsuarioEntity imagem = imagensDal.GetImagemByUser(Idusuario);

        if(imagem == null){
            return null;
        }

        ImagemUsuarioModel image =  mapper.map(imagem,ImagemUsuarioModel.class);

        image.setImage(this.fileDAO.getImage(image.getUrl()));

        return image;
    }

    public ImagemUsuarioModel InsertUserImage(ImagemUsuarioModel model){

        ImagemUsuarioEntity oldImage = imagensDal.GetImagemByUser(model.getIdUsuario());
        if(oldImage != null)
            imagensDal.delete(oldImage);

            UsuarioEntity user = userDAL.getOne(model.getIdUsuario());
            ImagemUsuarioEntity imagemUsuarioEntity = new ImagemUsuarioEntity();
            imagemUsuarioEntity.setUrl(fileDAO.saveImage(model));
            imagemUsuarioEntity.setUsuario(user);
            imagensDal.save(imagemUsuarioEntity);

        model.setId(user.getImagem().getId());
        model.setUrl(user.getImagem().getUrl());

        return model;
    }

    public ImagemUsuarioModel UpdateUserImage(ImagemUsuarioModel model){

        ImagemUsuarioEntity oldImage = imagensDal.GetImagemByUser(model.getIdUsuario());
        if(oldImage != null)
            imagensDal.delete(oldImage);

        UsuarioEntity user = userDAL.getOne(model.getIdUsuario());
        ImagemUsuarioEntity imagemUsuarioEntity = new ImagemUsuarioEntity();
        imagemUsuarioEntity.setUrl(fileDAO.saveImage(model));
        imagemUsuarioEntity.setUsuario(user);
        imagensDal.save(imagemUsuarioEntity);

        model.setId(user.getImagem().getId());
        model.setUrl(user.getImagem().getUrl());

        return model;
    }
}
