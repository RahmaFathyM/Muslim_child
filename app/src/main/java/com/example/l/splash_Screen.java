package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

public class splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
