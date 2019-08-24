package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;

@Entity
@Table(name="USUARIO")
public class ImagemUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioEntity Usuario;

    private String Url;

    public ImagemUsuarioEntity() {
    }

    public ImagemUsuarioEntity(int Id, UsuarioEntity usuario, String Url) {
        this.Id = Id;
        this.Usuario = usuario;
        this.Url = Url;
    }

    public UsuarioEntity getUsuario() {return Usuario; }

    public void setUsuario(UsuarioEntity Usuario) {
        this.Usuario = Usuario;
        Usuario.setImagem(this);
    }

    public int getId() { return Id; }

    public void setId(int Id) {this.Id = Id;}

    public String getUrl() { return Url; }

    public void setUrl(String Url) {this.Url = Url; }
}
