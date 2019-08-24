package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="Datas_Servico_agendado")
public class DataServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_prestador")
    private UsuarioEntity Prestador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_consumidor")
    private UsuarioEntity Consumidor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private ServicoEntity Servico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    private ContratoEntity Contrato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_demanda", referencedColumnName = "id_demanda")
    private DemandaEntity Demanda;

    private LocalDateTime Dt_Agendamento;

    private char Tipo_Reserva;

    public DataServicoEntity() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public UsuarioEntity getPrestador() {
        return Prestador;
    }

    public void setPrestador(UsuarioEntity prestador) {
        Prestador = prestador;
    }

    public UsuarioEntity getConsumidor() {
        return Consumidor;
    }

    public void setConsumidor(UsuarioEntity consumidor) {
        Consumidor = consumidor;
    }

    public ServicoEntity getServico() {
        return Servico;
    }

    public void setServico(ServicoEntity servico) {
        Servico = servico;
    }

    public ContratoEntity getContrato() {
        return Contrato;
    }

    public void setContrato(ContratoEntity contrato) {
        Contrato = contrato;
    }

    public DemandaEntity getDemanda() {
        return Demanda;
    }

    public void setDemanda(DemandaEntity demanda) {
        Demanda = demanda;
    }

    public LocalDateTime getDt_Agendamento() {
        return Dt_Agendamento;
    }

    public void setDt_Agendamento(LocalDateTime dt_Agendamento) {
        Dt_Agendamento = dt_Agendamento;
    }

    public char getTipo_Reserva() {
        return Tipo_Reserva;
    }

    public void setTipo_Reserva(char tipo_Reserva) {
        Tipo_Reserva = tipo_Reserva;
    }
}
