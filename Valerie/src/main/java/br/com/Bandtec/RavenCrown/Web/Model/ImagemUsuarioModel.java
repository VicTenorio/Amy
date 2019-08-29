package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class ImagemUsuarioModel{

    private int id;

    private int idUsuario;

    private String url;

    private byte[] image;

    public ImagemUsuarioModel(){
    }

    public ImagemUsuarioModel(int id, int idUsuario, String url) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.url = url;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
