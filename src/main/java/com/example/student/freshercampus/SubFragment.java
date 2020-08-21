package com.example.student.freshercampus;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SubFragment extends Fragment {
    public WebView mWebview;
    Handler uiHandler = new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sub, container, false);
        getActivity().setTitle("HOME");
        mWebview=(WebView)v.findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new MyWebViewClient());
        new BackgroundWorker().execute();
        return v;
    }
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @RequiresApi(21)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return false;
        }
    }

    private class BackgroundWorker extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            getDarewod();
            return null;
        }

        public void getDarewod(){

            try {
                Document htmlDocument = Jsoup.connect("http://freshercampus.com/index.php").get();
                Element element = htmlDocument.select("#pop > div.row").first();

                // replace body with selected element
                htmlDocument.body().empty().append(element.toString());
                final String html = htmlDocument.toString();

                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mWebview.loadUrl("javascript:(function() { " +
                                "document.getElementById('header')[0].style.display='block'; " +
                                "})()");
                        //mWebview.loadUrl("http://freshercampus.com/index.php");
                        mWebview.loadData(html, "text/html", "UTF-8");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

  /*mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                mWebview.loadUrl("javascript:(function() { " +
                        "document.getElementById('col-sm-8')[0].style.display='block'; " +
                        "})()");
            }
        });*/
//mWebview.loadUrl("http://freshercampus.com/index.php");
//Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://freshercampus.com/index.php"));
//startActivity(i);