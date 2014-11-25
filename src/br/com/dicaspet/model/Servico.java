package br.com.dicaspet.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4679856990087073546L;
    private long srv_id;
    private String srv_status;

    private Usuario srv_id_prtsrv;

    private String srv_descricao;

    private double srv_preco;

    private int srv_pontuacao;

    private String srv_categoria;

    private List<UsuarioServico> usuarioServicos = new LinkedList<UsuarioServico>();

    public String getSrv_id_string() {
            return Long.toString(srv_id);
    }

    public long getSrv_id() {
            return srv_id;
    }

    public void setSrv_id(long srv_id) {
            this.srv_id = srv_id;
    }

    public String getSrv_status() {
            return srv_status;
    }

    public void setSrv_status(String srv_status) {
            this.srv_status = srv_status;
    }

    public Usuario getSrv_id_prtsrv() {
            return srv_id_prtsrv;
    }

    public void setSrv_id_prtsrv(Usuario srv_id_prtsrv) {
            this.srv_id_prtsrv = srv_id_prtsrv;
    }

    public String getSrv_descricao() {
            return srv_descricao;
    }

    public void setSrv_descricao(String srv_descricao) {
            this.srv_descricao = srv_descricao;
    }

    public double getSrv_preco() {
            return srv_preco;
    }

    public void setSrv_preco(double srv_preco) {
            this.srv_preco = srv_preco;
    }

    public String getSrv_categoria() {
            return srv_categoria;
    }

    public void setSrv_categoria(String srv_categoria) {
            this.srv_categoria = srv_categoria;
    }

    public int getSrv_pontuacao() {
            return srv_pontuacao;
    }

    public void setSrv_pontuacao(int srv_pontuacao) {
            this.srv_pontuacao = srv_pontuacao;
    }

    public List<UsuarioServico> getUsuarioServicos() {
            return usuarioServicos;
    }

    public void setUsuarioServicos(List<UsuarioServico> usuarioServicos) {
            this.usuarioServicos = usuarioServicos;
    }

}
