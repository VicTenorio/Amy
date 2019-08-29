package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String lougradouro;

    private String cep;

    private String complemento;

    private String numero;

    private String referencia;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private UsuarioEntity usuario;

    public EnderecoEntity(int id) {
        this.id = id;
    }

    public EnderecoEntity() {
    }

    public EnderecoEntity(int id, String lougradouro, String cep, String complemento, String numero, String referencia, String bairro, String cidade, String estado, String pais, UsuarioEntity usuario) {
        this.id = id;
        this.lougradouro = lougradouro;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.referencia = referencia;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.usuario = usuario;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public int getId() {return this.id;}

    public void setId(int id) {this.id = id; }

    public String getLougradouro() {return this.lougradouro;}

    public void setLougradouro(String lougradouro) {this.lougradouro = lougradouro;}

    public String getCep() {return cep; }

    public void setCep(String cep) {this.cep = cep; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) {this.complemento = complemento; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) {this.numero = numero; }

    public String getReferencia() { return referencia; }

    public void setReferencia(String referencia) {this.referencia = referencia; }

    public String getBairro() {return bairro;}

    public void setBairro(String Bairro) {this.bairro = Bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) {this.cidade = cidade; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) {this.estado = estado; }

    public String getPais() { return pais; }

    public void setPais(String pais) {this.pais = pais; }


}

