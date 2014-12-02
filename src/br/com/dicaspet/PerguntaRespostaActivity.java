package br.com.dicaspet;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.dicaspet.model.ItemResposta;

public class PerguntaRespostaActivity extends Activity {

	private TextView nome_user;
	private TextView data_resposta;
	private TextView resposta;
	private TextView titulo;
	private ImageView img_user;
	//TODO Verificar a imagem do usuario

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_resposta);
	
		@SuppressWarnings("unchecked")
		ArrayList<ItemResposta> listaresposta = (ArrayList<ItemResposta>) getIntent()
				.getSerializableExtra("respostas");
		String tituloPerg = (String) getIntent().getStringExtra("titulo");
		
		
		nome_user     = (TextView) findViewById(R.id.usuario_resposta);
		data_resposta = (TextView) findViewById(R.id.data_resposta);
		resposta      = (TextView) findViewById(R.id.resposta);
		img_user	  = (ImageView) findViewById(R.id.image_usuario_resposta);
		titulo    = (TextView) findViewById(R.id.TextViewTituloResp);
		
		nome_user.setText(listaresposta.get(0).getNome_user());
		data_resposta.setText(listaresposta.get(0).getData());
		resposta.setText(listaresposta.get(0).getResposta());
		titulo.setText(tituloPerg);
		

	}

}
