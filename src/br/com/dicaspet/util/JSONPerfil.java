package br.com.dicaspet.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.dicaspet.model.Animal;
import br.com.dicaspet.model.Mensagem;
import br.com.dicaspet.model.Usuario;

public class JSONPerfil {
	private ArrayList<Animal> listaAnimal = new ArrayList<Animal>();
	private ArrayList<Mensagem> listaMensagem = new ArrayList<Mensagem>();

	public JSONPerfil(String Json) throws IOException, JSONException {

		JSONObject objJson = new JSONObject(Json);

		JSONArray aPets = objJson.getJSONArray("pets");

		for (int i = 0; i < aPets.length(); i++) {
			JSONObject animal = aPets.getJSONObject(i);

			Animal pet = new Animal();

			pet.setAni_nome(animal.getString("ani_nome"));
			pet.setAni_especie(animal.getString("ani_especie"));
			pet.setAni_porte(animal.getString("ani_porte"));
			pet.setAni_peso(animal.getDouble("ani_peso"));
			pet.setAni_idade(animal.getDouble("ani_idade"));
			pet.setAni_nome(animal.getString("ani_raca"));
			pet.setAni_nome(animal.getString("ani_nome"));
			listaAnimal.add(pet);

		}

		JSONArray aMsgs = objJson.getJSONArray("msgs");

		for (int j = 0; j < aMsgs.length(); j++) {
			JSONObject msg = aMsgs.getJSONObject(j);

			Mensagem mensagem = new Mensagem();

			mensagem.setMsg_titulo(msg.getString("msg_titulo"));
			mensagem.setMsg_conteudo(msg.getString("msg_conteudo"));
			// mensagem.setMsg_data_cadastro((Date)
			// msg.get("msg_data_cadastro"));

			Usuario usuario = new Usuario();
			JSONObject usu = msg.getJSONObject("msg_id_usu");

			usuario.setUsu_id(usu.getInt("usu_id"));
			usuario.setUsu_nome(usu.getString("usu_nome"));

			mensagem.setMsg_id_usu(usuario);

			listaMensagem.add(mensagem);
		}

	}

	public ArrayList<Animal> getAnimais() {

		return (listaAnimal);

	}

	public ArrayList<Mensagem> getMsgs() {

		return (listaMensagem);
	}
}
