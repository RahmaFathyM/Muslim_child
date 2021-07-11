package com.example.l.anasheed;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.l.R;

import java.util.ArrayList;

public class Play_Anasheed extends AppCompatActivity {
    SeekBar seekBar;
    TextView tv_current_time, tv_total_time, tv_title;
    ImageView img_next, img_before, img_play;
    int current_position_play;
    Handler handler = new Handler();
    ArrayList<Nasheed> sounds_array;

    String[] Titles = {"الله ربى والإسلام دينى", "أركان الإسلام", "محمد نبينا", "الصلاة", "قرآنى", "الله أكبر بسم الله", "طلع البدر علينا", "أهلاً رمضان", "الشهور الهجرية"}; // anasheed _names;
    int[] sounds = {R.raw.allahrbeandeleslamdeeny, R.raw.arkaneleslam, R.raw.mohamedisourprophet, R.raw.thepray, R.raw.myquraan, R.raw.allahakbarbesmellah
            , R.raw.tl3elbadr3lyna, R.raw.ahlanramadan, R.raw.elshhoorelhegrya};   // anasheed
    MediaPlayer sound = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__anasheed);
        initView();
        sounds_array = new ArrayList<>();
        for (int i = 0; i < sounds.length; i++) {
            sounds_array.add(new Nasheed(Titles[i], sounds[i]));
        }

        int position = getIntent().getExtras().getInt("position");
        current_position_play = position;
        if (current_position_play == sounds_array.size() - 1) {
            img_next.setEnabled(false);
            img_next.setImageResource(R.drawable.ic_fast_forward_grey_24dp);

        } else if (current_position_play == 0) {
            img_before.setEnabled(false);
            img_before.setImageResource(R.drawable.ic_fast_rewind_grey_24dp);

        }
        sound = MediaPlayer.create(Play_Anasheed.this, sounds_array.get(position).getSound());
        sound.start();
        changeSeekbar();
        // updateSeekBar();

        tv_title.setText(sounds_array.get(position).getTitle());
        soundTime();
        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSeekbar();
                if (!sound.isPlaying()) {
                    //   updateSeekBar();
                    sound.start();
                    img_play.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);

                } else {
                    // updateSeekBar();
                    img_play.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    sound.pause();

                    return;
                }
            }
        });

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSeekbar();
                if (current_position_play == 0) {
                    img_before.setEnabled(true);
                    img_before.setImageResource(R.drawable.ic_fast_rewind_black_24dp);
                }
                current_position_play = ++current_position_play;
                if (current_position_play == sounds_array.size() - 1) {
                    img_next.setEnabled(false);
                    img_next.setImageResource(R.drawable.ic_fast_forward_grey_24dp);

                }

                sound.stop();
                sound = MediaPlayer.create(Play_Anasheed.this, sounds_array.get(current_position_play).getSound());
                sound.start();
                tv_title.setText(sounds_array.get(current_position_play).getTitle());
                //  updateSeekBar();
            }
        });

        img_before.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeSeekbar();
                // in last item in recycler and press before set img next enable before change sound
                if (current_position_play == sounds_array.size() - 1) {
                    img_next.setEnabled(true);
                    img_next.setImageResource(R.drawable.ic_fast_forward_black_24dp);
                }
                current_position_play = --current_position_play;
                if (current_position_play == 0) {
                    img_before.setEnabled(false);
                    img_before.setImageResource(R.drawable.ic_fast_rewind_grey_24dp);

                }


                sound.stop();
                sound = MediaPlayer.create(Play_Anasheed.this, sounds_array.get(current_position_play).getSound());
                sound.start();
                tv_title.setText(sounds_array.get(current_position_play).getTitle());
                // updateSeekBar();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) sound.seekTo(progress);   // progress b get position of seekbar..
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

    //           public void updateSeekBar(){
//               Thread updateSeekBar = new Thread() {
//                   @Override
//                   public void run() {   // update for seekBar
//                       int SoundDuration = sound.getDuration();      // get the duration
//                       int currentposition = 0;
//                       seekBar.setMax(SoundDuration);
//                       while (currentposition < SoundDuration) {
//                           try {
//                               sleep(100);   // update every 100 part from second .  may 50
//                               currentposition = sound.getCurrentPosition(); // get the current possision .
//                               seekBar.setProgress(currentposition);   //  progress mean  movement .
//                           } catch (InterruptedException e) {
//                               e.printStackTrace(); } } }};
//               updateSeekBar.start(); }
    @Override

    public void onBackPressed() {
        super.onBackPressed();
        if (sound.isPlaying()) {
            sound.stop();

        }
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

    public void initView() {

        seekBar = findViewById(R.id.seekBar);
        tv_current_time = findViewById(R.id.tv_current_time);
        tv_total_time = findViewById(R.id.tv_total_time);
        tv_title = findViewById(R.id.tv_title);
        img_before = findViewById(R.id.btn_before);
        img_next = findViewById(R.id.btn_after);
        img_play = findViewById(R.id.btn_play);


    }

}


