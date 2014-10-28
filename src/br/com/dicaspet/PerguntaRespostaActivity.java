package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PerguntaRespostaActivity extends Activity{
	
	ListView listview;
	String[] nomes = { "Ligue pra PetShow (81)4033-6903", "Joga um balde de água fria nele", "Com shampoo e condicionador :D", "Sei lá, pergunta pra ele :P" };

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pergunta_respostas);
		listview = (ListView) findViewById(R.id.PerguntaRespostalistView);
		ArrayAdapter<String> array = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomes);
		listview.setAdapter(array);
	}
}
