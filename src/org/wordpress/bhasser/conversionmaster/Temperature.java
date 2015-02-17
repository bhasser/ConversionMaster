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

public class Temperature extends Activity {
	

	double tempEntered;
	double convertedTemp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temperature);
		final EditText temp = (EditText) findViewById(R.id.edittxtTempInput);
		final RadioButton fToC = (RadioButton) findViewById(R.id.radFtoC);
		final RadioButton cToF = (RadioButton) findViewById(R.id.radCtoF);
		final TextView result = (TextView) findViewById(R.id.txtTempResult);
		final DecimalFormat tenth = new DecimalFormat("#.##");
		
		Button calculateWeight = (Button) findViewById(R.id.btnCalculateTemp);
		calculateWeight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
		
		tempEntered = Double.parseDouble(temp.getText().toString());
		
		if (fToC.isChecked()){
			convertedTemp = (tempEntered - 32) * .5556;
			result.setText(tenth.format(convertedTemp) + " Degrees Celsius");
		}
		if (cToF.isChecked()){
			convertedTemp = (tempEntered * 1.8) + 32;
			result.setText(tenth.format(convertedTemp) + " Degrees Farenheight");
		}
			}
		});
		
		
		Button btnReturnHome = (Button) findViewById(R.id.btnReturnHome);
		btnReturnHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Temperature.this, MainMenu.class));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.temperature, menu);
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
