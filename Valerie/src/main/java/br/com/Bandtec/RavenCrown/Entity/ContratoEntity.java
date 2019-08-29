package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="contrato")
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idServico", referencedColumnName = "id")
    private ServicoEntity servico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuarioPrestador")
    private UsuarioEntity prestador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuarioConsumidor")
    private UsuarioEntity consumidor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDemanda", referencedColumnName = "id")
    private DemandaEntity demanda;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contrato")
    private List<DataServicoEntity> datas;

    private double valorFinal;

    private boolean pago;

    private boolean aprovadoConsumidor;

    private boolean aprovadoPrestador;

    public ContratoEntity() {
    }

    public ContratoEntity(int id, ServicoEntity servico, EnderecoEntity endereco, UsuarioEntity prestador, UsuarioEntity consumidor, DemandaEntity demanda, List<DataServicoEntity> datas, double valorFinal, boolean pago, boolean aprovadoConsumidor, boolean aprovadoPrestador) {
        this.id = id;
        this.servico = servico;
        this.endereco = endereco;
        this.prestador = prestador;
        this.consumidor = consumidor;
        this.demanda = demanda;
        this.datas = datas;
        this.valorFinal = valorFinal;
        this.pago = pago;
        this.aprovadoConsumidor = aprovadoConsumidor;
        this.aprovadoPrestador = aprovadoPrestador;
    }

    public ServicoEntity getServico() {
        return servico;
    }

    public void setServico(ServicoEntity servico) {
        this.servico = servico;
        this.setPrestador(this.getServico().getPrestador());
    }

    public int getId() { return id; }

    public void setId(int id) { id = id; }

    public EnderecoEntity getEndereco() { return endereco; }

    public void setEndereco(EnderecoEntity endereco) { this.endereco = endereco; }

    public UsuarioEntity getPrestador() { return this.prestador; }

    public void setPrestador(UsuarioEntity prestador) { this.prestador = prestador; }

    public UsuarioEntity getConsumidor() { return consumidor; }

    public void setConsumidor(UsuarioEntity consumidor) { this.consumidor = consumidor; }

    public DemandaEntity getDemandaEntity() { return this.demanda; }

    public void setDemanda(DemandaEntity Demanda) { this.demanda = Demanda; }

    public double getValorFinal() { return valorFinal; }

    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }

    public boolean isPago() { return pago; }

    public void setPago(boolean pago) { this.pago = pago; }

    public boolean isAprovadoConsumidor() { return aprovadoConsumidor; }

    public void setAprovadoConsumidor(boolean aprovadoConsumidor) { this.aprovadoConsumidor = aprovadoConsumidor; }

    public boolean isAprovadoPrestador() { return aprovadoPrestador; }

    public void setAprovadoPrestador(boolean aprovadoPrestador) { this.aprovadoPrestador = aprovadoPrestador; }

    public List<DataServicoEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<DataServicoEntity> datas) {
        this.datas = datas;
    }


}
