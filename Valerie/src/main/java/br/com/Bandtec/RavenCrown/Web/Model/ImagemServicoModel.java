package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

@Component
public class ImagemServicoModel{

    public int id;

    public int idServico;

    public int idUsuario;

    public String url;

    public byte[] image;

    public ImagemServicoModel(int id, int idServico, int idUsuario, String url, byte[] image) {
        this.id = id;
        this.idServico = idServico;
        this.idUsuario = idUsuario;
        this.url = url;
        this.image = image;
    }

    public ImagemServicoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String Url) {
        this.url = Url;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
