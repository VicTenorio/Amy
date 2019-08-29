package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<ServicoEntity> servicos;

    public CategoriaEntity() {
    }

    public CategoriaEntity(int id) {
        this.id  = id ;
    }

    public CategoriaEntity(int id , String nome , List<ServicoEntity> servicos) {
        this.id  = id ;
        this.nome = nome;
        this.servicos = servicos;
    }

    public List<ServicoEntity> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoEntity> servicos) {
        this.servicos = servicos;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return this.nome; }

    public void setNome(String nome) { this.nome = nome; }
}
