package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    private String Nome;

    @OneToMany(mappedBy = "Categoria")
    private List<ServicoEntity> Servicos;

    public CategoriaEntity() {
    }

    public CategoriaEntity(int id) {
        this.Id  = id ;
    }

    public CategoriaEntity(int id , String nome , List<ServicoEntity> servicos) {
        Id  = id ;
        Nome = nome;
        Servicos = servicos;
    }

    public List<ServicoEntity> getServicos() {
        return Servicos;
    }

    public void setServicos(List<ServicoEntity> servicos) {
        Servicos = servicos;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }
}
