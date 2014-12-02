package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText ETemail;
	EditText ETsenha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		ETemail = (EditText)findViewById(R.id.editMail);
		ETsenha = (EditText)findViewById(R.id.editSenhaMail);
		
		final Button botao = (Button) findViewById(R.id.button1);
		botao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(getApplicationContext(),
						HomeActivity.class);
				String email = ETemail.getText().toString();
				String senha = ETsenha.getText().toString();
				if(!email.isEmpty() && !senha.isEmpty()){
					it.putExtra("email", email);
					it.putExtra("senha", senha);
					startActivity(it);
					finish();
				}else{
					Toast.makeText(getApplicationContext(), "Favor preencher o usu�rio e senha", Toast.LENGTH_SHORT).show();
				}


			}
		});
	}
}
