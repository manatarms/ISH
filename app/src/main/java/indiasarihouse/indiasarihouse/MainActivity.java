package indiasarihouse.indiasarihouse;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private ProgressBar progressBar;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    //initialize webview and progress bar
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        progressBar.setMax(100);


        // Get Web view
        mWebView = (WebView) findViewById( R.id.webView ); //This is the id you gave
        mWebView.setWebViewClient(new WebViewClientDemo());
        mWebView.setWebChromeClient(new WebChromeClientDemo());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.indiasarihouse.com");
        //mWebView.getSettings().setSupportZoom(true);		 //Zoom Control on web (You don't need this
        //if ROM supports Multi-Touch
       // mWebView.getSettings().setBuiltInZoomControls(true); //Enable Multitouch if supported by ROM

        // Load URL
    }//onCreate


    private class WebViewClientDemo extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            progressBar.setProgress(100);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }
    }
        private class WebChromeClientDemo extends WebChromeClient {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(progress);
            }

    }

    //Handle navigation
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        else {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    //Builtin methods
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}


