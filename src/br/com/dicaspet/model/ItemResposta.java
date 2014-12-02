package br.com.dicaspet.model;

import java.io.Serializable;

public class ItemResposta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383645140708374249L;
	private String nome_user;
	private int iconeRid;
	private String data;
	private String resposta;
	
	public ItemResposta(String nome_user, int iconeRid, String data, String resposta) {
		// TODO Auto-generated constructor stub
		this.nome_user = nome_user;
		this.iconeRid = iconeRid;
		this.data = data;
		this.resposta = resposta;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public int getIconeRid() {
		return iconeRid;
	}

	public void setIconeRid(int iconeRid) {
		this.iconeRid = iconeRid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
}
