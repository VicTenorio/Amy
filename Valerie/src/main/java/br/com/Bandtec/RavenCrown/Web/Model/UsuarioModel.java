package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class UsuarioModel {

    public String nome;

    public String email;

    public String senha;

    public int id;

    public EnderecoModel endereco;

    public ImagemUsuarioModel imagem;

    public String cpfCnpj;

    public String RG;

    public String telefone;

    public boolean prestador;

    public char sexo;

    public String estadoCivil;

    public LocalDate dataNascimento;

    public UsuarioModel() {
    }

    public UsuarioModel(String nome, String email, String senha, int id, EnderecoModel endereco, ImagemUsuarioModel imagem, String cpfCnpj, String RG, String telefone, boolean prestador, char sexo, String estadoCivil, LocalDate data_Nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.endereco = endereco;
        this.imagem = imagem;
        this.cpfCnpj = cpfCnpj;
        this.RG = RG;
        this.telefone = telefone;
        this.prestador = prestador;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = data_Nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public ImagemUsuarioModel getImagem() {
        return imagem;
    }

    public void setImagem(ImagemUsuarioModel imagem) {
        this.imagem = imagem;
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

    public boolean isPrestador() {
        return prestador;
    }

    public void setPrestador(boolean prestador) {
        this.prestador = prestador;
    }

    public char getSexo() {
        return sexo;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
