package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

public class DemandaModel {

    private int id;

    private EnderecoEntity endereco;

    private UsuarioEntity contratante;

    private String nome;

    private String descricao;

    private Double valorPrevisto;

    public DemandaModel(int id, EnderecoEntity endereco, UsuarioEntity contratante, String nome, String descricao, Double valorPrevisto) {
        this.id = id;
        this.endereco = endereco;
        this.contratante = contratante;
        this.nome = nome;
        this.descricao = descricao;
        this.valorPrevisto = valorPrevisto;
    }
}
