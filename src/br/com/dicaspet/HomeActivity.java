package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	}	
	
	
	   @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.menu_home, menu);
	        return super.onCreateOptionsMenu(menu);

	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        
	        switch (id) {
			case R.id.item_pets:
				Toast.makeText(this, "Meus Pets", Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_peso:
				//startActivity(new Intent(getApplicationContext(),PesoActivity.class));
				Toast.makeText(this, "Peso Idel", Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_reproducao:
				Toast.makeText(this, "Lista Reprodução", Toast.LENGTH_SHORT).show();
				break;
			case R.id.item_servicos:
				Toast.makeText(this, "Lista Serviços", Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
	        
	        return super.onOptionsItemSelected(item);
	    }
}
