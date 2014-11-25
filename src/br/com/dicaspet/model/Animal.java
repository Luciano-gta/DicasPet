package br.com.dicaspet.model;

import java.io.Serializable;
import java.util.Date;

public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1433814299204264324L;
	private long ani_id;

	private String ani_nome;
	private String ani_foto;
	private String ani_status;
	private String ani_raca;
	private String ani_especie;
	private double ani_idade;
	private double ani_peso;
	private String ani_porte;
	private String ani_sexo;
	private Date ani_dt_nasc;
	private String ani_nivel_exercicio;
	private String ani_tamanho_pelo;
	private String ani_status_animal;
	private double ani_qtdInicAlimento;
	private double ani_qtdFimAlimento;
	private Usuario ani_id_usu;

	public Long getAni_id() {
		return ani_id;
	}

	public String getAni_id_string() {
		return Long.toString(ani_id);
	}

	public void setAni_id(Long ani_id) {
		this.ani_id = ani_id;
	}

	public String getAni_nome() {
		return ani_nome;
	}

	public void setAni_nome(String ani_nome) {
		this.ani_nome = ani_nome;
	}

	public String getAni_status() {
		return ani_status;
	}

	public void setAni_status(String ani_status) {
		this.ani_status = ani_status;
	}

	public String getAni_raca() {
		return ani_raca;
	}

	public void setAni_raca(String ani_raca) {
		this.ani_raca = ani_raca;
	}

	public String getAni_especie() {
		return ani_especie;
	}

	public void setAni_especie(String ani_especie) {
		this.ani_especie = ani_especie;
	}

	public double getAni_idade() {
		return ani_idade;
	}

	public void setAni_idade(double ani_idade) {
		this.ani_idade = ani_idade;
	}

	public double getAni_peso() {
		return ani_peso;
	}

	public void setAni_peso(double ani_peso) {
		this.ani_peso = ani_peso;
	}

	public String getAni_porte() {
		return ani_porte;
	}

	public void setAni_porte(String ani_porte) {
		this.ani_porte = ani_porte;
	}

	public String getAni_sexo() {
		return ani_sexo;
	}

	public void setAni_sexo(String ani_sexo) {
		this.ani_sexo = ani_sexo;
	}

	public Date getAni_dt_nasc() {
		return ani_dt_nasc;
	}

	public void setAni_dt_nasc(Date ani_dt_nasc) {
		this.ani_dt_nasc = ani_dt_nasc;
	}

	public String getAni_nivel_exercicio() {
		return ani_nivel_exercicio;
	}

	public void setAni_nivel_exercicio(String ani_nivel_exercicio) {
		this.ani_nivel_exercicio = ani_nivel_exercicio;
	}

	public String getAni_tamanho_pelo() {
		return ani_tamanho_pelo;
	}

	public void setAni_tamanho_pelo(String ani_tamanho_pelo) {
		this.ani_tamanho_pelo = ani_tamanho_pelo;
	}

	public double getAni_qtdInicAlimento() {
		return ani_qtdInicAlimento;
	}

	public void setAni_qtdInicAlimento(double ani_qtdInicAlimento) {
		this.ani_qtdInicAlimento = ani_qtdInicAlimento;
	}

	public double getAni_qtdFimAlimento() {
		return ani_qtdFimAlimento;
	}

	public void setAni_qtdFimAlimento(double ani_qtdFimAlimento) {
		this.ani_qtdFimAlimento = ani_qtdFimAlimento;
	}

	public Usuario getAni_id_usu() {
		return ani_id_usu;
	}

	public void setAni_id_usu(Usuario ani_id_usu) {
		this.ani_id_usu = ani_id_usu;
	}

	public void setAni_id(long ani_id) {
		this.ani_id = ani_id;
	}

	public String isAni_status_animal() {
		return ani_status_animal;
	}

	public void setAni_status_animal(String ani_status_animal) {
		this.ani_status_animal = ani_status_animal;
	}

	public String getAni_foto() {

		return ani_foto;
	}

	public void setAni_foto(String ani_foto) {
		this.ani_foto = ani_foto;
	}

	public String getAni_status_animal() {
		return ani_status_animal;
	}

}
