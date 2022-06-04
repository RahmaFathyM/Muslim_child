package com.example.muslim_child;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView btn_quraan , btn_anasheed  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_quraan = findViewById(R.id.btn_quran) ;
        btn_anasheed = findViewById(R.id.btn_anasheed) ;
        btn_quraan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Activity_Recyclar.class);
                startActivity(intent);
            }
        });
        btn_anasheed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Activity_Recyclar.class);
                startActivity(intent);

            }
        });

    }
}