package br.com.Bandtec.RavenCrown.DALTest;


import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemServicoDAL;
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

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasImagensServicoDALTest {
    @Autowired
    TodosImagemServicoDAL imagemServicoDAL;
    ImagemServicoEntity imagem;

    @Autowired
    TodosUsuariosDAL userDAL;
    UsuarioEntity usuario;

    @Autowired
    TodosServicosDAL servicosDAL;
    UsuarioEntity servico;


    Construtores construtores;

    @Before
    public void setters(){
        construtores = new Construtores();

        //persistencias
        userDAL.save(construtores.getUser());
        servicosDAL.save(construtores.getService());
    }

    @Test
    public void PersistirImagemServicoTest(){

        imagemServicoDAL.save(construtores.getImagemServico());

        ImagemServicoEntity imagemPersistido = imagemServicoDAL.getOne(construtores.getImagemServico().getId());

        assertEquals(imagemPersistido,construtores.getImagemServico());
    }

    @Test
    public void ObterImagemServicoTest(){

        List<ImagemServicoEntity> todasImagemDoServico  = imagemServicoDAL.findAll();

        assertFalse(false);
    }
}
