package br.com.dicaspet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.dicaspet.adapter.AdapterListPerfil;
import br.com.dicaspet.model.Animal;
import br.com.dicaspet.model.Mensagem;
import br.com.dicaspet.util.JSONPerfil;
import br.com.dicaspet.util.TarefaGet;

public class HomeActivity extends Activity {

	ListView listview;
	private ArrayList<Mensagem> listaMsg;
	private ArrayList<Animal> listaPets;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		// StrictMode.ThreadPolicy policy = new StrictMode.
		// ThreadPolicy.Builder().permitAll().build();
		// StrictMode.setThreadPolicy(policy);
		//Recuperar Usuario e senha
		Intent it = getIntent();
		String email = it.getStringExtra("email");
		String senha = it.getStringExtra("senha");
		String url = "http://web2.fafica-pe.edu.br:8080/br.fafica.dicaspet/service/login/"
				+ email + "/" + senha;
		// GetDados buscarPerfil = new GetDados(url);
		// Thread a parte Pegar o resultado
		TarefaGet tarefa = new TarefaGet(this);
		tarefa.execute(url);
		
		JSONPerfil jPerfil = null;
		try {
			jPerfil = new JSONPerfil(tarefa.get());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaMsg = jPerfil.getMsgs();
		listaPets = jPerfil.getAnimais();

		// Inseri e exibi dados no listview
		listview = (ListView) findViewById(R.id.homeListView);
		AdapterListPerfil adpListPerfil = new AdapterListPerfil(this, listaMsg);
		listview.setAdapter(adpListPerfil);
		listview.setTextFilterEnabled(false);
		
		
//		ArrayAdapter<String> array = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, nomes);
//		listview.setAdapter(array);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				int itemPositon = position;
				switch (itemPositon) {
				case 0:
					startActivity(new Intent(getApplicationContext(),
							PerguntaRespostaActivity.class));

					break;

				default:
					break;
				}

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.menu_home, menu);
		// return super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_home, menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		switch (id) {
		case R.id.item_pets:
			Intent it = new Intent(getApplicationContext(), ListaMeusAnimaisActivity.class);

			it.putExtra("pets", listaPets);
			startActivity(it);
			
			
//			startActivity(new Intent(getApplicationContext(),
//					ListaMeusAnimaisActivity.class));

			break;
		case R.id.item_peso:
			startActivity(new Intent(getApplicationContext(),
					PesoIdealActivity.class));
			break;
		case R.id.item_servicos:
			startActivity(new Intent(getApplicationContext(),
					ListaServicosActivity.class));
			break;
		case R.id.item_reproducao:
			startActivity(new Intent(getApplicationContext(),
					ReproducaoActivity.class));
			break;
		case R.id.item_sobre:
			startActivity(new Intent(getApplicationContext(),
					SobreActivity.class));
			break;
		case R.id.item_logout:
			finish();
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
