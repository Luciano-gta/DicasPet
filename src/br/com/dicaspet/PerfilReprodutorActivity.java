package br.com.dicaspet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PerfilReprodutorActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil_do_reprodutor);
		
		Button botao = (Button) findViewById(R.id.bt_reprodutor);
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				AlertDialog.Builder alerta = new AlertDialog.Builder(PerfilReprodutorActivity.this);
	        	alerta.setIcon(R.drawable.ic_action_favorite);
	        	alerta.setTitle("Amigo Pet para Reprodu��o");
	        	alerta.setMessage("Se voc� clicar em OK enviaremos um e-mail para o dono do animal mostrando que voc� tem interesse em realizar o cruzamento com seu pet.");
	        	// M�todo executado se escolher Sim
	        	alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
	        	   public void onClick(DialogInterface dialog, int whichButton) {
	        	     Toast.makeText(PerfilReprodutorActivity.this, "E-mail enviado!", Toast.LENGTH_SHORT).show();
	        	   }
	        	});
	        	// M�todo executado se escolher N�o
	        	alerta.setNegativeButton("N�o", new DialogInterface.OnClickListener() {
	        	   public void onClick(DialogInterface dialog, int whichButton) {
	        	     Toast.makeText(PerfilReprodutorActivity.this, "Email n�o enviado!", Toast.LENGTH_SHORT).show();
	        	   }
	        	});
	        	// Exibe o alerta de confirma��o
	        	alerta.show();
			}
		});
			
		
	}
}
