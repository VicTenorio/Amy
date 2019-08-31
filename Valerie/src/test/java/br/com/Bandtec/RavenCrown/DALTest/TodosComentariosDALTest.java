package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ComentarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosComentariosDAL;
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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosComentariosDALTest {

    @Autowired
    private TodosComentariosDAL todosComentariosDAL;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity userModel;

    @Autowired
    TodosServicosDAL servicosDAL;
    UsuarioEntity servico;

    @Autowired
    private UsuarioBusiness business;

    @Before
    public void UsuarioBusinessTest(){
        userModel = new UsuarioEntity();

        userModel.setEmail("teste@revencrown");
        userModel.setNome("Usuario de teste");
        userModel.setTelefone("4002-8922");
        userModel.setEstadoCivil("Solteiro");
        userModel.setSexo('I');
        userModel.setPrestador(false);
        userModel.setRG("XX.XXX.XX-X");
        userModel.setCpfCnpj("123.456.789-09");
        userModel.setSenha("string");
        userModel.setDataNascimento(LocalDate.now());
        userModel = business.Cadastro(userModel);

    }


    @Test
    public void ComentarioGetTest(){

        List<ComentarioEntity> comentario = todosComentariosDAL.findAll();
        assertTrue(comentario.size() > 0);
    }

    @Test
    public void PersistirComentario(){
        ComentarioEntity comentario = new ComentarioEntity();

        java.util.Date DATA = new java.util.Date();
        Date data = new Date(DATA.getTime());

        comentario.setData(data);
        comentario.setDeComentario("Testes do Spring Boot");
        comentario.setServico(servicosDAL.getOne(userModel.getId()));
        comentario.setUsuario(usuariosDAL.getOne(userModel.getId()));

        todosComentariosDAL.save(comentario);

        ComentarioEntity comentarioEntitySalvo = todosComentariosDAL.getOne(comentario.getId());

        assertEquals(comentario,comentarioEntitySalvo);
    }

}
