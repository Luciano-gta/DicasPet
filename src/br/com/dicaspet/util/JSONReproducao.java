package br.com.dicaspet.util;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.dicaspet.model.Animal;
import br.com.dicaspet.model.Usuario;

public class JSONReproducao {

	private ArrayList<Animal> listaReproducao = new ArrayList<Animal>();

	public JSONReproducao(String Json) throws IOException, JSONException {

		JSONObject reproducao = new JSONObject(Json);
		JSONArray aReproducao = reproducao.getJSONArray("animal");

		for (int i = 0; i < aReproducao.length(); i++) {
			JSONObject reprodutor = aReproducao.getJSONObject(i);

			Animal pet = new Animal();

			pet.setAni_nome(reprodutor.getString("ani_nome"));
			pet.setAni_especie(reprodutor.getString("ani_especie"));
			pet.setAni_porte(reprodutor.getString("ani_porte"));
			pet.setAni_peso(reprodutor.getDouble("ani_peso"));
			pet.setAni_idade(reprodutor.getDouble("ani_idade"));
			pet.setAni_raca(reprodutor.getString("ani_raca"));
			pet.setAni_sexo(reprodutor.getString("ani_sexo"));
			pet.setAni_foto(reprodutor.getString("ani_foto"));

			Usuario usuario = new Usuario();
			if (!reprodutor.isNull("ani_id_usu")) {
				JSONObject usu = reprodutor.getJSONObject("ani_id_usu");

				usuario.setUsu_id(usu.getInt("usu_id"));
				usuario.setUsu_nome(usu.getString("usu_nome"));
				usuario.setUsu_email(usu.getString("usu_email"));
			}
			pet.setAni_id_usu(usuario);

			listaReproducao.add(pet);
		}
	}

	public ArrayList<Animal> getReprodutores() {

		return (listaReproducao);

	}

}
