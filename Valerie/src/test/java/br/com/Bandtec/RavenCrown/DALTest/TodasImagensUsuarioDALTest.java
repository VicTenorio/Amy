package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemUsuairoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Assert;
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

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodasImagensUsuarioDALTest {

    @Autowired
    TodosImagemUsuairoDAL imagemUsuarioDAL;
    @Autowired
    TodosUsuariosDAL userDAL;

    Construtores construtores = new Construtores();

    @Before
    public void begin(){
        construtores.setUser(userDAL.save(construtores.getUser()));
    }

    @Test
    public void A_PersistirImagemUsuario(){

        ImagemUsuarioEntity oldImage = imagemUsuarioDAL.GetImagemByUser(construtores.getUser().getId());
        if(oldImage != null)
            imagemUsuarioDAL.deleteById(oldImage.getId());

        ImagemUsuarioEntity imagem = new ImagemUsuarioEntity();

        imagem.setUrl("https://i.pinimg.com/originals/8a/3d/a2/8a3da20e55bd36a2f29f8f3ab4d0c5b5.jpg");
        imagem.setUsuario(construtores.getUser());

        imagem = imagemUsuarioDAL.save(imagem);

        ImagemUsuarioEntity imagemPerssitido = imagemUsuarioDAL.getOne(imagem.getId());

        Assert.assertEquals(imagemPerssitido, imagem);
    }

    //@Test
    //public void B_ObterImagemUsuarioTest(){
    //   ImagemUsuarioEntity ImagemDoUsuario  = imagemUsuarioDAL.GetImagemByUser(construtores.getUser().getId());
    //    assertEquals(ImagemDoUsuario.getUsuario().getId() ,construtores.getUser().getId());
    //}

}
