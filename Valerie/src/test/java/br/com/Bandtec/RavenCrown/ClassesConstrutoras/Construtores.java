package br.com.Bandtec.RavenCrown.ClassesConstrutoras;

import br.com.Bandtec.RavenCrown.Entity.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Construtores {

    private UsuarioEntity user;
    private EnderecoEntity endereco;
    private ServicoEntity service;
    private CategoriaEntity categoria;
    private ImagemUsuarioEntity imagemUsuario;
    private ImagemServicoEntity imagemServico;
    private DemandaEntity demanda;
    private DataServicoEntity data;
    private ContratoEntity contrato;
    private ComentarioEntity comentario;

    public Construtores(){
        CreateUser();
        CreateEndereco();
        CreateService();
        CreateCategoria();
        CreateImagemUsuario();
        CreateImagemServico();
        CreateDemanda();
        CreateData();
        CreateContrato();
        CreateComentario();
    }

    public UsuarioEntity getUser() {
        return user;
    }

    public void setUser(UsuarioEntity user) {
        this.user = user;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public ServicoEntity getService() {
        return service;
    }

    public void setService(ServicoEntity service) {
        this.service = service;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public ImagemUsuarioEntity getImagemUsuario() {
        return imagemUsuario;
    }

    public void setImagemUsuario(ImagemUsuarioEntity imagemUsuario) {
        this.imagemUsuario = imagemUsuario;
    }

    public ImagemServicoEntity getImagemServico() {
        return imagemServico;
    }

    public void setImagemServico(ImagemServicoEntity imagemServico) {
        this.imagemServico = imagemServico;
    }

    public DemandaEntity getDemanda() {
        return demanda;
    }

    public void setDemanda(DemandaEntity demanda) {
        this.demanda = demanda;
    }

    public DataServicoEntity getData() {
        return data;
    }

    public void setData(DataServicoEntity data) {
        this.data = data;
    }

    public ContratoEntity getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEntity contrato) {
        this.contrato = contrato;
    }

    public ComentarioEntity getComentario() {
        return comentario;
    }

    public void setComentario(ComentarioEntity comentario) {
        this.comentario = comentario;
    }

    private void CreateUser(){
        user = new UsuarioEntity();
        user.setSenha("teste123");
        user.setEmail("teste@teste"+LocalDateTime.now().hashCode());
        user.setNome("teste");
        user.setEstadoCivil("Solteiro");
        user.setCpfCnpj("253423"+LocalDateTime.now().hashCode());
        user.setTelefone("97070-7070");
        user.setRG("54.456.456.7");
        user.setSexo('M');
        user.setDataNascimento(LocalDate.now());
    }

    private void CreateEndereco() {
        endereco = new EnderecoEntity();
        endereco.setReferencia("referencia teste");
        endereco.setBairro("Bairro teste");
        endereco.setCep("cep Teste");
        endereco.setCidade("Carapicuiba");
        endereco.setComplemento("Teste");
        endereco.setEstado("SP");
        endereco.setLougradouro("Rua teste");
        endereco.setNumero("20");
        endereco.setPais("Brasil");
    }
    private void CreateService() {
        service = new ServicoEntity();
        service.setDescricao("teste");
        service.setLocalizacaoFixa(true);
        service.setNome("Teste");
        service.setPreco(324.345);
        service.setTempoExecucao(LocalTime.now());
    }
    private void CreateCategoria() {
        categoria = new CategoriaEntity();
        categoria.setNome("Teste");
    }
    private void CreateImagemUsuario() {
        imagemUsuario = new ImagemUsuarioEntity();
        imagemUsuario.setUrl("/caminho/teste");
    }
    private void CreateImagemServico() {
        imagemServico = new ImagemServicoEntity();
        imagemServico.setUrl("/caminho/teste.png");
    }
    private void CreateDemanda() {
        demanda = new DemandaEntity();
        demanda.setDescricao("Teste");
        demanda.setNome("Teste");
        demanda.setValorPrevisto(20.0);
    }
    private void CreateData(){
        data = new DataServicoEntity();
        data.setDtAgendamento(LocalDateTime.now());
        data.setTipoReserva('M');
    }
    private void CreateContrato(){
        contrato = new ContratoEntity();
        contrato.setAprovadoConsumidor(true);
        contrato.setAprovadoPrestador(true);
        contrato.setValorFinal(10.0);
        contrato.setPago(true);
    }
    private void CreateComentario(){
        comentario = new ComentarioEntity();
        comentario.setData(Date.valueOf(LocalDate.now()));
        comentario.setDeComentario("teste");
    }
}
