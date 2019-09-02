package br.com.Bandtec.RavenCrown.DALTest;


import br.com.Bandtec.RavenCrown.ClassesConstrutoras.Construtores;
import br.com.Bandtec.RavenCrown.Entity.CategoriaEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
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
import static junit.framework.TestCase.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasCategoriasDALTest {

    @Autowired
    TodosCategoriasDAL categoriasDAL;
    private CategoriaEntity categoria;



    @Test
    public void persistirCategoria(){
        categoria = new CategoriaEntity();
        categoria.setNome("Teste Categoria");

        categoriasDAL.save(categoria);

        CategoriaEntity categoriaSalva = categoriasDAL.getOne(categoria.getId());

        assertEquals(categoria,categoriaSalva);
    }

    @Test
    public void ObterCategoria(){
        List<CategoriaEntity> categoriaEntityList = categoriasDAL.findAll();
        assertFalse(categoriaEntityList.isEmpty());
    }


}
