package com.maugarciaf.testads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.maugarciaf.testads.util.PopUpAds;

public class MainActivity extends AppCompatActivity {
    private AdView adView;
    private InterstitialAd mInterstitial;
    int counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getResources().getString(R.string.admob_app_id));

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        Button btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpAds.ShowInterstitialAds(MainActivity.this);
                Intent intplay=new Intent(getApplicationContext(),TestActivityInterstitial.class);
                startActivity(intplay);
            }
        });
    }



}
