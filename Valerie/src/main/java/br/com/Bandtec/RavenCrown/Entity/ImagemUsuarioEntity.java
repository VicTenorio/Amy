package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;

@Entity
@Table(name="imagemUsuario")
public class ImagemUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImagemServico", unique = true, nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioEntity usuario;

    private String url;

    public ImagemUsuarioEntity() {
    }

    public ImagemUsuarioEntity(int Id, UsuarioEntity usuario, String Url) {
        this.id = Id;
        this.usuario = usuario;
        this.url = Url;
    }

    public UsuarioEntity getUsuario() {return usuario; }

    public void setUsuario(UsuarioEntity Usuario) {
        this.usuario = Usuario;
        Usuario.setImagem(this);
    }

    public int getId() { return id; }

    public void setId(int Id) {this.id = Id;}

    public String getUrl() { return url; }

    public void setUrl(String Url) {this.url = Url; }
}
