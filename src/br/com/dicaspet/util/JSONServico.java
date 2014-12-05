package br.com.dicaspet.util;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.dicaspet.model.Servico;
import br.com.dicaspet.model.Usuario;

public class JSONServico {
	
	private ArrayList<Servico> listaServico = new ArrayList<Servico>();
	
	public JSONServico(String Json) throws IOException, JSONException {
		
		
		JSONObject servicos = new JSONObject(Json);
		JSONArray aServico = servicos.getJSONArray("servico");
		
		
		for (int i = 0; i < aServico.length(); i++) {
			JSONObject prestador = aServico.getJSONObject(i);
			

			Servico servico = new Servico();

			servico.setSrv_descricao(prestador.getString("srv_descricao"));
			servico.setSrv_preco(prestador.getDouble("srv_preco"));
			servico.setSrv_categoria(prestador.getString("srv_categoria"));
			servico.setSrv_pontuacao(prestador.getInt("srv_pontuacao"));
			
			Usuario usuario = new Usuario();
			JSONObject usu = prestador.getJSONObject("srv_id_prtsrv");

			usuario.setUsu_id(usu.getInt("usu_id"));
			usuario.setUsu_nome(usu.getString("usu_nome"));
			usuario.setUsu_email(usu.getString("usu_email"));
			
			servico.setSrv_id_prtsrv(usuario);
			
			
			
			listaServico.add(servico);
		}
	}
	public ArrayList<Servico> getServicos() {

		return (listaServico);

	}



	
}
