package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosEnderecosDALTest {

    @Autowired
    private TodosEnderecosDAL todosEnderecosDAL;
    private EnderecoEntity endereco;
    private UsuarioEntity user;
    private Construtores construtores = new Construtores();

    @Autowired
    private TodosUsuariosDAL userDAL;


    @Before
    public void setter(){
        construtores.setEndereco();
        construtores.setUser();
    }

    @Test
    public void obterEndereco(){
        List<EnderecoEntity> endereco  = todosEnderecosDAL.findAll();

        assertFalse(endereco.isEmpty());
    }

    @Test
    public void persitirEndereco(){

        todosEnderecosDAL.save(construtores.getEndereco());
        EnderecoEntity enderecoSalvo = todosEnderecosDAL.getOne(construtores.getEndereco().getId());

        assertEquals(enderecoSalvo, construtores.getEndereco());

    }

}
