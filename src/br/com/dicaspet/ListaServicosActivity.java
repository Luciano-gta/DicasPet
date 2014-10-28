package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class ListaServicosActivity extends Activity {


	private MenuItem mSearchItem;
	private SearchView mSearchView;
	ListView listview;
	String[] nomes = { "PetShow", "VetClinica", "Pet-Amigo", "CãoKeRi" };

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_servicos);

		listview = (ListView) findViewById(R.id.lista_animais);
		ArrayAdapter<String> array = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomes);
		listview.setAdapter(array);

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
