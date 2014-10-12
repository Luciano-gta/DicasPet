package br.com.dicaspet;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class PerfilPetActivity extends Activity{
	private ImageView imagem ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil_pet);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		imagem = (ImageView) findViewById(R.id.imageView1);
		
		Intent it = getIntent();
		int posicao= it.getIntExtra("posicao", 0);

		switch (posicao) {
		case 0:
			imagem.setImageResource(R.drawable.ic_cachorro);
			break;
		case 1:
			imagem.setImageResource(R.drawable.ic_gato);
			break;

		default:
			break;
		}
	
		
	}

}
