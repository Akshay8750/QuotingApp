package com.kavara.quotingapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quotingapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FirstActivity extends AppCompatActivity {

    private Button btnCategory;
    Button btnshr, btnadd, btnprvcy, btnrate;
    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_first);

        //google ads
        MobileAds.initialize(this);
        loadAds();


        btnCategory = findViewById(R.id.category_btn);
        btnshr = findViewById(R.id.share_btn);
        btnadd = findViewById(R.id.add_btn);
        btnprvcy = findViewById(R.id.privecy_btn);
        btnrate = findViewById(R.id.rate_btn);


        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, CategoryActivity.class));
            }
        });
        final String appLink = ("http://play.google.com/store/apps/details?id=" + this.getPackageName());
        btnshr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(intent.EXTRA_SUBJECT, "Send");
                intent.putExtra(intent.EXTRA_TEXT, appLink);
                startActivity(Intent.createChooser(intent, "Share Using"));

            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, AddQuotes.class));
            }
        });

        btnprvcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = new WebView(FirstActivity.this);
                view.getSettings().setJavaScriptEnabled(true);
                view.loadUrl("file:///android_asset/privacy_policy.html");
                setContentView(view);
            }
        });

        btnrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RateApp();
            }
        });
    }

    private void RateApp() {
        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }

    private void loadAds() {

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (view != null) {
            startActivity(new Intent(FirstActivity.this, FirstActivity.class));
        } else {
            finish();
        }
    }
}
