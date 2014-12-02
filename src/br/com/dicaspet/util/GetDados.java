package br.com.dicaspet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDados {
	private String link = " ";
	private String result = " ";

	public GetDados(String link) {
		this.link = link;

	}

	public String getResult() {

		try {

			URL url = new URL(link);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(4000);
			connection.setReadTimeout(4000);

			// se true indica que enviaremos dados no corpo da requisição
			// (padrão é
			// false)
			connection.setDoOutput(false);
			// se true indica que leremos os dados da resposta (padrão é true)
			connection.setDoInput(true);
			// default é GET
			connection.setRequestMethod("GET");
			// verifica o código da reposta
			connection.connect();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader arquivo = new BufferedReader(
						new InputStreamReader(connection.getInputStream(),
								"iso-8859-1"));
				String linha = "";

				while ((linha = arquivo.readLine()) != null) {
					result += linha;
				}
				arquivo.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
