package org.wordpress.bhasser.conversionmaster;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Volume extends Activity {
	
	double conversionRate = 0.033814;
	double volumeEntered;
	double convertedVolume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_volume);
		final EditText volume = (EditText) findViewById(R.id.edittxtVolumeInput);
		final RadioButton ozToMl = (RadioButton) findViewById(R.id.radOzToMl);
		final RadioButton mlToOz = (RadioButton) findViewById(R.id.radMlToOz);
		final TextView result = (TextView) findViewById(R.id.txtVolumeResult);
		final DecimalFormat tenth = new DecimalFormat("#.##");
		
		
		Button calculateVolume = (Button) findViewById(R.id.btnCalculateVolume);
		calculateVolume.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
		
		volumeEntered = Double.parseDouble(volume.getText().toString());
		
		if (ozToMl.isChecked()){
			convertedVolume = volumeEntered / conversionRate;
			result.setText(tenth.format(convertedVolume) + " Mililiters");
		}
		if (mlToOz.isChecked()){
			convertedVolume = volumeEntered * conversionRate;
			result.setText(tenth.format(convertedVolume) + " Fluid Ounces");
		}
			}
		});
		
		
		Button btnReturnHome = (Button) findViewById(R.id.btnReturnHome);
		btnReturnHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Volume.this, MainMenu.class));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.volume, menu);
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
