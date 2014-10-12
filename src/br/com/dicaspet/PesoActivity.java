package br.com.dicaspet;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class PesoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.peso);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
}
