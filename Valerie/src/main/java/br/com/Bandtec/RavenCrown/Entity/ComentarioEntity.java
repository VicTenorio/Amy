package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="comentario")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario", unique = true, nullable = false)
    private int id;

    @Column(name = "deComentario")
    private String deComentario ;

    @Column(name = "data")
    private Date data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idServico", referencedColumnName = "idServico")
    private ServicoEntity servico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioEntity usuario;

    public ComentarioEntity() {
    }

    public ComentarioEntity(int id, String de, Date data, ServicoEntity servico, UsuarioEntity usuario) {
        this.id = id;
        this.deComentario = de;
        this.data = data;
        this.servico = servico;
        this.usuario = usuario;
    }

    public ServicoEntity getServico() {
        return servico;
    }

    public void setServico(ServicoEntity servico) {
        this.servico = servico;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeComentario() {
        return deComentario;
    }

    public void setDeComentario(String deComentario) {
        this.deComentario = deComentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
