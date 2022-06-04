package com.example.l.anasheed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.l.Play_Anasheed;
import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.R;
import com.example.muslim_child.R;

import java.util.ArrayList;

public class Anasheed extends AppCompatActivity {
    RecyclerView rv_anasheed;
//    SeekBar seekBar ;
//    TextView tv_current_time , tv_total_time , tv_title;
   // ImageView img_next , img_before , img_play;
//   int before , next ;
    ArrayList<Anasheed_Card> sounds_array;

String [] Titles = {"الله ربى والإسلام دينى", "أركان الإسلام" ,"محمد نبينا" , "الصلاة" ,
        "قرآنى" , "الله أكبر بسم الله" , "طلع البدر علينا" ,"أهلاً رمضان" ,"الشهور الهجرية"}; // anasheed _names;
    int [] sounds = {R.raw.allahrbeandeleslamdeeny ,R.raw.arkaneleslam ,R.raw.mohamedisourprophet,R.raw.thepray ,
            R.raw.myquraan,R.raw.allahakbarbesmellah
            ,R.raw.tl3elbadr3lyna ,R.raw.ahlanramadan,R.raw.elshhoorelhegrya};   // anasheed


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasheed);
        rv_anasheed = findViewById(R.id.rv_anasheed);

        sounds_array = new ArrayList<>();
        for (int i = 0; i < sounds.length; i++) {
            sounds_array.add(new Anasheed_Card(Titles[i], sounds[i]));
        }
        RecyclerAdapter_Anasheed recyclerAdapter_anasheed = new RecyclerAdapter_Anasheed(sounds_array, new OnClickListener_Stories_anasheed() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(Anasheed.this, Play_Anasheed.class);
                intent.putExtra("position",position);
//                intent.putExtra("sound",sounds_array.get(position).getSound());
//                intent.putExtra("next",sounds_array.get(position++).getSound());
//                intent.putExtra("before",sounds_array.get(position--).getSound());
//                intent.putExtra("title",sounds_array.get(position).getTitle());
//                intent.putExtra("nexttitle",sounds_array.get(position++).getTitle());
//                intent.putExtra("beforetitle",sounds_array.get(position--).getTitle());
                startActivity(intent);
            }
                      });

//                sound.stop();
//                sound.reset();
//                sound = MediaPlayer.create(Anasheed.this,sounds_array.get(position).sound);
//                 next = position++;
//                before = position--;
//              //  tv_title.setText(Titles[position]);
//                tv_title.setText(sounds_array.get(position).getTitle());
//                soundTime();

        rv_anasheed.setAdapter(recyclerAdapter_anasheed);
        rv_anasheed.setLayoutManager(new LinearLayoutManager(Anasheed.this));
       }}
//        img_play.setOnClickListener(new View.OnClickListener() {
//            @Override
//           public void onClick(View v) {
//                if (!sound.isPlaying()) {
//                    Thread updateSeekBar = new Thread() {
//                        @Override
//                        public void run() {   // update for seekBar
//                            int SoundDuration = sound.getDuration();      // get the duration
//                            int currentposition = 0;
//                            seekBar.setMax(SoundDuration);
//                            while (currentposition < SoundDuration) {
//                                try {
//                                    sleep(100);   // update every 100 part from second .  may 50
//                                    currentposition = sound.getCurrentPosition(); // get the current possision .
//                                    seekBar.setProgress(currentposition);   //  progress mean  movement .
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                }
//                                }
//                                };
//                    sound.start();
//                    img_play.setImageResource(R.drawable.ic_pause_anasheed_24dp);
//                    updateSeekBar.start();
//                }else {
//                    img_play.setImageResource(R.drawable.ic_play_arrow_ansheed_24dp);
//                    sound.pause();
//                    return;
//                      }
//                      }
//                      });
//
//        img_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound = MediaPlayer.create(Anasheed.this,sounds_array.get(next).sound);
//
//            }
//        });
//
//        img_before.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound = MediaPlayer.create(Anasheed.this,sounds_array.get(before).sound);
//
//            }
//        });
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser) sound.seekTo(progress);   // progress b get position of seekbar..
//                soundTime();
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//            }
//            public void soundTime(){
//            seekBar.setMax(sound.getDuration());  // totalTime
//            int tim = (seekBar.getMax()/1000);   // bnksemha for 1000 lhza ..
//            int m = tim / 60;
//            int s = tim % 60 ;
//
//            int tim0 = (seekBar.getProgress() / 1000);  // get time from movement
//            int m0 = tim0 / 60 ;
//            int s0 = tim0 % 60 ;
//
//            tv_total_time.setText(m + " : " + s);
//            tv_current_time.setText(m0 + " : " + s0);
//           }
//           }



         /*


          public void onClick(View v) {

          */