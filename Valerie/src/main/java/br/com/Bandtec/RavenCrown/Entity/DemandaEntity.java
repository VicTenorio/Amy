package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="demanda")
public class DemandaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuarioConsumidor")
    private UsuarioEntity contratante;

    private String nome;

    private String descricao;

    private Double valorPrevisto;

    public DemandaEntity() {
    }

    public DemandaEntity(int id, EnderecoEntity endereco, UsuarioEntity contratante, String nome, String descricao, Double valorPrevisto) {
        this.id = id;
        this.endereco = endereco;
        this.contratante = contratante;
        this.nome = nome;
        this.descricao = descricao;
        this.valorPrevisto = valorPrevisto;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public EnderecoEntity getEndereco() { return endereco; }

    public void setEndereco(EnderecoEntity endereco) { this.endereco = endereco; }

    public UsuarioEntity getContratante() { return contratante; }

    public void setContratante(UsuarioEntity contratante) { this.contratante = contratante; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricaoDdemanda) { this.descricao = descricaoDdemanda; }

    public Double getValorPrevisto() { return valorPrevisto; }

    public void setValorPrevisto(Double valorPrevisto) { this.valorPrevisto = valorPrevisto; }
}

