package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;

public class ComentarioModel {

    private int id;

    private String comentario ;

    private Date data;

    private ServicoEntity servico;

    private UsuarioEntity usuario;

    public ComentarioModel(int id, String comentario, Date data, ServicoEntity servico, UsuarioEntity usuario) {
        this.id = id;
        this.comentario = comentario;
        this.data = data;
        this.servico = servico;
        this.usuario = usuario;
    }
}
