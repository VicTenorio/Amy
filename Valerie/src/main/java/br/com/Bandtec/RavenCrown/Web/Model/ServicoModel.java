package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
public class ServicoModel {

    private int id;

    private int idUsuario;

    private EnderecoModel endereco;

    private int idCategoria;

    private List<ImagemServicoModel> Imagem;

    private String nome;

    private String descricao;

    private LocalTime tempoExecucao;

    private Double preco;

    private boolean localizacaoFixa;

    public ServicoModel() {
    }

    public ServicoModel(int id, int idUsuario, EnderecoModel endereco, int idCategoria, List<ImagemServicoModel> Imagem, String nome, String descricao, LocalTime tempoExecucao, Double preco, boolean localizacaoFixa) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.endereco = endereco;
        this.idCategoria = idCategoria;
        this.Imagem = Imagem;
        this.nome = nome;
        this.descricao = descricao;
        this.tempoExecucao = tempoExecucao;
        this.preco = preco;
        this.localizacaoFixa = localizacaoFixa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<ImagemServicoModel> getImagem() {
        return Imagem;
    }

    public void setImagem(List<ImagemServicoModel> imagem) {
        Imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalTime getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(LocalTime tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isLocalizacaoFixa() {
        return localizacaoFixa;
    }

    public void setLocalizacaoFixa(boolean localizacaoFixa) {
        this.localizacaoFixa = localizacaoFixa;
    }
}
