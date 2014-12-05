package br.com.dicaspet;

import java.util.concurrent.ExecutionException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.dicaspet.model.Animal;
import br.com.dicaspet.util.TarefaGetImagem;

public class PerfilPetActivity extends Activity {

	private TextView ani_nome;
	private TextView ani_especie;
	private TextView ani_porte;
	private TextView ani_peso;
	private TextView ani_idade;
	private TextView ani_raca;
	private TextView ani_sexo;
	private ImageView ani_foto;
	private Animal pet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil_do_animal);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		pet = (Animal) getIntent().getSerializableExtra("pet");

		ani_nome = (TextView) findViewById(R.id.textViewNomePet);
		ani_especie = (TextView) findViewById(R.id.TextViewEspeciePet);
		ani_porte = (TextView) findViewById(R.id.TextViewPortePet);
		ani_peso = (TextView) findViewById(R.id.TextViewPesoPet);
		ani_idade = (TextView) findViewById(R.id.TextViewIdadePet);
		ani_raca = (TextView) findViewById(R.id.TextViewRacaPet);
		ani_sexo = (TextView) findViewById(R.id.TextViewSexoPet);
		ani_foto = (ImageView) findViewById(R.id.imageViewPet);

		ani_nome.setText(pet.getAni_nome());
		ani_especie.setText(pet.getAni_especie());
		ani_porte.setText(pet.getAni_porte());
		ani_peso.setText(Double.toString(pet.getAni_peso()));
		ani_idade.setText(Double.toString(pet.getAni_idade()));
		ani_raca.setText(pet.getAni_raca());
		if (pet.getAni_sexo().equalsIgnoreCase("F")) {
			ani_sexo.setText("Fêmea");
		} else {
			ani_sexo.setText("Macho");
		}

		if (pet.getAni_foto().isEmpty()) {
			ani_foto.setImageResource(R.drawable.ic_img_pet);
		} else {
			 
			Drawable drawable;
			try {
				drawable = new TarefaGetImagem().execute(pet.getAni_foto()).get();
				ani_foto.setImageDrawable(drawable);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}

		final Button button = (Button) findViewById(R.id.buttonBuscar_par);

		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent(getApplicationContext(),
						ReproducaoActivity.class);
				it.putExtra("pet", pet);
				startActivity(it);
				
			}
		});

	}

	
}
