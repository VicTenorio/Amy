package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuarioPrestador", referencedColumnName = "id")
    public UsuarioEntity prestador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", referencedColumnName = "Id")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "servico")
    private List<ComentarioEntity> comentarios;

    @OneToMany(mappedBy = "servico")
    private List<DataServicoEntity> datas;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name= "idCategoria")
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "servico")
    private List<ImagemServicoEntity> imagens;


    private String nome;

    private String descricao;

    private LocalTime tempoExecucao;

    private Double preco;

    private boolean localizacaoFixa;

    public ServicoEntity() {
    }

    public ServicoEntity(int id, UsuarioEntity prestador, EnderecoEntity endereco, List<ComentarioEntity> comentarios, List<DataServicoEntity> datas, CategoriaEntity categoria, String nome, String descricao, LocalTime tempoExecucao, Double preco, boolean localizacaoFixa) {
        this.id = id;
        this.prestador = prestador;
        this.endereco = endereco;
        this.comentarios = comentarios;
        this.datas = datas;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.tempoExecucao = tempoExecucao;
        this.preco = preco;
        this.localizacaoFixa = localizacaoFixa;
    }

    public ServicoEntity(int id) {
        this.id = id;
    }

    public int getId() { return id;}

    public void setId(int Id) { this.id = Id;}

    public UsuarioEntity getPrestador() { return prestador; }

    public void setPrestador(UsuarioEntity Prestador) { this.prestador = Prestador;}

    public EnderecoEntity getEndereco() { return endereco;}

    public void setEndereco(EnderecoEntity Endereco) { this.endereco = Endereco;}

    public String getNome() { return nome;}

    public void setNome(String Nome) { this.nome = Nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String Desc) { this.descricao = Desc; }

    public LocalTime getTempoExecucao() { return tempoExecucao; }

    public void setTempoExecucao(LocalTime TempoExecucao) {this.tempoExecucao = TempoExecucao; }

    public Double getPreco() { return preco; }

    public void setPreco(Double Preco) { this.preco = Preco; }

    public boolean isLocalizacaoFixa() { return localizacaoFixa; }

    public void setLocalizacaoFixa(boolean LocalizacaoFixa) { this.localizacaoFixa = LocalizacaoFixa; }

    public List<ComentarioEntity> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioEntity> comentarios) {
        this.comentarios = comentarios;
    }

    public List<DataServicoEntity> getDatas() {
        return this.datas;
    }

    public void setDatas(List<DataServicoEntity> datas) {
        this.datas = datas;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public List<ImagemServicoEntity> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemServicoEntity> imagens) {
        this.imagens = imagens;
    }


}

