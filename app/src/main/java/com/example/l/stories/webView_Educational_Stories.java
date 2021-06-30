package com.example.l.stories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.l.R;

public class webView_Educational_Stories extends AppCompatActivity {
    WebView webView;
    TextView tv_name_story ;
    ImageView btn_after, btn_play, btn_before;
    SeekBar seekBar;
    Runnable runnable;
    Handler handler;
    MediaPlayer sound;
    @Override

    public  void onBackPressed(){
        super.onBackPressed();
        if(sound.isPlaying()){
            sound.pause();
            sound.release();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view__educational__stories);
        tv_name_story = findViewById(R.id.tv_edu_storyName);
        btn_after = findViewById(R.id.btn_after);
        btn_before = findViewById(R.id.btn_before);
        btn_play = findViewById(R.id.btn_play);
        seekBar = findViewById(R.id.seekBar);
        handler = new Handler();
        String storyName = getIntent().getExtras().getString("storyName");
        final int sound_rec = getIntent().getExtras().getInt("sound");
        String page = getIntent().getExtras().getString("page");
        tv_name_story.setText(storyName);
         webView = (WebView) findViewById(R.id.webView__edu_stories);
        webView.setBackgroundColor(Color.parseColor("#C1EDF1"));   //****
        webView.loadUrl("file:///android_asset/" + page + ".html");
        webView.requestFocus();

        final ProgressDialog progressDialog = new ProgressDialog(this);   // why final ??
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sound.seekTo(sound.getCurrentPosition());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sound.seekTo(sound.getCurrentPosition());

            }
        });
        sound = MediaPlayer.create(webView_Educational_Stories.this, sound_rec);
        sound.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(sound.getDuration());
                sound.start();
                changeSeekbar();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    sound.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (sound.isPlaying()) {

                    sound.pause();
                    btn_play.setImageResource(R.drawable.ic_play_arrow_black_24dp);


                } else {

                    sound.start();

                    btn_play.setImageResource(R.drawable.ic_pause_black_24dp);

                }

            }
        });


        btn_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.seekTo(sound.getCurrentPosition()-10000);

            }
        });
        btn_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.seekTo(sound.getCurrentPosition()+10000);

            }
        });
    }

    private void changeSeekbar() {
        seekBar.setProgress(sound.getCurrentPosition());
        if (sound.isPlaying()) {

            runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }
}

