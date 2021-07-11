package com.example.l.stories;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.l.R;

public class Stories_home extends AppCompatActivity {
    ImageView btn_anbyaa_stories , btn_educatioal_stories,btn_entertainment_stories;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_home);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btn_anbyaa_stories = findViewById(R.id.img_anbya_stories);
        btn_educatioal_stories = findViewById(R.id.img_edu_stories);
        btn_entertainment_stories = findViewById(R.id.img_ent_stories);


       btn_anbyaa_stories.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Stories_home.this, Anbyaa_Stories.class);
        startActivity(intent);
    }
    });
       btn_educatioal_stories.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Stories_home.this,Educational_Stories.class);
               startActivity(intent);
           }
       });
        btn_entertainment_stories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Stories_home.this,Entertainment_Stories.class);
                startActivity(intent);
            }
        });
    }
}
