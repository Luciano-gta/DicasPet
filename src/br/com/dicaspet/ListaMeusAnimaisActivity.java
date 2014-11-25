package br.com.dicaspet;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import br.com.dicaspet.adapter.AdapterListMeuPets;
import br.com.dicaspet.model.Animal;

public class ListaMeusAnimaisActivity extends Activity {
	private AdapterListMeuPets adapterMeusPets;
	ListView listview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_animais);
		@SuppressWarnings("unchecked")
		ArrayList<Animal> listaAnimal = (ArrayList<Animal>) getIntent().getSerializableExtra("pets");
		listview = (ListView) findViewById(R.id.lista_animais);

		// listaAnimal = ;
		adapterMeusPets = new AdapterListMeuPets(this, listaAnimal);
		listview.setAdapter(adapterMeusPets);
		listview.setTextFilterEnabled(false);
		// ArrayAdapter<String> array = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, nomes);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				/*
				 * // ListView Clicked item index int itemPosition = position;
				 * 
				 * // ListView Clicked item value String itemValue = (String)
				 * listview.getItemAtPosition(position);
				 * 
				 * // Show Alert Toast.makeText(getApplicationContext(),
				 * "Position :"+itemPosition+"  ListItem : " +itemValue ,
				 * Toast.LENGTH_LONG) .show();
				 */

				int itemPositon = position;
				switch (itemPositon) {
				case 0:
					startActivity(new Intent(getApplicationContext(),
							PerfilAnimalActivity.class));
					finish();
					break;

				default:
					break;
				}

			}

		});
	}
}
