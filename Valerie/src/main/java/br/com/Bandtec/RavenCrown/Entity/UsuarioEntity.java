package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id")
    private EnderecoEntity Endereco;

    @OneToOne(mappedBy="Usuario")
    private ImagemUsuarioEntity Imagem;

    private String Nome;

    @Column(unique=true)
    private String Email;

    @Column(unique=true)
    private String CPF_CNPJ;

    private String RG;

    private String Telefone;

    private String Senha;

    private boolean Prestador;

    private char Sexo;

    private String Estado_Civil;

    private LocalDate Data_Nascimento;


    @OneToMany(mappedBy="Prestador")
    private Collection<DataServicoEntity> DatasPrestar;

    @OneToMany(mappedBy="Consumidor")
    private Collection<DataServicoEntity>  DatasConsumir;

    @OneToMany(mappedBy="Prestador")
    private Collection<ContratoEntity> servicosPrestar ;

    @OneToMany(mappedBy="Consumidor")
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

    public UsuarioEntity(int id, EnderecoEntity endereco, ImagemUsuarioEntity imagem, String nome, String email, String CPF_CNPJ, String RG, String telefone, String senha, boolean prestador, char sexo, String estado_Civil, LocalDate data_Nascimento, Collection<DataServicoEntity> datasPrestar, Collection<DataServicoEntity> datasConsumir, Collection<ContratoEntity> servicosPrestar, Collection<ContratoEntity> servicosConsumir) {
        Id = id;
        Endereco = endereco;
        Imagem = imagem;
        Nome = nome;
        Email = email;
        this.CPF_CNPJ = CPF_CNPJ;
        this.RG = RG;
        Telefone = telefone;
        Senha = senha;
        Prestador = prestador;
        Sexo = sexo;
        Estado_Civil = estado_Civil;
        Data_Nascimento = data_Nascimento;
        DatasPrestar = datasPrestar;
        DatasConsumir = datasConsumir;
        this.servicosPrestar = servicosPrestar;
        this.servicosConsumir = servicosConsumir;
    }

    public LocalDate getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(LocalDate data_Nascimento) {
        Data_Nascimento = data_Nascimento;
    }

    public Collection<DataServicoEntity> getDatasPrestar() {
        return DatasPrestar;
    }

    public void setDatasPrestar(Collection<DataServicoEntity> datasPrestar) {
        DatasPrestar = datasPrestar;
    }

    public Collection<DataServicoEntity> getDatasConsumir() {
        return DatasConsumir;
    }

    public void setDatasConsumir(Collection<DataServicoEntity> datasConsumir) {
        DatasConsumir = datasConsumir;
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
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public boolean isPrestador() {
        return Prestador;
    }

    public void setPrestador(boolean prestador) {
        Prestador = prestador;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char sexo) {
        Sexo = sexo;
    }

    public String getEstado_Civil() {
        return Estado_Civil;
    }

    public void setEstado_Civil(String estado_Civil) {
        Estado_Civil = estado_Civil;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public EnderecoEntity getEndereco() {
        return Endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        Endereco = endereco;
        Endereco.setUsuario(this);
    }

    public ImagemUsuarioEntity getImagem() {
        return Imagem;
    }

    public void setImagem(ImagemUsuarioEntity imagem) {
        Imagem = imagem;
    }

}
