package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosUsuariosDALTest {

    @Autowired
    private TodosUsuariosDAL userDAL;

    @Autowired
    private TodosEnderecosDAL todosEnderecosDAL;

    @Autowired
    private UsuarioBusiness business;

    LoginModel userEntity;

    UsuarioModel UserModel;

    //@Test
    public void GetUsersTest(){
        List<UsuarioEntity> list = userDAL.findAll();

        assertFalse(list.isEmpty());
    }

    @Test
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
        UsuarioEntity user = new UsuarioEntity();

        user.setSenha("rv2058");
        user.setNome("Regina");
        user.setEmail("vitoria@outlook.com");
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

        assertEquals(user, usuarioFromDB);
    }

    @Test
    public void testLogin(){

        EnderecoEntity endereco = new EnderecoEntity(
                0,
                "Rua das Orquideas",
                "01001-999",
                "",
                "488",
                "Feira de Sabado",
                "Jardim das Frutas",
                "São Carlos",
                "SP",
                "Brazil",
                null
        );

        UsuarioEntity user = new UsuarioEntity();
        user.setSenha("rv2058");
        user.setNome("João das Neves");
        user.setEmail("sabe@outlook.com");
        user.setCpfCnpj("71294533817");
        user.setEstadoCivil("Viuvo");
        user.setPrestador(false);
        user.setRG("34-443-888-X");
        user.setSexo('M');
        user.setTelefone("(11) 89902-8922");
        user.setEndereco(endereco);

        userDAL.save(user);

        UsuarioEntity login = userDAL.getByUserAndPass(user.getEmail(),user.getSenha());

        user.setSenha(login.getSenha());

        assertEquals(login,user);
    }
}
