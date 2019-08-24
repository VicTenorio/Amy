package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.util.List;

public class ContratoModel {

    private int idContrato;

    private int idServico;

    private EnderecoModel endereco;

    private int idPrestador;

    private int idConsumidor;

    private int idDemanda;

    private double valorFinal;

    private boolean pago;

    private boolean aprovadoConsumidor;

    private boolean aprovadoPrestador;

    private List<DataServicoModel> datas;

    public ContratoModel() {
    }

    public ContratoModel(int idContrato, int idServico, EnderecoModel endereco, int idPrestador, int idConsumidor, int idDemanda, double valorFinal, boolean pago, boolean aprovado_Consumidor, boolean aprovadoPrestador, List<DataServicoModel> datas) {
        this.idContrato = idContrato;
        this.idServico = idServico;
        this.endereco = endereco;
        this.idPrestador = idPrestador;
        this.idConsumidor = idConsumidor;
        this.idDemanda = idDemanda;
        this.valorFinal = valorFinal;
        this.pago = pago;
        this.aprovadoConsumidor = aprovado_Consumidor;
        this.aprovadoPrestador = aprovadoPrestador;
        this.datas = datas;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public EnderecoModel getEndereco() {
        return this.endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public int getIdPrestador() {
        return this.idPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public int getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(int idDemanda) {
        this.idDemanda = idDemanda;
    }

    public double getValorFinal() {
        return this.valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public boolean isPago() {
        return this.pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isAprovado_Consumidor() {
        return this.aprovadoConsumidor;
    }

    public void setAprovado_Consumidor(boolean aprovadoConsumidor) {
        this.aprovadoConsumidor = aprovadoConsumidor;
    }

    public boolean isAprovadoPrestador() {
        return this.aprovadoPrestador;
    }

    public void setAprovadoPrestador(boolean aprovadoPrestador) {
        this.aprovadoPrestador = aprovadoPrestador;
    }

    public List<DataServicoModel> getDatas() {
        return this.datas;
    }

    public void setDatas(List<DataServicoModel> datas) {
        this.datas = datas;
    }
}