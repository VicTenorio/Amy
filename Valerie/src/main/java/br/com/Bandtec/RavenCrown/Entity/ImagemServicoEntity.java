package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="imagemServico")
public class ImagemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idServico")
    private ServicoEntity servico;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioEntity usuario;

    private String imagemURL;

    public ImagemServicoEntity() {
    }

    public ImagemServicoEntity(int id, ServicoEntity servico, UsuarioEntity usuario, String imagemURL) {
        this.id = id;
        this.servico = servico;
        this.usuario = usuario;
        this.imagemURL = imagemURL;
    }

    public int getId() { return id; }

    public void setId(int Id) { this.id = Id; }

    public ServicoEntity getServico() { return servico; }

    public void setServico(ServicoEntity Servico) { this.servico = Servico; }

    public UsuarioEntity getUsuario() { return usuario; }

    public void setUsuario(UsuarioEntity Usuario) { this.usuario = Usuario; }

    public String getImagemURL() { return imagemURL; }

    public void setImagemURL(String UrlImagem) { this.imagemURL = UrlImagem; }
}
