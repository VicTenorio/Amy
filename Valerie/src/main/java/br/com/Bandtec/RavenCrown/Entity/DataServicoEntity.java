package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="DataServioAgendado")
public class DataServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuarioPrestador")
    private UsuarioEntity prestador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuarioConsumidor")
    private UsuarioEntity consumidor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idServico", referencedColumnName = "idServico")
    private ServicoEntity servico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idContrato", referencedColumnName = "idContrato")
    private ContratoEntity contrato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDemanda", referencedColumnName = "idDemanda")
    private DemandaEntity demanda;

    private LocalDateTime dtAgendamento;

    private char tipoReserva;

    public DataServicoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioEntity getPrestador() {
        return prestador;
    }

    public void setPrestador(UsuarioEntity prestador) {
        this.prestador = prestador;
    }

    public UsuarioEntity getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(UsuarioEntity consumidor) {
        this.consumidor = consumidor;
    }

    public ServicoEntity getServico() {
        return servico;
    }

    public void setServico(ServicoEntity servico) {
        this.servico = servico;
    }

    public ContratoEntity getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEntity contrato) {
        this.contrato = contrato;
    }

    public DemandaEntity getDemanda() {
        return demanda;
    }

    public void setDemanda(DemandaEntity demanda) {
        this.demanda = demanda;
    }

    public LocalDateTime getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(LocalDateTime dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public char getTipoReserva() {
        return this.tipoReserva;
    }

    public void setTipoReserva(char tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}
