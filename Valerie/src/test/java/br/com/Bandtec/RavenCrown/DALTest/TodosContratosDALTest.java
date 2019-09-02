package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosContratosDALTest {

    @Autowired
    TodosContratosDAL contratosDAL;
    ContratoEntity contrato;

    @Autowired
    TodosServicosDAL servicosDAL;

    @Autowired
    TodosDemandasDAL demandasDAl;

    @Autowired
    TodosUsuariosDAL userDAL;

    Construtores construtores;

    @Before
    public void setters(){
        construtores = new Construtores();
        construtores.setEndereco();
        construtores.setUser();
        construtores.setService();
        construtores.setContrato();

        //persistencias
        userDAL.save(construtores.getUser());
        servicosDAL.save(construtores.getService());
    }

    @Test
    public void PersistirUmContratoDeServicoTest(){
        contrato = new ContratoEntity();

        contrato.setConsumidor(userDAL.getOne(construtores.getUser().getId()));
        contrato.getConsumidor().setEndereco(construtores.getEndereco());
        contrato.setPrestador(userDAL.getOne(construtores.getUser().getId()));
        contrato.setServico(servicosDAL.getOne(construtores.getService().getId()));
        contrato.setAprovadoConsumidor(false);
        contrato.setAprovadoPrestador(false);
        contrato.setEndereco(construtores.getEndereco());
        contrato.setPago(false);
        contrato.setValorFinal(200.00);

        contratosDAL.save(contrato);

        ContratoEntity contratoPersistido = contratosDAL.getOne(contrato.getId());

        assertEquals(contrato,contratoPersistido);
    }

    @Test
    public void PersistirUmContratoDeDemandaTest(){
        contrato = new ContratoEntity();

        DemandaEntity demanda = new DemandaEntity();

        demanda.setDescricao("Dar um jeito na pia quebrada");
        demanda.setNome("Pia Quebrada");
        demanda.setValorPrevisto(100.00);
        demanda.setEndereco(construtores.getEndereco());
        demanda.setContratante(userDAL.getOne(construtores.getUser().getId()));
        demandasDAl.save(demanda);

        contrato.setConsumidor(userDAL.getOne(construtores.getUser().getId()));
        contrato.getConsumidor().setEndereco(construtores.getEndereco());
        contrato.setPrestador(userDAL.getOne(construtores.getUser().getId()));
        contrato.setDemanda(demanda);
        contrato.setAprovadoConsumidor(true);
        contrato.setAprovadoPrestador(true);
        contrato.setEndereco(construtores.getEndereco());
        contrato.setPago(true);
        contrato.setValorFinal(00.00);

        contratosDAL.save(contrato);

        ContratoEntity contratoPersistido = contratosDAL.getOne(contrato.getId());

        assertEquals(contrato,contratoPersistido);
    }

    @Test
    public void buscarTodosContratosTest(){
        List<ContratoEntity> contratos = contratosDAL.findAll();

        assertFalse(contratos.isEmpty());
    }
}
