package br.com.dicaspet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

//Roda um Thread a parte da principal para que n�o trave a inteface do usuario
public class TarefaGet extends AsyncTask<String, String, String> {
	private Context context;
	private ProgressDialog progressDialog;

	public TarefaGet(Context contexto) {
		this.context = contexto;
	}

	// Aqui ainda est� na Thread principal
	@Override
	protected void onPreExecute() {
		this.progressDialog = ProgressDialog.show(context, "Aguarde...",
				"Buscando Informa��es");
		super.onPreExecute();
	}

	// Come�a a nova Thread e realiza a tarefa;
	@Override
	protected String doInBackground(String... params) {
		String linha2 = "";
		try {
			String link = params[0];

			URL url = new URL(link);
			
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			
			// se true indica que enviaremos dados no corpo da requisi��o
			// (padr�o �
			// false)
			connection.setDoOutput(false);
			// se true indica que leremos os dados da resposta (padr�o � true)
			connection.setDoInput(true);
			// default � GET
			connection.setRequestMethod("GET");
			// verifica o c�digo da reposta
			connection.connect();
			
			linha2 = "";
			

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader arquivo = new BufferedReader(
						new InputStreamReader(connection.getInputStream(),
								"iso-8859-1"));
				String linha = "";

				while ((linha = arquivo.readLine()) != null) {
					linha2 += linha;
				}
				arquivo.close();
			} 
		} catch (IOException e) {
			publishProgress("Problema ao tentar se conectar...");
			e.printStackTrace();
		}
		return linha2;
	}

	// Termina e Thread e pega seu retorno
	@Override
	protected void onPostExecute(String result) {
		progressDialog.setMessage("Finalizado!");
		progressDialog.dismiss();
		super.onPostExecute(result);
	}

}
