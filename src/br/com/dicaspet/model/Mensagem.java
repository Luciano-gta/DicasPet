package br.com.dicaspet.model;

import java.io.Serializable;
import java.util.Date;

public class Mensagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6986846625334780436L;
	private long msg_id;
	private String msg_status;
	private Usuario msg_id_usu;
	private String msg_titulo;
	private String msg_conteudo;
	private long msg_cod_msg;
	private boolean msg_isPergunta;
	private int msg_avaliacao;
	private String msg_data_cadastro;
	private String msg_tipo_animal;
	public String getMsg_data_cadastro() {
		return msg_data_cadastro;
	}

	public void setMsg_data_cadastro(String msg_data_cadastro) {
		this.msg_data_cadastro = msg_data_cadastro;
	}

	public void setMsg_id(long msg_id) {
		this.msg_id = msg_id;
	}

	public long getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}

	public Usuario getMsg_id_usu() {
		return msg_id_usu;
	}

	public void setMsg_id_usu(Usuario msg_id_usu) {
		this.msg_id_usu = msg_id_usu;
	}

	public String getMsg_titulo() {
		return msg_titulo;
	}

	public void setMsg_titulo(String msg_titulo) {
		this.msg_titulo = msg_titulo;
	}

	public String getMsg_conteudo() {
		return msg_conteudo;
	}

	public void setMsg_conteudo(String msg_conteudo) {
		this.msg_conteudo = msg_conteudo;
	}

	public long getMsg_cod_msg() {
		return msg_cod_msg;
	}

	public void setMsg_cod_msg(long msg_cod_msg) {
		this.msg_cod_msg = msg_cod_msg;
	}

	public int getMsg_avaliacao() {
		return msg_avaliacao;
	}

	public void setMsg_avaliacao(int msg_avaliacao) {
		this.msg_avaliacao = msg_avaliacao;
	}

	public boolean isMsg_isPergunta() {
		return msg_isPergunta;
	}

	public void setMsg_isPergunta(boolean msg_isPergunta) {
		this.msg_isPergunta = msg_isPergunta;
	}

	public String getMsg_tipo_animal() {
		return msg_tipo_animal;
	}

	public void setMsg_tipo_animal(String msg_tipo_animal) {
		this.msg_tipo_animal = msg_tipo_animal;
	}

}
