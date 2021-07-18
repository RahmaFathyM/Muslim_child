package com.example.l;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.l.anasheed.Recycler_Anasheed;
import com.example.l.azkar.Recycler_Azkar;
import com.example.l.quran.recycler_quraan;
import com.example.l.stories.Stories_home;

public class MainActivity extends AppCompatActivity {
    ImageView img_quran, img_azkar, img_stories, img_anasheed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final MediaPlayer azkar = MediaPlayer.create(this, R.raw.azkar_bird);
        final MediaPlayer quraan = MediaPlayer.create(this, R.raw.quraan_bird);
        final MediaPlayer anasheed = MediaPlayer.create(this, R.raw.anasheed);
        final MediaPlayer stories = MediaPlayer.create(this, R.raw.stories_bird);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        img_stories = findViewById(R.id.btn_stories);
        img_anasheed = findViewById(R.id.btn_anasheed);
        img_azkar = findViewById(R.id.btn_azkar);
        img_quran = findViewById(R.id.btn_quran);
        img_stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stories.start();
                Intent intent = new Intent(MainActivity.this, Stories_home.class);
                startActivity(intent);
            }
        });

        img_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            // Amira
            public void onClick(View v) {
                azkar.start();
                Intent intent = new Intent(MainActivity.this, Recycler_Azkar.class);
                startActivity(intent);

            }
        });
        img_anasheed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anasheed.start();
                Intent intent = new Intent(MainActivity.this, Recycler_Anasheed.class);
                startActivity(intent);

            }
        });
        img_quran.setOnClickListener(new View.OnClickListener() {
            @Override
            //Arwa
            public void onClick(View v) {
                quraan.start();
                Intent intent = new Intent(MainActivity.this, recycler_quraan.class);
                startActivity(intent);

            }
        });
    }
}