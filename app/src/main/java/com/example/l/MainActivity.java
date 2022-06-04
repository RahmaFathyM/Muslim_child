package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.l.anasheed.Anasheed;
import com.example.l.azkar.Azkar_A7adeeth;
import com.example.l.quran.Quran;
import com.example.l.stories.Stories;
import com.example.muslim_child.R;

public class MainActivity extends AppCompatActivity {
    ImageView img_quran,img_azkar ,img_stories,img_anasheed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
         //final MediaPlayer media =MediaPlayer.create(this,R.raw.qassas_voice);
        //final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        img_stories = findViewById(R.id.btn_stories);
        img_anasheed = findViewById(R.id.btn_anasheed);
        img_azkar = findViewById(R.id.btn_azkar);
        img_quran = findViewById(R.id.btn_quran);

        img_stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //media.start();
                Intent intent = new Intent(MainActivity.this, Stories.class);
                startActivity(intent);
            }
        });

        img_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            // Amira
            public void onClick(View v) {
                //mediaPlayer.start();
                Intent intent=new Intent(MainActivity.this, Azkar_A7adeeth.class);
                startActivity(intent);

            }
        });
        img_anasheed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, Anasheed.class);
                startActivity(intent);

            }
        });
        img_quran.setOnClickListener(new View.OnClickListener() {
            @Override
            //Arwa
            public void onClick(View v) {
                //mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, Quran.class);
                startActivity(intent);

            }
        });
    }}