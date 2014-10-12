package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MeusPetsActivity extends Activity {
	private GridView grid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meus_pets);

		grid = (GridView) findViewById(R.id.gridView1);

        // Instance of ImageAdapter Class
        grid.setAdapter(new ImagemAdapter(this));
 
        // On Click event for Single Gridview Item
        grid.setOnItemClickListener(new OnItemClickListener() {
  			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int posicao,
					long arg3) {


  				switch (posicao) {

				case 0:
					startActivity(new Intent(getApplicationContext(),PerfilPetActivity.class).putExtra("posicao", 0));	
					break;
				case 1:
					startActivity(new Intent(getApplicationContext(),PerfilPetActivity.class).putExtra("posicao", 1));	
		
				default:
					
				}	
  				
			}
        });

	}
}
