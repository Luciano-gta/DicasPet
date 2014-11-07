package br.com.dicaspet;

import java.util.ArrayList;

import br.com.dicaspet.model.ItemReprodutor;
import br.com.dicaspet.model.ItemReprodutor;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class ReproducaoActivity extends Activity{
	
	private ListView listView;
	private ArrayList<ItemReprodutor> itens;
	private AdapterListReprodutor adapterListReprodutor;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_reproducao);
		listView = (ListView) findViewById(R.id.listReproducao);
		
		createListView();
		
		
	
	
	}

	private void createListView() {
		itens = new ArrayList<ItemReprodutor>();
		ItemReprodutor reprodutor1 = new ItemReprodutor("Bilu", R.drawable.rp_cao, "Vira Lata", "01 anos");
		ItemReprodutor reprodutor2 = new ItemReprodutor("Rex", R.drawable.rp_cao, "Dalmata", "02 anos");
		ItemReprodutor reprodutor3 = new ItemReprodutor("Pandora", R.drawable.rp_cao, "Pit Bull", "06 meses");
		ItemReprodutor reprodutor4 = new ItemReprodutor("Mr. Peludo", R.drawable.rp_cao, "Labrador", "01 anos");

		itens.add(reprodutor1);
		itens.add(reprodutor2);
		itens.add(reprodutor3);
		itens.add(reprodutor4);
		
		adapterListReprodutor = new AdapterListReprodutor(this, itens);
		listView.setAdapter(adapterListReprodutor);
		
		
		
	}
		
		
	}
	
	
	

