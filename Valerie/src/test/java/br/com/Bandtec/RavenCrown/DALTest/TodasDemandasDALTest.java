package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosDemandasDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasDemandasDALTest {

    @Autowired
    TodosDemandasDAL demandasDAL;
    DemandaEntity demanda;

    @Autowired
    TodosUsuariosDAL userDAL;

    @Autowired
    TodosServicosDAL servicosDAL;

    Construtores construtores = new Construtores();

    @Before
    public void setters(){
       construtores.setUser(userDAL.save(construtores.getUser()));
       construtores.getService().setPrestador(construtores.getUser());
       construtores.setService(servicosDAL.save(construtores.getService()));
    }

    @Test
    public void PersistirDemandaTest() {
        demanda = new DemandaEntity();
        demanda.setDescricao("Dar um jeito na pia quebrada");
        demanda.setNome("Pia Quebrada");
        demanda.setValorPrevisto(100.00);
        demanda.setEndereco(construtores.getEndereco());
        demanda.setContratante(userDAL.getOne(construtores.getUser().getId()));
        demandasDAL.save(demanda);

        DemandaEntity demandaPerssitido = demandasDAL.getOne(demanda.getId());

        assertEquals(demandaPerssitido, demanda);
    }

    @Test
    public void ObterDemandaTest() {
        List<DemandaEntity> todasDamandas = demandasDAL.findAll();

        assertFalse(todasDamandas.isEmpty());
    }
}
