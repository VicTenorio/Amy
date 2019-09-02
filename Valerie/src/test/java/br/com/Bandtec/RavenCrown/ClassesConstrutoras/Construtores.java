package br.com.Bandtec.RavenCrown.ClassesConstrutoras;


import br.com.Bandtec.RavenCrown.Entity.*;
import br.com.Bandtec.RavenCrown.Web.Model.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Construtores {

    UsuarioEntity user;
    EnderecoEntity endereco;
    ServicoEntity service;
    CategoriaEntity categoria;
    ImagemUsuarioEntity imagemUsuario;
    ImagemServicoEntity imagemServico;
    DemandaEntity demanda;
    DataServicoEntity data;
    ContratoEntity contrato;
    ComentarioEntity comentario;


    public void setUser(){
        user = new UsuarioEntity();
        user.setSenha("teste123");
        user.setEmail("teste@teste");
        user.setNome("teste");
        user.setEstadoCivil("Solteiro");
        user.setCpfCnpj("2534234234");
        user.setEndereco(getEndereco());
        user.setTelefone("97070-7070");
        user.setRG("54.456.456.7");
        user.setSexo('M');
        user.setDataNascimento(LocalDate.now());
        user.setImagem(null);
        user.setDatasConsumir(null);
        user.setServicosConsumir(null);
        user.setServicosPrestar(null);
        user.setDatasPrestar(null);

    }

    public UsuarioEntity getUser(){
            return user;
    }

    public void setEndereco() {
        endereco = new EnderecoEntity();

        endereco.setUsuario(getUser());
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setService() {
        service = new ServicoEntity();
        service.setDescricao("teste");
        service.setLocalizacaoFixa(true);
        service.setNome("Teste");
        service.setPreco(324.345);
        service.setPrestador(getUser());
        service.setTempoExecucao(LocalTime.now());
        service.setCategoria(getCategoria());
        service.setEndereco(getEndereco());
        service.setImagens(null);
        service.setComentarios(null);
        service.setDatas(null);
    }

    public ServicoEntity getService(){
        return service;
    }

    public void setCategoria() {
        categoria = new CategoriaEntity();
        categoria.setNome("Teste");
        categoria.setServicos(null);
    }

    public CategoriaEntity getCategoria(){
        return categoria;
    }

    public void setImagemUsuario() {
        imagemUsuario = new ImagemUsuarioEntity();
        imagemUsuario.setUsuario(getUser());
        imagemUsuario.setUrl("/caminho/teste");
    }

    public ImagemUsuarioEntity getImagemUsuario(){
        return imagemUsuario;
    }

    public void setImagemServico() {
        imagemServico = new ImagemServicoEntity();
        imagemServico.setServico(getService());
        imagemServico.setUsuario(getUser());
        imagemServico.setUrl("/caminho/teste");
    }

    public ImagemServicoEntity getImagemServico(){
        return imagemServico;
    }

    public void setDemanda() {
        demanda = new DemandaEntity();
        demanda.setContratante(getUser());
        demanda.setDescricao("Teste");
        demanda.setEndereco(getEndereco());
        demanda.setNome("Teste");
        demanda.setValorPrevisto(20.0);
    }

    public DemandaEntity getDemanda(){
        return demanda;
    }

    public void setData(){
        data = new DataServicoEntity();
        data.setServico(getService());
        data.setConsumidor(getUser());
        data.setDtAgendamento(LocalDateTime.now());
        data.setTipoReserva('M');
        data.setPrestador(getUser());
        data.setContrato(getContrato());
        data.setDemanda(getDemanda());
    }

    public DataServicoEntity getData(){
        return data;
    }

    public void setContrato(){
        contrato = new ContratoEntity();
        contrato.setAprovadoConsumidor(true);
        contrato.setAprovadoPrestador(true);
        contrato.setConsumidor(getUser());
        contrato.setEndereco(getEndereco());
        contrato.setPrestador(getUser());
        contrato.setValorFinal(10.0);
        contrato.setServico(getService());
        contrato.setDatas(null);
        contrato.setPago(true);
        contrato.setDemanda(getDemanda());
    }

    public ContratoEntity getContrato(){
        return contrato;
    }


    public void setComentario(){
        comentario = new ComentarioEntity();
        comentario.setData(Date.valueOf(LocalDate.now()));
        comentario.setDeComentario("teste");
        comentario.setServico(getService());
        comentario.setUsuario(getUser());
    }

    public ComentarioEntity getComentario(){
        return comentario;
    }

}
