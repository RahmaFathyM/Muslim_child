package com.example.l.stories;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.l.R;

public class WebView_Stories extends AppCompatActivity {
    TextView tv_name_story, tv_current_time, tv_total_time;
    ImageView btn_after, btn_play, btn_before;
    SeekBar seekBar;
    Handler handler;
    MediaPlayer sound;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (sound.isPlaying()) {
            sound.stop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int current = getIntent().getExtras().getInt("currentWeb");
        if (current == 0) {
            setContentView(R.layout.activity_web_view_anbyaa_stories);
        } else if (current == 1) {
            setContentView(R.layout.activity_web_view__educational__stories);
        } else if (current == 2) {
            setContentView(R.layout.activity_web_view__entertainment__stories);
        }
        tv_current_time = findViewById(R.id.tv_current_time);
        tv_total_time = findViewById(R.id.tv_total_time);
        tv_name_story = findViewById(R.id.tv_storyName);
        btn_after = findViewById(R.id.btn_after);
        btn_before = findViewById(R.id.btn_before);
        btn_play = findViewById(R.id.btn_play);
        seekBar = findViewById(R.id.seekBar);
        handler = new Handler();
        String storyName = getIntent().getExtras().getString("storyName");
        final int sound_rec = getIntent().getExtras().getInt("sound");
        String page = getIntent().getExtras().getString("page");
        tv_name_story.setText(storyName);
        WebView webview = findViewById(R.id.webView_stories);
        webview.setBackgroundColor(0x00FFFFFF);   //****
        webview.loadUrl("file:///android_asset/" + page + ".html");
        webview.requestFocus();
        final ProgressDialog progressDialog = new ProgressDialog(this);   // why final ??
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

        webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        sound = MediaPlayer.create(WebView_Stories.this, sound_rec);
        sound.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(sound.getDuration());
                sound.start();
                soundTime();
                changeSeekbar();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) sound.seekTo(progress);
                soundTime();
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
                changeSeekbar();
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
                sound.seekTo(sound.getCurrentPosition() - 10000);

            }
        });
        btn_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sound.seekTo(sound.getCurrentPosition() + 10000);

            }
        });
    }

    public void soundTime() {
        seekBar.setMax(sound.getDuration());  // totalTime
        int tim = (seekBar.getMax() / 1000);   // bnksemha for 1000 lhza ..
        int m = tim / 60;
        int s = tim % 60;

        int tim0 = (seekBar.getProgress() / 1000);  // get time from movement
        int m0 = tim0 / 60;
        int s0 = tim0 % 60;

        tv_total_time.setText(m + " : " + s);
        tv_current_time.setText(m0 + " : " + s0);
    }

    private void changeSeekbar() {
        seekBar.setProgress(sound.getCurrentPosition());
        if (sound.isPlaying()) {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }


}
