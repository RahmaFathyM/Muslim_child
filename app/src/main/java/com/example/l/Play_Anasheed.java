package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.l.anasheed.Anasheed_Card;

import java.util.ArrayList;

public class Play_Anasheed extends AppCompatActivity {
        SeekBar seekBar ;
    TextView tv_current_time , tv_total_time , tv_title;
     ImageView img_next , img_before , img_play;
     int before , next ;
    ArrayList<Anasheed_Card> sounds_array;

    String [] Titles = {"الله ربى والإسلام دينى", "أركان الإسلام" ,"محمد نبينا" , "الصلاة" , "قرآنى" , "الله أكبر بسم الله" , "طلع البدر علينا" ,"أهلاً رمضان" ,"الشهور الهجرية"}; // anasheed _names;
    int [] sounds = {R.raw.allahrbeandeleslamdeeny ,R.raw.arkaneleslam ,R.raw.mohamedisourprophet,R.raw.thepray ,R.raw.myquraan,R.raw.allahakbarbesmellah
            ,R.raw.tl3elbadr3lyna ,R.raw.ahlanramadan,R.raw.elshhoorelhegrya};   // anasheed
    MediaPlayer sound  = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__anasheed);
        sounds_array = new ArrayList<>();
        for (int i = 0; i < sounds.length; i++) {
            sounds_array.add(new Anasheed_Card(Titles[i], sounds[i]));}

                seekBar = findViewById(R.id.seekBar);
        tv_current_time = findViewById(R.id.tv_current_time);
        tv_total_time = findViewById(R.id.tv_total_time);
        tv_title = findViewById(R.id.tv_title);
        img_before = findViewById(R.id.btn_before);
        img_next = findViewById(R.id.btn_after);
        img_play = findViewById(R.id.btn_play);
         int position = getIntent().getExtras().getInt("position");
         before= position--;
         next= position++;
//        final int next= getIntent().getExtras().getInt("next");
//        final int before= getIntent().getExtras().getInt("before");
//         final int sounds= getIntent().getExtras().getInt("sound");
//final String title=getIntent().getExtras().getString("title");
//        final String nexttitle=getIntent().getExtras().getString("nexttitle");
//        final String beforetitle=getIntent().getExtras().getString("beforetitle");
                sound = MediaPlayer.create(Play_Anasheed.this,sounds_array.get(position).getSound());
                sound.start();
updateSeekBar();
              //  tv_title.setText(Titles[position]);
                tv_title.setText(sounds_array.get(position).getTitle());
                soundTime();
        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                if (!sound.isPlaying()) {
updateSeekBar();
                    sound.start();
                    img_play.setImageResource(R.drawable.ic_pause_anasheed_24dp);

                }else {
updateSeekBar();
                    img_play.setImageResource(R.drawable.ic_play_arrow_ansheed_24dp);
                    sound.pause();

                    return;
                      }
                      }
                      });

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSeekBar();
                next=next++;
                if(next == sounds_array.size()-1){
                    img_next.setEnabled(false);
                    img_next.setImageResource(R.drawable.ic_fast_forward_grey_24dp);
                }
                sound.stop();
                sound = MediaPlayer.create(Play_Anasheed.this,sounds_array.get(next).getSound());
                sound.start();

                tv_title.setText(sounds_array.get(next).getTitle());}


        });

        img_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSeekBar();
                before=--before;
                if(before == 0){
                    img_before.setEnabled(false);
                     img_before.setImageResource(R.drawable.ic_fast_rewind_grey_24dp);
                }

                sound.stop();
                sound = MediaPlayer.create(Play_Anasheed.this,sounds_array.get(before).getSound());
                sound.start();
                tv_title.setText(sounds_array.get(before).getTitle());
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) sound.seekTo(progress);   // progress b get position of seekbar..
                soundTime();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
            }
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
           public void updateSeekBar(){
               Thread updateSeekBar = new Thread() {
                   @Override
                   public void run() {   // update for seekBar
                       int SoundDuration = sound.getDuration();      // get the duration
                       int currentposition = 0;
                       seekBar.setMax(SoundDuration);
                       while (currentposition < SoundDuration) {
                           try {
                               sleep(100);   // update every 100 part from second .  may 50
                               currentposition = sound.getCurrentPosition(); // get the current possision .
                               seekBar.setProgress(currentposition);   //  progress mean  movement .
                           } catch (InterruptedException e) {
                               e.printStackTrace(); } } }};
               updateSeekBar.start(); }
    @Override

    public  void onBackPressed(){
        super.onBackPressed();
        if(sound.isPlaying()){
            sound.stop();

        }
    }
           }


