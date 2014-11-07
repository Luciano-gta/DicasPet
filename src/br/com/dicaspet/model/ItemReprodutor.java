package br.com.dicaspet.model;

public class ItemReprodutor {

	private String nome_reprodutor;
	private int iconeRid;
	private String raca;
	private String idade;
	
	public ItemReprodutor(String nome_reprodutor, int iconeRid, String raca, String idade) {
		// TODO Auto-generated constructor stub
		this.nome_reprodutor = nome_reprodutor;
		this.iconeRid = iconeRid;
		this.raca = raca;
		this.idade = idade;
	
	}

	public String getNome_reprodutor() {
		return nome_reprodutor;
	}

	public void setNome_reprodutor(String nome_reprodutor) {
		this.nome_reprodutor = nome_reprodutor;
	}

	public int getIconeRid() {
		return iconeRid;
	}

	public void setIconeRid(int iconeRid) {
		this.iconeRid = iconeRid;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	
}
