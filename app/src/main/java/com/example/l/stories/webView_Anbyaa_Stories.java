package com.example.l.stories;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.l.R;

public class webView_Anbyaa_Stories extends AppCompatActivity {
    TextView tv_name_story,tv_current_time , tv_total_time ;
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

        tv_current_time=findViewById(R.id.tv_current_time);
        tv_total_time=findViewById(R.id.tv_total_time);
        setContentView(R.layout.activity_web_view__stories);
        tv_name_story = findViewById(R.id.tv_anbyaa_storyName);
        btn_after = findViewById(R.id.btn_after);
        btn_before = findViewById(R.id.btn_before);
        btn_play = findViewById(R.id.btn_play);
        seekBar = findViewById(R.id.seekBar);
        handler = new Handler();
        String storyName = getIntent().getExtras().getString("storyName");
        final int sound_rec = getIntent().getExtras().getInt("sound");
        String page = getIntent().getExtras().getString("page");
        tv_name_story.setText(storyName);
        WebView webview = (WebView) findViewById(R.id.webView__anbyaa_stories);
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
        sound = MediaPlayer.create(webView_Anbyaa_Stories.this, sound_rec);
        sound.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp)
            {
                seekBar.setMax(sound.getDuration());
               sound.start();
                changeSeekbar();

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
        } }



    public void soundTime(){
        seekBar.setMax(sound.getDuration());  // totalTime
        int tim = (seekBar.getMax()/1000);   // bnksemha for 1000 lhza ..
        int m = tim / 60;
        int s = tim % 60 ;

        int tim0 = (seekBar.getProgress() / 1000);  // get time from movement
        int m0 = tim0 / 60 ;
        int s0 = tim0 % 60 ;

        tv_total_time.setText(m + " : " + s);
        tv_current_time.setText(m0 + " : " + s0);
    }







}
//private void changeSeekbar(){
//        seekBar.setProgress(sound.getCurrentPosition());
//        if (sound.isPlaying()){
//            runnable=new Runnable() {
//                @Override
//                public void run() {
//                    changeSeekbar();
//                }
//            };
//            handler.postDelayed(runnable,1000);
//        }





//    public void soundtime(){
//        seekBar.setMax(sound.getDuration());
//        int tim = (seekBar.getMax()/1000);
//        int s = tim % 60 ;
//        int tim0 = (seekBar.getProgress() / 1000);
//        int m0 = tim0 / 60 ;
//        int s0 = tim0 % 60 ; }}




// Intent data = getIntent();
// int url = data.getExtras().getInt("page");

//
//     final ProgressDialog progressDialog = new ProgressDialog(webView_AnbyaaStories.this);
//        progressDialog.setMessage("Loading");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//
//        web_stories.setWebViewClient(new WebViewClient() {
//            public void onPageFinished(WebView view, String url) {
//                try {
//                    progressDialog.dismiss();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }); */

//   WebSettings webSettings = web_stories.getSettings();
//   webSettings.setJavaScriptEnabled(true);
//        btn_play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer sound=MediaPlayer.create(webView_Stories.this,R.raw.sydnaadam);
//                sound.start();
//                Toast.makeText(webView_Stories.this,"test2",Toast.LENGTH_SHORT);
//            }});
//  url++;

//  web_stories.setWebViewClient(new WebViewClient());
//

//        final ArrayList<MediaPlayer> MB3Sounds =new ArrayList<>();
//
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sydnaadam));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sound));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.qassas_voice));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sydnaebraheem));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sydnaadam));
//soundTime();

//         web_stories = findViewById(R.id.webView_stories);