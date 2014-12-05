package br.com.dicaspet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.dicaspet.adapter.AdapterListReprodutor;
import br.com.dicaspet.model.Animal;
import br.com.dicaspet.util.JSONReproducao;
import br.com.dicaspet.util.TarefaGet;

public class ReproducaoActivity extends Activity {

	private ListView listView;
	private ArrayList<Animal> listReprodutor;
	private AdapterListReprodutor AdpterListReprodutor;
	private Animal pet;
	private String json;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_reprodutor);
		pet = (Animal) getIntent().getSerializableExtra("pet");

		// Servidor FAFICA
		String url = "http://web2.fafica-pe.edu.br:8080/br.fafica.dicaspet/service/reproducao/"
		// Servidor GIVA
		//String url = "http://dicaspet.ddns.net:50000/service/service/reproducao/"
				+ pet.getAni_raca() + "/" + pet.getAni_sexo();

		// Thread a parte Pegar o resultado
		TarefaGet tarefa = new TarefaGet(this);
		tarefa.execute(url);

		JSONReproducao jReproducao = null;
		try {
			json = tarefa.get();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!json.isEmpty()) {

			try {

				jReproducao = new JSONReproducao(json);
			} catch (IOException e) {
				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
				alertDialog.setTitle("Erro");
				alertDialog
						.setMessage("Ocorreu um problema ao tentar buscar as informações.\n"

								+ "Verifique sua conexão e tente novamente!"
								+ e.getMessage());
				alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
				alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(final DialogInterface dialog,
									final int which) {
								finish();
							}
						});
				alertDialog.show();
				e.printStackTrace();
			} catch (JSONException e) {

				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
				alertDialog.setTitle("Erro");
				alertDialog
						.setMessage("Ocorreu um problema ao tentar buscar as informações.\n"

								+ "Verifique sua conexão e tente novamente!"
								+ e.getMessage());
				alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
				alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(final DialogInterface dialog,
									final int which) {
								finish();
							}
						});
				alertDialog.show();
				e.printStackTrace();
			}

			listReprodutor = jReproducao.getReprodutores();

			AdpterListReprodutor = new AdapterListReprodutor(this,
					listReprodutor);
			listView = (ListView) findViewById(R.id.listReproducao);
			listView.setAdapter(AdpterListReprodutor);
			listView.setTextFilterEnabled(false);
			
	
			
		} else {

			String[] lista = { "Não encontramos Pets compatíveis " };
			listView = (ListView) findViewById(R.id.listReproducao);
			listView.setAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, lista));
			listView.setTextFilterEnabled(false);
		}

	}
}
