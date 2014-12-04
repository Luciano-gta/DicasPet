package br.com.dicaspet;

import java.io.InputStream;
import java.net.URL;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.dicaspet.model.Animal;

public class PerfilPetActivity extends Activity {
	
	private TextView ani_nome;
	private TextView ani_especie;
	private TextView ani_porte;
	private TextView ani_peso;
	private TextView ani_idade;
	private TextView ani_raca;
	private TextView ani_sexo;
	private ImageView ani_foto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil_do_animal);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		Animal pet = (Animal) getIntent().getSerializableExtra("pet");

		ani_nome    = (TextView) findViewById(R.id.textViewNomePet);
		ani_especie = (TextView) findViewById(R.id.TextViewEspeciePet); 
		ani_porte   = (TextView) findViewById(R.id.TextViewPortePet); 
		ani_peso    = (TextView) findViewById(R.id.TextViewPesoPet);
		ani_idade   = (TextView) findViewById(R.id.TextViewIdadePet);
		ani_raca    = (TextView) findViewById(R.id.TextViewRacaPet);
		ani_sexo    = (TextView) findViewById(R.id.TextViewSexoPet);
		ani_foto    = (ImageView) findViewById(R.id.imageViewPet);

		ani_nome.setText(pet.getAni_nome());
		ani_especie.setText(pet.getAni_especie());
		ani_porte.setText(pet.getAni_porte());
		ani_peso.setText(Double.toString(pet.getAni_peso()));
		ani_idade.setText(Double.toString(pet.getAni_idade()));
		ani_raca.setText(pet.getAni_raca());
		ani_sexo.setText(pet.getAni_sexo());
		if(pet.getAni_foto().isEmpty()){
			ani_foto.setImageResource(R.drawable.ic_img_pet);
		}else{
			Drawable drawable = LoadImageFromWebOperations(pet.getAni_foto());
			ani_foto.setImageDrawable(drawable);	
		}

	}
	private Drawable LoadImageFromWebOperations(String url)
	  {
	      try
	      {
	          InputStream is = (InputStream) new URL(url).getContent();
	          Drawable d = Drawable.createFromStream(is, "src name");
	          return d;
	      }catch (Exception e) {
	          System.out.println("Exc="+e);
	          return null;
	      }
	  }

}
