package br.com.Bandtec.RavenCrown.BusinessTest;


import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ContratoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContratoBusinessTest {

    @Autowired
    ContratoBussiness bussiness;

    @Autowired
    ServicoBussiness servicoBusiness;

    @Autowired
    UsuarioBusiness userBusiness;

    @Autowired
    TodosCategoriasDAL catDAL;

    @Autowired
    TodosUsuariosDAL userDAL;

    ServicoEntity servicoSalvo;

    @Before
    public void setUp(){
        ServicoEntity model = new ServicoEntity();

        model.setDescricao("Alteração de pisos e azuleijos da sua cozinha, montamos pias de arrumamos calhas");
        model.setPrestador(userDAL.save(new Construtores().getUser()));
        model.setNome("O Famoso Pedreiro");
        model.setLocalizacaoFixa(false);
        model.setPreco(33.33);
        model.setImagens(null);
        model.setCategoria(catDAL.save(new Construtores().getCategoria()));

        Time timer = new Time(Time.valueOf("10:00:00").getTime());
        java.sql.Date date = new java.sql.Date(timer.getTime());

        model.setTempoExecucao(LocalTime.now());
        servicoSalvo = servicoBusiness.insertService(model);
    }

    @Test
    public void AgendarServicoTest(){
        ContratoEntity contrato = new ContratoEntity();

        contrato.setConsumidor(userDAL.save(new Construtores().getUser()));
        contrato.setServico(servicoSalvo);
        contrato.setEndereco(new EnderecoEntity(0,"Rua do teste","00000-000",null,"100",null,"Todos os Teste","Sampa","SP","Brazil",contrato.getConsumidor()));
        contrato.setValorFinal(servicoSalvo.getPreco());

        List<DataServicoEntity> datas = new ArrayList<>();

        DataServicoEntity dia = new DataServicoEntity();

        dia.setServico(servicoSalvo);
        dia.setConsumidor(contrato.getConsumidor());
        dia.setTipoReserva('T');
        dia.setServico(servicoSalvo);

        dia.setDtAgendamento(LocalDateTime.parse("2025-01-01T00:30:00"));
        dia.setContrato(contrato);
        datas.add(dia);

        contrato.setDatas(datas);

        ContratoEntity contratoSalvo = bussiness.CreateContract(contrato);

        assertTrue(contrato == contratoSalvo);
    }
}
