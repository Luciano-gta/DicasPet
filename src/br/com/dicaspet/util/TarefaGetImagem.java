package br.com.dicaspet.util;

import java.io.InputStream;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

//Roda um Thread a parte da principal para que não trave a inteface do usuario
public class TarefaGetImagem extends AsyncTask<String, Void, Drawable> {

	// Começa a nova Thread e realiza a tarefa;
	@Override
	protected Drawable doInBackground(String... params) {

		try {
			String link = "http://dicaspet.ddns.net:50000/fafica.dicaspet/image/"
					+ params[0];

			InputStream is = (InputStream) new URL(link).getContent();
			Drawable d = Drawable.createFromStream(is, "src name");
			return d;
		} catch (Exception e) {
			Log.i("Exc", e.getMessage());
			return null;
		}
		
	
	}

	
}
