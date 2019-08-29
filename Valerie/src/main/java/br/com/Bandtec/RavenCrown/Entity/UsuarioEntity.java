package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @OneToOne(mappedBy="usuario")
    private ImagemUsuarioEntity imagem;

    private String nome;

    @Column(unique=true)
    private String email;

    @Column(unique=true)
    private String cpfCnpj;

    private String RG;

    private String telefone;

    private String senha;

    private boolean prestador;

    private char sexo;

    private String estadoCivil;

    private LocalDate dataNascimento;


    @OneToMany(mappedBy="prestador")
    private Collection<DataServicoEntity> datasPrestar;

    @OneToMany(mappedBy="consumidor")
    private Collection<DataServicoEntity>  datasConsumir;

    @OneToMany(mappedBy="prestador")
    private Collection<ContratoEntity> servicosPrestar ;

    @OneToMany(mappedBy="consumidor")
    private Collection<ContratoEntity> servicosConsumir;

    public UsuarioEntity() {
    }

    public UsuarioEntity(String email, String Senha) {
        this.setEmail(email);
        this.setSenha(Senha);
    }

    public UsuarioEntity(int id) {
        this.setId(id);
    }

    public UsuarioEntity(int id, EnderecoEntity endereco, ImagemUsuarioEntity imagem, String nome, String email, String CPFCNPJ, String RG, String telefone, String senha, boolean prestador, char sexo, String estadoCivil, LocalDate dataNascimento, Collection<DataServicoEntity> datasPrestar, Collection<DataServicoEntity> datasConsumir, Collection<ContratoEntity> servicosPrestar, Collection<ContratoEntity> servicosConsumir) {
        this.id = id;
        this.endereco = endereco;
        this.imagem = imagem;
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.RG = RG;
        this.telefone = telefone;
        this.senha = senha;
        this.prestador = prestador;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.datasPrestar = datasPrestar;
        this.datasConsumir = datasConsumir;
        this.servicosPrestar = servicosPrestar;
        this.servicosConsumir = servicosConsumir;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Collection<DataServicoEntity> getDatasPrestar() {
        return datasPrestar;
    }

    public void setDatasPrestar(Collection<DataServicoEntity> datasPrestar) {
        this.datasPrestar = datasPrestar;
    }

    public Collection<DataServicoEntity> getDatasConsumir() {
        return this.datasConsumir;
    }

    public void setDatasConsumir(Collection<DataServicoEntity> datasConsumir) {
        this.datasConsumir = datasConsumir;
    }

    public Collection<ContratoEntity> getServicosPrestar() {
        return servicosPrestar;
    }

    public void setServicosPrestar(Collection<ContratoEntity> servicosPrestar) {
        this.servicosPrestar = servicosPrestar;
    }

    public Collection<ContratoEntity> getServicosConsumir() {
        return servicosConsumir;
    }

    public void setServicosConsumir(Collection<ContratoEntity> servicosConsumir) {
        this.servicosConsumir = servicosConsumir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPrestador() {
        return prestador;
    }

    public void setPrestador(boolean prestador) {
        this.prestador = prestador;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
        this.endereco.setUsuario(this);
    }

    public ImagemUsuarioEntity getImagem() {
        return imagem;
    }

    public void setImagem(ImagemUsuarioEntity imagem) {
        this.imagem = imagem;
    }

}
