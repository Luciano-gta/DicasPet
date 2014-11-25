package br.com.dicaspet;

import java.util.ArrayList;

import br.com.dicaspet.adapter.AdapterListResposta;
import br.com.dicaspet.model.ItemResposta;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class PerguntaRespostaActivity extends Activity{ 
		
	/*
}
	ListView listview;
	String[] nomes = { "Ligue pra PetShow (81)4033-6903", "Joga um balde de �gua fria nele", "Com shampoo e condicionador :D", "Sei l�, pergunta pra ele :P" };

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pergunta_respostas);
		listview = (ListView) findViewById(R.id.PerguntaRespostalistView);
		ArrayAdapter<String> array = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, nomes);
		listview.setAdapter(array);
	}
	*/
	
	
	private ListView listView;
	private ArrayList<ItemResposta> itens;
	private AdapterListResposta adapterListResposta;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pergunta_respostas);
		listView = (ListView) findViewById(R.id.PerguntaRespostalistView);
		
		createListView();
		
	
	
	}

	private void createListView() {
		itens = new ArrayList<ItemResposta>();
		ItemResposta resposta1 = new ItemResposta("Jos� Ferreiro", R.drawable.user_foto, "01/11/2014", "Leve seu bixinho para fazer uma visita ao veterin�rio, acredito que ele precisa fazer alguns exames, Leve seu bixinho para fazer uma visita ao veterin�rio, acredito que ele precisa fazer alguns exames");
		ItemResposta resposta2 = new ItemResposta("Maria Fontes", R.drawable.user_foto, "01/11/2014", "Leve seu bixinho para fazer uma visita ao veterin�rio, acredito que ele precisa fazer alguns exames");
		ItemResposta resposta3 = new ItemResposta("Emanuel Pe�anha", R.drawable.user_foto, "01/11/2014", "Leve seu bixinho para fazer uma visita ao veterin�rio, acredito que ele precisa fazer alguns exames");
		ItemResposta resposta4 = new ItemResposta("Maria Jos�", R.drawable.user_foto, "01/11/2014", "Leve seu bixinho para fazer uma visita ao veterin�rio, acredito que ele precisa fazer alguns exames");

		itens.add(resposta1);
		itens.add(resposta2);
		itens.add(resposta3);
		itens.add(resposta4);
		
		adapterListResposta = new AdapterListResposta(this, itens);
		listView.setAdapter(adapterListResposta);
		
		
		
	}
	
}
