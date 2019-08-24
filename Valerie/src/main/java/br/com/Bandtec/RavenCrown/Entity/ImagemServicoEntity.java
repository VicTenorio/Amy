package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="IMAGEM_SERVICO")
public class ImagemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Id_servico")
    private ServicoEntity Servico;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    private UsuarioEntity Usuario;

    private String Imagem_URL;

    public ImagemServicoEntity() {
    }

    public ImagemServicoEntity(int id, ServicoEntity servico, UsuarioEntity usuario, String _ImagemURL) {
        Id = id;
        Servico = servico;
        Usuario = usuario;
        Imagem_URL = _ImagemURL;
    }

    public int getId() { return Id; }

    public void setId(int Id) { this.Id = Id; }

    public ServicoEntity getServico() { return Servico; }

    public void setServico(ServicoEntity Servico) { this.Servico = Servico; }

    public UsuarioEntity getUsuario() { return Usuario; }

    public void setUsuario(UsuarioEntity Usuario) { this.Usuario = Usuario; }

    public String getImagem_URL() { return Imagem_URL; }

    public void setImagem_URL(String Url_Imagem) { this.Imagem_URL = Url_Imagem; }
}
