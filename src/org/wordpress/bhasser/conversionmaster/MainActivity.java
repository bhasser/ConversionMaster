package org.wordpress.bhasser.conversionmaster;

import org.wordpress.bhasser.conversionmaster.R;



import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.InterstitialAd;




import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;


public class MainActivity extends Activity {
	
	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		
		
		
		Button btnGo = (Button) findViewById(R.id.btnConversionChoice);
		btnGo.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// Prepare the Interstitial Ad
				interstitial = new InterstitialAd(MainActivity.this);
				// Insert the Ad Unit ID
				interstitial.setAdUnitId("ca-app-pub-4661900116757433/3579616907");
				// Request for Ads
				AdRequest adRequest = new AdRequest.Builder().build();
				// Load ads into Interstitial Ads
				interstitial.loadAd(adRequest);
				interstitial.setAdListener(new AdListener() {
					public void onAdLoaded() {
						// Call displayInterstitial() function
						displayInterstitial();
					}
				}); 
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, MainMenu.class));
			}
		});
	}
	public void displayInterstitial() {
		    //Show Ads.
			interstitial.show();
		}
	
	public boolean onCreateOptionsMenu(MainMenu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, (Menu) menu);
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
