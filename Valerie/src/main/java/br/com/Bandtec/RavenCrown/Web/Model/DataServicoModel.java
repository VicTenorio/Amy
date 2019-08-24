package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;
import java.time.LocalDateTime;

public class DataServicoModel {

    private int idDataAgendamento;

    private int idPrestador;

    private int idConsumidor;

    private int id;

    private int idContrato;

    private int idDemanda;

    private LocalDateTime dtAgendamento;

    private char tipoReserva;

    public int getIdDataAgendamento() {
        return this.idDataAgendamento;
    }

    public void setidDataAgendamento(int idDataAgendamento) {
        this.idDataAgendamento = idDataAgendamento;
    }

    public int getidPrestador() {
        return this.idPrestador;
    }

    public void setidPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
    }

    public int getidConsumidor() {
        return this.idConsumidor;
    }

    public void setidConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public int getidServico() {
        return this.id;
    }

    public void setidServico(int id) {
        this.id = id;
    }

    public int getidContrato() {
        return idContrato;
    }

    public void setidContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getidDemanda() {
        return idDemanda;
    }

    public void setidDemanda(int idDemanda) {
        this.idDemanda = idDemanda;
    }

    public LocalDateTime getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(LocalDateTime dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public char getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(char tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}