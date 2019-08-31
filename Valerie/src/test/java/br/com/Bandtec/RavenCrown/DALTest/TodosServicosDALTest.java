package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosServicosDALTest {

    @Autowired
    TodosServicosDAL servicosDAL;
    ServicoEntity servico;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Test
    public void PersistirServico(){
        servico = new ServicoEntity();
        servico.setDescricao("Manutenção de Pias e Tanques de Lavanderia");
        servico.setLocalizacaoFixa(false);
        servico.setNome("Pias e Tanques Conserto");
        servico.setPreco(33.59);
        servico.setPrestador(usuariosDAL.getOne(10));
        servico.setTempoExecucao(LocalTime.now());

        servicosDAL.save(servico);

        ServicoEntity servicoPerssitido = servicosDAL.getOne(servico.getId());

        assertEquals(servicoPerssitido,servico);
    }

    @Test
    public void ObterServicoTest(){

        List<ServicoEntity> todosServicos  = servicosDAL.findAll();

        assertFalse(todosServicos.isEmpty());

    }
}
