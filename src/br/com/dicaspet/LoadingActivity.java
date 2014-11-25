package br.com.dicaspet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;


public class LoadingActivity extends Activity {
	ProgressBar pgr;
	int progress=0;
	Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        Thread splash_screen = new Thread(){
        	public void run(){
        		try {
					sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					startActivity(new Intent(getApplicationContext(),LoginActivity.class));
					finish();
				}
        	}
        };
        
        splash_screen.start();

		/*        
        pgr=(ProgressBar)findViewById(R.id.progressBar1);
        new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					progress += 20;
					h.post(new Runnable() {
						
						@Override
						public void run() {
							pgr.setProgress(progress);
							if(progress==pgr.getMax()){
								//pgr.setVisibility(4);
								startActivity(new Intent(getApplicationContext(), LoginActivity.class));
								finish();
							}
							
						}
					});
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						
					}
				}
			}
		}).start();
        		*/

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loading, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */
}
