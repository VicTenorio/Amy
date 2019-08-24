package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="ENDERECO")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    private String Rua;

    private String Cep;

    private String Complemento;

    private String Numero;

    private String Referencia;

    private String Bairro;

    private String Cidade;

    private String Estado;

    private String Pais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioEntity Usuario;

    public EnderecoEntity(int id) {
        this.Id = id;
    }

    public EnderecoEntity() {
    }

    public EnderecoEntity(int id, String rua, String cep, String complemento, String numero, String referencia, String bairro, String cidade, String estado, String pais, UsuarioEntity usuario) {
        Id = id;
        Rua = rua;
        Cep = cep;
        Complemento = complemento;
        Numero = numero;
        Referencia = referencia;
        Bairro = bairro;
        Cidade = cidade;
        Estado = estado;
        Pais = pais;
        Usuario = usuario;
    }

    public UsuarioEntity getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        Usuario = usuario;
    }

    public int getId() {return this.Id;}

    public void setId(int id) {Id = id; }

    public String getRua() {return this.Rua;}

    public void setRua(String rua) {this.Rua = rua;}

    public String getCep() {return Cep; }

    public void setCep(String cep) {this.Cep = cep; }

    public String getComplemento() { return Complemento; }

    public void setComplemento(String complemento) {this.Complemento = complemento; }

    public String getNumero() { return Numero; }

    public void setNumero(String Numero) {this.Numero = Numero; }

    public String getReferencia() { return Referencia; }

    public void setReferencia(String Referencia) {this.Referencia = Referencia; }

    public String getBairro() {return Bairro;}

    public void setBairro(String Bairro) {this.Bairro = Bairro; }

    public String getCidade() { return Cidade; }

    public void setCidade(String Cidade) {this.Cidade = Cidade; }

    public String getEstado() { return Estado; }

    public void setEstado(String Estado) {this.Estado = Estado; }

    public String getPais() { return Pais; }

    public void setPais(String Pais) {this.Pais = Pais; }


}

