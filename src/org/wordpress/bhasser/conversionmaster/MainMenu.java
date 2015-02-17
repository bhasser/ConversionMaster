package org.wordpress.bhasser.conversionmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;


public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		final RadioButton radChooseDistance = (RadioButton) findViewById(R.id.radChooseDistance);
		final RadioButton radChooseTemp = (RadioButton) findViewById(R.id.radChooseTemp);
		final RadioButton radChooseVolume = (RadioButton) findViewById(R.id.radChooseVolume);
		final RadioButton radChooseWeight = (RadioButton) findViewById(R.id.radChooseWeight);
		Button btnConversionChoice = (Button) findViewById(R.id.btnConversionChoice);
		btnConversionChoice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(radChooseDistance.isChecked( )){
					startActivity(new Intent(MainMenu.this, Distance.class));
				}
				else if(radChooseTemp.isChecked( )){
					startActivity(new Intent(MainMenu.this, Temperature.class));
				}
				else if(radChooseVolume.isChecked( )){
					startActivity(new Intent(MainMenu.this, Volume.class));
				}
				else{
					startActivity(new Intent(MainMenu.this, Weight.class));
				}
				
			}
		});
		
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
}
