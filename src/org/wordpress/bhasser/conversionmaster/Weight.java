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

public class Weight extends Activity {
	double conversionRate = 2.2;
	double weightEntered;
	double convertedWeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);
		final EditText weight = (EditText) findViewById(R.id.edittxtWeightInput);
		final RadioButton lbToKilo = (RadioButton) findViewById(R.id.radLbToKg);
		final RadioButton kiloToLb = (RadioButton) findViewById(R.id.radKgToLbs);
		final TextView result = (TextView) findViewById(R.id.txtWeightResult);
		final DecimalFormat tenth = new DecimalFormat("#.##");
		
		Button calculateWeight = (Button) findViewById(R.id.btnCalculateWeight);
		calculateWeight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
		
		weightEntered = Double.parseDouble(weight.getText().toString());
		
		if (lbToKilo.isChecked()){
			convertedWeight = weightEntered / conversionRate;
			result.setText(tenth.format(convertedWeight) + " kilograms");
		}
		if (kiloToLb.isChecked()){
			convertedWeight = weightEntered * conversionRate;
			result.setText(tenth.format(convertedWeight) + " lbs");
		}
			}
		});
		
		Button btnReturnHome = (Button) findViewById(R.id.btnReturnHome);
		btnReturnHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Weight.this, MainMenu.class));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight, menu);
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
