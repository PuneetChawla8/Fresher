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

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {
    public WebView mWebview;
    Handler uiHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blog, container, false);
        getActivity().setTitle("BLOG");
        mWebview = (WebView) view.findViewById(R.id.webview4);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("http://freshercampus.com/index.php");
    return view;
    }

}
