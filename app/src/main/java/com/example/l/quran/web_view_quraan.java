package com.example.l.quran;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.l.R;

import java.util.Arrays;

public class web_view_quraan extends AppCompatActivity {
    WebView web_quran ;
    Button btn_sound ;
    String [] htmlfilearray ;
    protected void onCreate(Bundle saveInstenceState) {

        super.onCreate(saveInstenceState);
        setContentView(R.layout.activity_web_view_quraan);
        web_quran = (WebView) findViewById(R.id.webview_quraan);
        Intent data = getIntent();
        int page = data.getExtras().getInt("page");
        page++ ;
        web_quran.loadUrl("file:///android_asset/"+htmlfilearray[page]+".html1");
        web_quran.setWebViewClient(new WebViewClient());
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
        //html file editor 261 to 265
    }
}
