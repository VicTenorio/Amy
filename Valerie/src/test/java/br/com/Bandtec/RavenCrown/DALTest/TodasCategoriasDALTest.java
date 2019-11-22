package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.CategoriaEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasCategoriasDALTest {

    @Autowired
    TodosCategoriasDAL categoriasDAL;
    CategoriaEntity categoria = (new Construtores().getCategoria());

    @Test
    public void persistirCategoria(){

        categoriasDAL.save(categoria);
        CategoriaEntity categoriaSalva = categoriasDAL.getOne(categoria.getId());
        Assert.assertEquals(categoria, categoriaSalva);
    }

    //@Test
    public void ObterCategoria(){
        List<CategoriaEntity> lista = categoriasDAL.findAll();
        Assert.assertTrue(lista.size() > 0);
    }


}
