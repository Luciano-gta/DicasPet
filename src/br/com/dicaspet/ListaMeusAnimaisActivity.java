package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaMeusAnimaisActivity extends Activity {

	ListView listview;
	String[] nomes = {"Brutos","Leci", "Pingo"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_animais);
		listview = (ListView) findViewById(R.id.lista_animais);
		ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
		listview.setAdapter(array);
		
		 listview.setOnItemClickListener(new OnItemClickListener() {
			 
             @Override
             public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
               
              /* // ListView Clicked item index
              int itemPosition = position;
              
              // ListView Clicked item value
              String  itemValue = (String) listview.getItemAtPosition(position);
                 
               // Show Alert 
               Toast.makeText(getApplicationContext(),
                 "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                 .show();
                 */
            
            	 int itemPositon = position;
            	 switch (itemPositon) {
     				case 0:
     				startActivity(new Intent(getApplicationContext(), PerfilAnimalActivity.class));
     				finish();
     				break;
     			
     		
     			default:
     				break;
     			}
            	 
             }

        }); 
	}
}
