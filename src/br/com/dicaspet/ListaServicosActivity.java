package br.com.dicaspet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import br.com.dicaspet.adapter.AdapterListServico;
import br.com.dicaspet.model.Servico;
import br.com.dicaspet.util.JSONServico;
import br.com.dicaspet.util.TarefaGet;

public class ListaServicosActivity extends Activity {


	private MenuItem mSearchItem;
	private SearchView mSearchView;
	
	private ArrayList<Servico> listaServico;
	private AdapterListServico adpListServico;
	private String json;
	
	ListView listview;
	String[] nomes = { "PetShow", "VetClinica", "Pet-Amigo", "CãoKeRi" };

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_servicos);
		
		//Servidor FAFICA
		//String url = "http://web2.fafica-pe.edu.br:8080/br.fafica.dicaspet/service/listaServicos";
		//Servidor GIVA		
		String url = "http://dicaspet.ddns.net:50000/service/service/listaServicos";
		
		// Thread a parte Pegar o resultado
		TarefaGet tarefa = new TarefaGet(this);
		tarefa.execute(url);

		JSONServico jServico = null;
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

				jServico = new JSONServico(json);
			} catch (IOException e) {
				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
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
			} catch (JSONException e) {
				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
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

			listaServico = jServico.getServicos();
			
		}
		adpListServico = new AdapterListServico(this, listaServico);
		
		listview = (ListView) findViewById(R.id.lista_servicos);
		listview.setAdapter(adpListServico);
		listview.setTextFilterEnabled(false);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				int itemPositon = position;
				switch (itemPositon) {
				case 0:
					startActivity(new Intent(getApplicationContext(),EmpresaActivity.class));
					finish();
					break;

				default:
					break;
				}

			}

		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	  MenuInflater inflater = getMenuInflater();
	  inflater.inflate(R.menu.menu_servicos, menu);
	  mSearchItem = menu.findItem(R.id.search);
	  mSearchView = (SearchView) mSearchItem.getActionView();
	  mSearchView.setOnQueryTextListener(new OnQueryTextListener() {

	      @Override
	      public boolean onQueryTextSubmit(String query) {
	        Toast.makeText(ListaServicosActivity.this, "Busca por: " + query,Toast.LENGTH_LONG).show();
	        mSearchItem.collapseActionView();
	        return true;
	      }

	      @Override
	      public boolean onQueryTextChange(String query) {
	        return false;
	      }
	  });

	  return super.onCreateOptionsMenu(menu);
	}


}
