package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="COMENTARIO")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @Column(name = "DE")
    private String De ;

    @Column(name = "DATA")
    private Date Data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private ServicoEntity Servico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity Usuario;

    public ComentarioEntity() {
    }

    public ComentarioEntity(int id, String de, Date data, ServicoEntity servico, UsuarioEntity usuario) {
        Id = id;
        De = de;
        Data = data;
        Servico = servico;
        Usuario = usuario;
    }

    public ServicoEntity getServico() {
        return Servico;
    }

    public void setServico(ServicoEntity servico) {
        Servico = servico;
    }

    public UsuarioEntity getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        Usuario = usuario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDe() {
        return De;
    }

    public void setDe(String de) {
        De = de;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

}
