package br.com.Bandtec.RavenCrown.BusinessTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemUsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemUsuarioModel;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioBusinessTest {

    @Autowired
    private UsuarioBusiness business;

    LoginModel userEntity;

    @Before
    public void UsuarioBusinessTest(){
        UsuarioEntity userModel = new UsuarioEntity();

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
    public void LoginTest(){
        userEntity = new LoginModel();

        userEntity.setEmail("teste@revencrown");


        userEntity.setSenha("string");

        UsuarioEntity userFromDB =  business.Login(userEntity.getEmail(),userEntity.getSenha());

        assertTrue(userFromDB != null);
    }
}
