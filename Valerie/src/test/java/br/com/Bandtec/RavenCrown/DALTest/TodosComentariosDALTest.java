package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.ComentarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosComentariosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Assert;
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
    TodosUsuariosDAL userDAL;
    UsuarioEntity userModel;

    @Autowired
    TodosServicosDAL servicosDAL;
    UsuarioEntity servico;

    @Autowired
    private UsuarioBusiness business;

    Construtores construtores = new Construtores();

    @Before
    public void setters(){
        userDAL.save(construtores.getUser());
        servicosDAL.save(construtores.getService());
    }


    @Test
    public void ComentarioGetTest(){

        List<ComentarioEntity> comentario = todosComentariosDAL.findAll();
        Assert.assertFalse(comentario.isEmpty());
    }

    @Test
    public void PersistirComentario(){
        ComentarioEntity comentario = new ComentarioEntity();

        java.util.Date DATA = new java.util.Date();
        Date data = new Date(DATA.getTime());

        comentario.setData(data);
        comentario.setDeComentario("Testes do Spring Boot");
        comentario.setServico(servicosDAL.getOne(construtores.getService().getId()));
        comentario.setUsuario(userDAL.getOne(construtores.getUser().getId()));

        todosComentariosDAL.save(comentario);

        ComentarioEntity comentarioEntitySalvo = todosComentariosDAL.getOne(comentario.getId());

        assertEquals(comentario,comentarioEntitySalvo);
    }

}
