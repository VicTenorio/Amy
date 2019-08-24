package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;

public class ComentarioModel {

    private int idComentario;

    private String comentario ;

    private Date dataComentario;

    private ServicoEntity servico;

    private UsuarioEntity usuario;

    public ComentarioModel(int idComentario, String comentario, Date dataComentario, ServicoEntity servico, UsuarioEntity usuario) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.dataComentario = dataComentario;
        this.servico = servico;
        this.usuario = usuario;
    }
}
