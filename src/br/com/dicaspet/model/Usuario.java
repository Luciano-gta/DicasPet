package br.com.dicaspet.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -59705556868385807L;
	private long usu_id;
	private String usu_foto;
	private Date data_cadastro;
	private String usu_nome;
	private String usu_tipo_servico;
	private String usu_cfp;
	private String usu_endereco;
	private String usu_cnpj;
	private boolean ativo;
	private String usu_email;
	private String usu_senha;
	private String usu_status;
	private String usu_nivel_acesso;
	private Integer usu_pontuacao;
	private ArrayList<Animal> animais;
	private List<UsuarioServico> usuarioServicos = new LinkedList<UsuarioServico>();

	public Long getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(Long usu_id) {
		this.usu_id = usu_id;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}

	public String getUsu_email() {
		return usu_email;
	}

	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}

	public String getUsu_senha() {
		return usu_senha;
	}

	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}

	public String getUsu_status() {
		return usu_status;
	}

	public void setUsu_status(String usu_status) {
		this.usu_status = usu_status;
	}

	public String getUsu_nivel_acesso() {
		return usu_nivel_acesso;
	}

	public void setUsu_nivel_acesso(String usu_nivel_acesso) {
		this.usu_nivel_acesso = usu_nivel_acesso;
	}

	public Integer getUsu_pontuacao() {
		return usu_pontuacao;
	}

	public void setUsu_pontuacao(Integer usu_pontuacao) {
		this.usu_pontuacao = usu_pontuacao;
	}

	public String getUsu_endereco() {
		return usu_endereco;
	}

	public void setUsu_endereco(String usu_endereco) {
		this.usu_endereco = usu_endereco;
	}

	public boolean isAtivo() {
		System.out.println(ativo);
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public ArrayList<Animal> getAnimais() {

		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	public void setUsu_id(long usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_tipo_servico() {
		return usu_tipo_servico;
	}

	public void setUsu_tipo_servico(String usu_tipo_servico) {
		this.usu_tipo_servico = usu_tipo_servico;
	}

	public String getUsu_cfp() {
		return usu_cfp;
	}

	public void setUsu_cfp(String usu_cfp) {
		this.usu_cfp = usu_cfp;
	}

	public String getUsu_cnpj() {
		return usu_cnpj;
	}

	public void setUsu_cnpj(String usu_cnpj) {
		this.usu_cnpj = usu_cnpj;
	}

	public List<UsuarioServico> getUsuarioServicos() {
		return usuarioServicos;
	}

	public void setUsuarioServicos(List<UsuarioServico> usuarioServicos) {
		this.usuarioServicos = usuarioServicos;
	}

	public String getUsu_foto() {
		return usu_foto;
	}

	public void setUsu_foto(String usu_foto) {
		this.usu_foto = usu_foto;
	}

}
