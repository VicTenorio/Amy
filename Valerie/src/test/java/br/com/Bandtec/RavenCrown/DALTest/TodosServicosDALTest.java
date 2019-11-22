package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
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

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
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
    TodosUsuariosDAL userDAL;
    UsuarioEntity user;

    @Before
    public void InsertUser(){
        EnderecoEntity endereco = new EnderecoEntity(
                0,
                "Rua das Bergamotas",
                "01001-555",
                "APT 77",
                "48A",
                "Feira de Sabado",
                "Jardim das Frutas",
                "São Carlos",
                "SP",
                "Brazil",
                null
        );
        user = new UsuarioEntity();

        user.setSenha("rv2058");
        user.setNome("Regina");
        user.setEmail("vitoria@outlook.com"+LocalDateTime.now().toString());
        user.setCpfCnpj("111.111.111.11");
        user.setEstadoCivil("Casada");
        user.setPrestador(false);
        user.setRG("34-443-443-X");
        user.setSexo('F');
        user.setTelefone("(11) 4002-8922");
        user.setDataNascimento(LocalDate.now());
        user.setEndereco(endereco);

        userDAL.save(user);

        UsuarioEntity usuarioFromDB = userDAL.getOne(user.getId());

        user.setSenha(usuarioFromDB.getSenha());
    }


    @Test
    public void PersistirServico(){

        servico = new ServicoEntity();
        servico.setDescricao("Manutenção de Pias e Tanques de Lavanderia");
        servico.setLocalizacaoFixa(false);
        servico.setNome("Pias e Tanques Conserto");
        servico.setPreco(33.59);
        servico.setPrestador(userDAL.getOne(user.getId()));
        servico.setTempoExecucao(LocalTime.now());

        servicosDAL.save(servico);

        ServicoEntity servicoPersitido = servicosDAL.getOne(servico.getId());

        assertEquals(servicoPersitido,servico);
    }

    //@Test
    public void ObterServicoTest(){

        List<ServicoEntity> todosServicos  = servicosDAL.findAll();

        assertFalse(todosServicos.isEmpty());

    }
}
