package subway.ggikko.com.hellosubway.webview;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import subway.ggikko.com.hellosubway.R;
import subway.ggikko.com.hellosubway.webview.WebViewFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment {

    private ProgressBar progressBar;
    private String curURL;
    private WebView webview;
    Thread thread;

    public NavigationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        webview = (WebView) view.findViewById(R.id.web);


        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);


        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                progressBar.setVisibility(View.GONE);

            }
        };
        asyncTask.execute();


        String urll = "http://maps.google.com/maps?f=d&saddr=모란역&daddr=야탑역&hl=ko";

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new webClient());
        webview.loadUrl(urll);


        return view;
    }

    public void setURL(String url) {

        if (curURL != null) {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setWebViewClient(new webClient());
            webview.loadUrl(curURL);
        }
    }

    public void updateUrl(String url) {
        curURL = url;
        WebView webview = (WebView) getView().findViewById(R.id.web);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }

    private class webClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;

        }

    }


}
