package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="DEMANDA")
public class DemandaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private EnderecoEntity Endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_consumidor")
    private UsuarioEntity Contratante;

    private String Nome;

    private String Descricao;

    private Double Valor_Previsto;

    public DemandaEntity() {
    }

    public DemandaEntity(int id, EnderecoEntity endereco, UsuarioEntity contratante, String nome, String descricao, Double valor_Previsto) {
        Id = id;
        Endereco = endereco;
        Contratante = contratante;
        Nome = nome;
        Descricao = descricao;
        Valor_Previsto = valor_Previsto;
    }

    public int getId() { return Id; }

    public void setId(int id) { Id = id; }

    public EnderecoEntity getEndereco() { return Endereco; }

    public void setEndereco(EnderecoEntity Endereco) { Endereco = Endereco; }

    public UsuarioEntity getContratante() { return Contratante; }

    public void setContratante(UsuarioEntity Contratante) { Contratante = Contratante; }

    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }

    public String getDescricao() { return Descricao; }

    public void setDescricao(String descricao_Ddemanda) { Descricao = descricao_Ddemanda; }

    public Double getValor_Previsto() { return Valor_Previsto; }

    public void setValor_Previsto(Double valor_Previsto) { Valor_Previsto = valor_Previsto; }
}

