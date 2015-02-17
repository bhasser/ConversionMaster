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

public class Distance extends Activity {
	
	double conversionRate = 0.62137;
	double distanceEntered;
	double convertedDistance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
		final EditText distance = (EditText) findViewById(R.id.distanceInput);
		final RadioButton mileToKm = (RadioButton) findViewById(R.id.radMilesToKm);
		final RadioButton kmToMile = (RadioButton) findViewById(R.id.radKmToMiles);
		final TextView result = (TextView) findViewById(R.id.txtDistanceResult);
		final DecimalFormat tenth = new DecimalFormat("#.##");
		
		Button calculateDistance = (Button) findViewById(R.id.btnCalculateDistance);
		calculateDistance.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
		
		distanceEntered = Double.parseDouble(distance.getText().toString());
		
		if (mileToKm.isChecked()){
			convertedDistance = distanceEntered / conversionRate;
			result.setText(tenth.format(convertedDistance) + " Kilometers");
		}
		if (kmToMile.isChecked()){
			convertedDistance = distanceEntered * conversionRate;
			result.setText(tenth.format(convertedDistance) + " Miles");
		}
			}
		});
		
		
		Button btnReturnHome = (Button) findViewById(R.id.btnReturnHome);
		btnReturnHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Distance.this, MainMenu.class));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.distance, menu);
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
