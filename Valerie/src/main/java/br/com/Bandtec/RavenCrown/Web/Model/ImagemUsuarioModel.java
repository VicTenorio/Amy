package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class ImagemUsuarioModel{

    private int Id;

    private int Id_Usuario;

    private String Url;

    private byte[] image;

    public ImagemUsuarioModel(){
    }

    public ImagemUsuarioModel(int Id, int id_Usuario, String Url) {
        this.Id = Id;
        this.Id_Usuario = id_Usuario;
        this.Url = Url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.Id_Usuario = id_Usuario;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
