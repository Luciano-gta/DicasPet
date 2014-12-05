package br.com.dicaspet;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PesoActivity extends Activity {
	private String porte = "pequeno";
	private String sexo = "macho";
	private String msg;
	private EditText peso;
	private double pesoAtual;

	@Override
	protected void onCreate(Bundle savedInstancestáte) {
		super.onCreate(savedInstancestáte);
		setContentView(R.layout.peso);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		final Button button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				final RadioGroup groupPorte = (RadioGroup) findViewById(R.id.radioGroupPorte);
				final RadioGroup groupSexo = (RadioGroup) findViewById(R.id.radioGroupSexo);

				groupPorte
						.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
							public void onCheckedChanged(RadioGroup group,
									int checkedId) {

								switch (checkedId) {
								case R.id.radioPequeno:
									porte = "pequeno";
									break;
								case R.id.radioMedio:
									porte = "medio";
									break;

								case R.id.radioGrande:
									porte = "grande";
									Toast.makeText(getApplicationContext(),
											"grande",
											Toast.LENGTH_SHORT).show();
									break;

								}
							}
						});

				groupSexo
						.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
							public void onCheckedChanged(RadioGroup group,
									int checkedId) {

								switch (checkedId) {
								case R.id.radioMacho:
									sexo = "macho";
									Toast.makeText(getApplicationContext(),
											"macho",
											Toast.LENGTH_SHORT).show();
									break;
								case R.id.radioFemea:
									sexo = "femea";
									Toast.makeText(getApplicationContext(),
											"femea",
											Toast.LENGTH_SHORT).show();
									break;

								}
							}

						});

				peso = (EditText) findViewById(R.id.editTextQuantPeso);
				if (!peso.getText().toString().isEmpty()) {
					pesoAtual = Double.parseDouble(peso.getText().toString());

					if (porte.equals("pequeno")) {

						if (sexo.equals("femea")) {
							if (pesoAtual > 1.5 && pesoAtual <= 9) {
								msg = "Seu animal está no peso médio ideal";
							} else if (pesoAtual > 9) {

								if (pesoAtual <= (9 * 1.1)) {
									msg = "Seu animal está acima do peso, o peso médio ideal seria entre 1.5 a 9 Kg";
								} else {
									msg = "Seu animal está obeso, o peso médio ideal seria entre 1.5 a 9 Kg";
								}
							} else {
								msg = "Animal desnutrido, o peso médio ideal seria entre 1.5 a 9 Kg";
							}

						} else {
							if (pesoAtual > 2.7 && pesoAtual < 10) {
								msg = "Seu animal está no peso médio ideal";
							} else if (pesoAtual > 10) {

								if (pesoAtual <= (10 * 1.1)) {
									msg = "Seu animal está acima do peso, o peso médio ideal seria entre 2.7 a 9.9 Kg";
								} else {
									msg = "Seu animal está obeso, o peso médio ideal seria entre 2.7 a 9.9 Kg";
								}
							} else {
								msg = "Animal desnutrido, o peso médio ideal seria entre 2.7 a 9.9 Kg";
							}
						}
					}
					if (porte.equals("medio")) {

						if (sexo.equals("femea")) {
							if (pesoAtual > 9 && pesoAtual <= 30) {
								msg = "Seu animal está no peso médio ideal";
							} else if (pesoAtual > 30) {

								if (pesoAtual <= (30 * 1.1)) {
									msg = "Seu animal está acima do peso, o peso médio ideal seria entre 9 a 30 Kg";
								} else {
									msg = "Seu animal está obeso, o peso médio ideal seria entre 9 a 30 Kg";
								}
							} else {
								msg = "Animal desnutrido, o peso médio ideal seria entre 9 a 30 Kg";
							}

						} else {
							if (pesoAtual > 10 && pesoAtual < 35) {
								msg = "Seu animal está no peso médio ideal";
							} else if (pesoAtual > 35) {

								if (pesoAtual <= (35 * 1.1)) {
									msg = "Seu animal está acima do peso, o peso médio ideal seria entre 10 a 35 Kg";
								} else {
									msg = "Seu animal está obeso, o peso médio ideal seria entre 10 a 35 Kg";
								}
							} else {
								msg = "Animal desnutrido, o peso médio ideal seria entre 10 a 35 Kg";
							}
						}
					}

					if (porte.equals("grande")) {

						if (sexo.equals("femea")) {
							if (pesoAtual > 30 && pesoAtual <= 75) {
								msg = "Seu animal está no peso médio ideal";
							} else if (pesoAtual > 75) {

								if (pesoAtual <= (75 * 1.1)) {
									msg = "Seu animal está acima do peso, o peso médio ideal seria entre 30 a 75 Kg";
								} else {
									msg = "Seu animal está obeso, o peso médio ideal seria entre 30 a 75 Kg";
								}
							} else {
								msg = "Animal desnutrido, o peso médio ideal seria entre 30 a 75 Kg";
							}

						} else {
							if (pesoAtual > 35 && pesoAtual < 90) {
								msg = "Seu animal está no peso médio ideal";
							} else if (pesoAtual > 90) {

								if (pesoAtual <= (90 * 1.1)) {
									msg = "Seu animal está acima do peso, o peso médio ideal seria entre 35 a 90 Kg";
								} else {
									msg = "Seu animal está obeso, o peso médio ideal seria entre 35 a 90 Kg";
								}
							} else {
								msg = "Animal desnutrido, o peso médio ideal seria entre 35 a 90 Kg";
							}
						}
					}

					AlertDialog alertDialog = new AlertDialog.Builder(
							PesoActivity.this).create();
					alertDialog.setTitle("Informação");
					alertDialog.setMessage(msg);
					alertDialog.setIcon(android.R.drawable.ic_dialog_info);
					
					  alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
					  "OK", new DialogInterface.OnClickListener() {
					  
					  @Override public void onClick(final DialogInterface
					  dialog, final int which) {
						  peso.setText("");
					  } });
					 alertDialog.show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Favor preencher o peso",
							Toast.LENGTH_SHORT).show();
				}
			}

		});

	}
}
