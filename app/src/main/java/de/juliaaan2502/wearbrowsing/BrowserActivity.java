package de.juliaaan2502.wearbrowsing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

import de.juliaaan2502.wearbrowsing.databinding.ActivityMainBinding;

public class BrowserActivity extends Activity {

    EditText UrlText;
    WebView Browser;
    ImageButton Search;
    ImageButton SettingsPage;
    ImageButton HomeSite;

    private ActivityMainBinding binding;

    private static class MyWebViewClient extends WebViewClient implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Browser = findViewById(R.id.webView);
        UrlText = findViewById(R.id.searchText);
        Search = findViewById(R.id.searchUrl);
        SettingsPage = findViewById(R.id.settingsPage);
        HomeSite = findViewById(R.id.homeUrl);

        Browser.loadUrl("https://www.google.com");

        Browser.getSettings().setJavaScriptEnabled(true);
        Browser.getSettings().setAppCacheEnabled(true);
        Browser.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        Browser.getSettings().setSupportZoom(true);

        Search.setOnClickListener(v -> {
            Browser.setWebViewClient(new MyWebViewClient());
            Browser.loadUrl("https://"+UrlText.getText().toString());
        });

        HomeSite.setOnClickListener(v -> {
            Browser.setWebViewClient(new MyWebViewClient());
            Browser.loadUrl("https://google.com");
        });

        SettingsPage.setOnClickListener(v -> setContentView(R.layout.settings));

        // binding = ActivityMainBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());
    }
}