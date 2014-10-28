package br.com.dicaspet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class ReproducaoActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.lista_reproducao);

	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new GaleriaAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	
	        	startActivity(new Intent(getApplicationContext(),PerfilReprodutorActivity.class));
	        	finish();
	        	
	        	
	        	/*
	        	AlertDialog.Builder alerta = new AlertDialog.Builder(ReproducaoActivity.this);
	        	alerta.setIcon(R.drawable.ic_action_favorite);
	        	alerta.setTitle("Amigo Pet para Reprodução");
	        	alerta.setMessage("Se você clicar em OK enviaremos um e-mail para o dono do animal mostrando que você tem interesse em realizar o cruzamento com seu pet.");
	        	// Método executado se escolher Sim
	        	alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
	        	   public void onClick(DialogInterface dialog, int whichButton) {
	        	     Toast.makeText(ReproducaoActivity.this, "E-mail enviado!", Toast.LENGTH_SHORT).show();
	        	   }
	        	});
	        	// Método executado se escolher Não
	        	alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
	        	   public void onClick(DialogInterface dialog, int whichButton) {
	        	     Toast.makeText(ReproducaoActivity.this, "Email não enviado!", Toast.LENGTH_SHORT).show();
	        	   }
	        	});
	        	// Exibe o alerta de confirmação
	        	alerta.show();

	        */}
	    });
	}

}
