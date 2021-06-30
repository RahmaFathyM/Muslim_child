package com.example.l.azkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.R;
import com.example.l.adapter.OnClickListener_Stories_anasheed;

import java.util.ArrayList;

public class Azkar_A7adeeth extends AppCompatActivity {
    RecyclerView recyclerView;
    MediaPlayer mediaPlayer;

    ImageView btn_replay_zekr ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar__a7adeeth);
        ArrayList<Azkar_card> arrayList = new ArrayList<>();
        arrayList.add(new Azkar_card(R.drawable.sabah));
        arrayList.add(new Azkar_card(R.drawable.masaa));
        arrayList.add(new Azkar_card(R.drawable.wake_up));
        arrayList.add(new Azkar_card(R.drawable.sleep));
        arrayList.add(new Azkar_card(R.drawable.bef_eat));
        arrayList.add(new Azkar_card(R.drawable.aft_eat));
        arrayList.add(new Azkar_card(R.drawable.before_bath));
        arrayList.add(new Azkar_card(R.drawable.after_bath));
        arrayList.add(new Azkar_card(R.drawable.enter_house));
        arrayList.add(new Azkar_card(R.drawable.exit_home));
        arrayList.add(new Azkar_card(R.drawable.before_wodoaa));
        arrayList.add(new Azkar_card(R.drawable.after_wodoaa));
        arrayList.add(new Azkar_card(R.drawable.enter_msjd));
        arrayList.add(new Azkar_card(R.drawable.exit_msjd));
        recyclerView = findViewById(R.id.rec_azkar);
        Azkar_Adapter azkar_adapter = new Azkar_Adapter(arrayList, new OnClickListener_Stories_anasheed() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0: {
                      mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.sabah_zekr);
                        mediaPlayer.start();
                        showDialog("أذكار المصباح", "اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور", mediaPlayer.getDuration());

                        break;
                    }
                    case 1: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.masaa_sound);
                        mediaPlayer.start();
                        showDialog("أذكار المساء", "اللهم بك أمسينا وبك أصبحنا وبك نحيا وبك نموت وإليك المصير", mediaPlayer.getDuration());

                        break;
                    }
                    case 2: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.wake_up_sound);
                        mediaPlayer.start();
                        showDialog("دعاء الأستيقاظ من النوم", "الحمد لله الذي احيانا بعد ما اماتنا وإليه النشور", mediaPlayer.getDuration());
                        break;
                    }
                    case 3: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.sleep_sound);
                        mediaPlayer.start();
                        showDialog("دعاء النوم", "باسمك اللهم أموت وأحيا",mediaPlayer.getDuration());
                        break;

                    }

                    case 4: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.before_eat_sound);
                        mediaPlayer.start();
                        showDialog("دعاء قبل الأكل" ,"بسم الله",mediaPlayer.getDuration());
                        break;
                    }
                    case 5: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.after_eat);
                        mediaPlayer.start();

                        showDialog("دعاء بعد الأكل", "الحمد لله الذي اطعمني هذا و رزقنيه من غير حول مني ولا قوة",mediaPlayer.getDuration());
                        break;
                    }
                    case 6: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.before_bath_sound);
                        mediaPlayer.start();
                        showDialog("دعاء الدخول إلي الخلاء", "اللهم أني اعوذ بك من الخبث و الخبائث",mediaPlayer.getDuration());
                        break;
                    }
                    case 7: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.after_bath_sound);
                        mediaPlayer.start();
                        showDialog("دعاء الخروج من الخلاء", "غفرانك",mediaPlayer.getDuration());
                        break;
                    }
                    case 8: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.before_home);
                        mediaPlayer.start();
                        showDialog("دعاء الدخول إلى المنزل", "بسم الله ولجنا و بسم الله خرجنا و على ربنا توكلنا",mediaPlayer.getDuration());
                        break;
                    }
                    case 9: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.after_home);
                        mediaPlayer.start();
                        showDialog("دعاء الخروخ من المنزل", "بسم الله توكلت على الله ولا حول ولا قوة إلا بالله",mediaPlayer.getDuration());
                        break;
                    }
                    case 10: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.before_wodoaa);
                        mediaPlayer.start();
                        showDialog("ذكر قبل الوضوء", "بسم الله",mediaPlayer.getDuration());
                        break;
                    }
                    case 11: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.after_wodoaa);
                        mediaPlayer.start();
                        showDialog("الذكر بعد الوضوء", "أشهد أن لا إله إلا الله وحده لا شريك له وأشهد أن محمد عبده ورسوله اللهم اجعلني من التوابين واجعلني من المتطهرين",mediaPlayer.getDuration());
                        break;
                    }
                    case 12: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.before_massjed);
                        mediaPlayer.start();
                        showDialog("دعاء الدخول إالى المسجد", "أعوذ بالله العظيم وبوجهه الكريم و سلطانه لقديم من الشيطان الرجيما",mediaPlayer.getDuration());
                        break;
                    }
                    case 13: {
                        mediaPlayer = MediaPlayer.create(Azkar_A7adeeth.this, R.raw.after_massjed);
                        mediaPlayer.start();
                        showDialog("دعاء الخروج من المسجد", "بسم الله و الصلاة والسلام على رسول الله اللهم إني اسالك من فضلك اللهم اعصمني من الشيطان الرجيم",mediaPlayer.getDuration());
                        break;
                    }
                }
            }
        });
        recyclerView.setAdapter(azkar_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


    }

    public void showDialog(String dua_title, String dua_body, final int duration) {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_custom_dialog);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.window_dialog);
        ImageView btn_close = dialog.findViewById(R.id.img_close);
         btn_replay_zekr = dialog.findViewById(R.id.btn_replay_zekr);

        TextView tv_title_dua = dialog.findViewById(R.id.tv_dua_title);
        TextView tv_body_dua = dialog.findViewById(R.id.tv_dua_body);
        tv_title_dua.setText(dua_title);
        tv_body_dua.setText(dua_body);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
                mediaPlayer.stop();

            }
        });

        btn_replay_zekr.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_replay_zekr.setVisibility(View.VISIBLE); }
        },duration);
        btn_replay_zekr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_replay_zekr.setVisibility(View.INVISIBLE);
                btn_replay_zekr.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_replay_zekr.setVisibility(View.VISIBLE);
                    }
                },duration);
                mediaPlayer.start();
            }
        });
        dialog.show();




          }

}