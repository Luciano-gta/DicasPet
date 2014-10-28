package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HomeActivity extends Activity{

	ListView listview;
	String[] nomes = { "Como dar banho no meu cão?", "Meu passarinho não quer voar.", "Cachorro muito agitado, o que fazer?", "Como dar banho no meu gato?" };


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		listview = (ListView) findViewById(R.id.homeListView1);
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
					startActivity(new Intent(getApplicationContext(),PerguntaRespostaActivity.class));
				
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
		  //getMenuInflater().inflate(R.menu.menu_home, menu);
		   //return super.onCreateOptionsMenu(menu);
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
			case R.id.meuspets:
				startActivity(new Intent(getApplicationContext(),ListaMeusAnimaisActivity.class));
				
				break;
			case R.id.pesoideal:
				startActivity(new Intent(getApplicationContext(),PesoIdealActivity.class));
				break;
			case R.id.servicos:
				startActivity(new Intent(getApplicationContext(),ListaServicosActivity.class));
				break;
			case R.id.reproducao:
				startActivity(new Intent(getApplicationContext(),ReproducaoActivity.class));
				break;
		
			default:
				break;
			}
	        
	        return super.onOptionsItemSelected(item);
	    }
}
