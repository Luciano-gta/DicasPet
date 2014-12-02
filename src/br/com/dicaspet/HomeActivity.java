package br.com.dicaspet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;
import br.com.dicaspet.adapter.AdapterListPerfil;
import br.com.dicaspet.model.Animal;
import br.com.dicaspet.model.ItemResposta;
import br.com.dicaspet.model.Mensagem;
import br.com.dicaspet.model.Usuario;
import br.com.dicaspet.util.JSONPerfil;
import br.com.dicaspet.util.TarefaGet;

public class HomeActivity extends Activity {

	private ListView listview;
	private ArrayList<Mensagem> listaMsg;
	private ArrayList<Animal> listaPets;
	private AdapterListPerfil adpListPerfil;
	private long clickVoltar = 0;
	private Toast aviso;
	private Usuario usuario;
	private TextView nome_user;
	private TextView email_user;
	private TextView pontuacao_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// StrictMode.ThreadPolicy policy = new StrictMode.
		// ThreadPolicy.Builder().permitAll().build();
		// StrictMode.setThreadPolicy(policy);
		// Recuperar Usuario e senha
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
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Erro");
			alertDialog
					.setMessage("Ocorreu um problema ao tentar buscar as informações.\n"

							+ "Verifique sua conexão e tente novamente!");
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
		} catch (ExecutionException e) {
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Erro");
			alertDialog
					.setMessage("Ocorreu um problema ao tentar buscar as informações.\n"

							+ "Verifique sua conexão e tente novamente!");
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
		setContentView(R.layout.home);

		listaMsg  = jPerfil.getMsgs();
		listaPets = jPerfil.getAnimais();
		usuario   = jPerfil.getUserlogado();

		// Inseri e exibi dados no listview
		listview       = (ListView) findViewById(R.id.homeListView);
		nome_user      = (TextView) findViewById(R.id.textViewNome);
		email_user     = (TextView) findViewById(R.id.textViewEmail);
		pontuacao_user = (TextView) findViewById(R.id.textViewPontuacao);
		
		nome_user.setText(usuario.getUsu_nome());
		email_user.setText(usuario.getUsu_email());
		pontuacao_user.setText(usuario.getUsu_pontuacao().toString());
		
		adpListPerfil = new AdapterListPerfil(this, listaMsg);
		listview.setAdapter(adpListPerfil);
		listview.setTextFilterEnabled(false);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent it = new Intent(getApplicationContext(),
						PerguntaRespostaActivity.class);

				ArrayList<ItemResposta> aRespostas = new ArrayList<ItemResposta>();
				Mensagem mensagem = (Mensagem) adpListPerfil.getItem(position);

				//String nome_user, int iconeRid, String data, String resposta
				ItemResposta resposta = new ItemResposta(mensagem
						.getMsg_id_usu().getUsu_nome(), 1, mensagem
						.getMsg_data_cadastro(),mensagem.getMsg_conteudo());

				aRespostas.add(resposta);
				
				it.putExtra("respostas", aRespostas);
				it.putExtra("titulo", mensagem.getMsg_titulo());

				startActivity(it);

			}

		});

	}

	@Override
	public void onBackPressed() {

		if (clickVoltar < System.currentTimeMillis() - 4000) {
			aviso = Toast.makeText(this,
					"Pressione Voltar novamente para fechar a aplicação",
					Toast.LENGTH_LONG);
			aviso.show();
			clickVoltar = System.currentTimeMillis();
		} else {
			if (aviso != null) {
				aviso.cancel();
			}
			super.onBackPressed();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.menu_home, menu);
		// return super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_home, menu);

		// Pega o Componente.
		SearchView mSearchView = (SearchView) menu.findItem(R.id.search)
				.getActionView();
		// Define um texto de ajuda:
		mSearchView.setQueryHint("Pesquisar Dicas...");

		// exemplos de utilização:

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

		mSearchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
		// mSearchView.setSubmitButtonEnabled(true); Exibi o botão de submit
		mSearchView.setOnQueryTextListener(new SearchFiltro());

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
			Intent it = new Intent(getApplicationContext(),
					ListaMeusAnimaisActivity.class);

			it.putExtra("pets", listaPets);
			startActivity(it);

			// startActivity(new Intent(getApplicationContext(),
			// ListaMeusAnimaisActivity.class));

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

	// Quando digita-se no SearchView
	private class SearchFiltro implements OnQueryTextListener {

		// A medida em que vou digitando
		@Override
		public boolean onQueryTextChange(String arg0) {
			adpListPerfil.getFilter().filter(arg0);
			return false;
		}

		// Ao pressionar botão submit
		@Override
		public boolean onQueryTextSubmit(String arg0) {
			// adapterCustom.getFilter().filter(arg0);
			return true;
		}

	}
}
