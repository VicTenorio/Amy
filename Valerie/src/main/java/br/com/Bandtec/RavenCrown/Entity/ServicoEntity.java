package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="SERVICO")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario_prestador", referencedColumnName = "id")
    public UsuarioEntity Prestador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id")
    private EnderecoEntity Endereco;

    @OneToMany(mappedBy = "Servico")
    private List<ComentarioEntity> Comentarios;

    @OneToMany(mappedBy = "Servico")
    private List<DataServicoEntity> Datas;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name= "ID_categoria")
    private CategoriaEntity Categoria;

    @OneToMany(mappedBy = "Servico")
    private List<ImagemServicoEntity> Imagens;


    private String Nome;

    private String Descricao;

    private LocalTime Tempo_Execucao;

    private Double Preco;

    private boolean Localizacao_Fixa;

    public ServicoEntity() {
    }

    public ServicoEntity(int id, UsuarioEntity prestador, EnderecoEntity endereco, List<ComentarioEntity> comentarios, List<DataServicoEntity> datas, CategoriaEntity categoria, String nome, String descricao, LocalTime tempo_Execucao, Double preco, boolean localizacao_Fixa) {
        Id = id;
        Prestador = prestador;
        Endereco = endereco;
        Comentarios = comentarios;
        Datas = datas;
        Categoria = categoria;
        Nome = nome;
        Descricao = descricao;
        Tempo_Execucao = tempo_Execucao;
        Preco = preco;
        Localizacao_Fixa = localizacao_Fixa;
    }

    public ServicoEntity(int id) {
        this.Id = id;
    }

    public int getId() { return Id;}

    public void setId(int Id) { this.Id = Id;}

    public UsuarioEntity getPrestador() { return Prestador; }

    public void setPrestador(UsuarioEntity Prestador) { this.Prestador = Prestador;}

    public EnderecoEntity getEndereco() { return Endereco;}

    public void setEndereco(EnderecoEntity Endereco) { this.Endereco = Endereco;}

    public String getNome() { return Nome;}

    public void setNome(String Nome) { this.Nome = Nome; }

    public String getDescricao() { return Descricao; }

    public void setDescricao(String Desc) { this.Descricao = Desc; }

    public LocalTime getTempo_Execucao() { return Tempo_Execucao; }

    public void setTempo_Execucao(LocalTime Tempo_Execucao) {this.Tempo_Execucao = Tempo_Execucao; }

    public Double getPreco() { return Preco; }

    public void setPreco(Double Preco) { this.Preco = Preco; }

    public boolean isLocalizacao_Fixa() { return Localizacao_Fixa; }

    public void setLocalizacao_Fixa(boolean Localizacao_Fixa) { this.Localizacao_Fixa = Localizacao_Fixa; }

    public List<ComentarioEntity> getComentarios() {
        return Comentarios;
    }

    public void setComentarios(List<ComentarioEntity> comentarios) {
        Comentarios = comentarios;
    }

    public List<DataServicoEntity> getDatas() {
        return Datas;
    }

    public void setDatas(List<DataServicoEntity> datas) {
        Datas = datas;
    }

    public CategoriaEntity getCategoria() {
        return Categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        Categoria = categoria;
    }

    public List<ImagemServicoEntity> getImagens() {
        return Imagens;
    }

    public void setImagens(List<ImagemServicoEntity> imagens) {
        Imagens = imagens;
    }


}

