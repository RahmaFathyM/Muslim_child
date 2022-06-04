package com.example.l.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.l.adapter.OnClickListener_Stories_anasheed_quraan;
import com.example.l.R;
import com.example.l.adapter.Recycler_Adapter_String;
import com.example.l.stories.WebView_Stories_Quraan;

import java.util.ArrayList;

public class recycler_quraan extends AppCompatActivity {
    RecyclerView rv_quraan;
    TextView textView ;
    ArrayList<String> Quraan_list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.
                LayoutParams.FLAG_FULLSCREEN);

        final ArrayList<Integer>MB3Sounds =new ArrayList<>();
        MB3Sounds.add(R.raw.nabaa);
        MB3Sounds.add(R.raw.nazaat);
        MB3Sounds.add(R.raw.abasa);
        MB3Sounds.add(R.raw.takwer);
        MB3Sounds.add(R.raw.inftar);
        MB3Sounds.add(R.raw.motaffen);
        MB3Sounds.add(R.raw.enshqaq);
        MB3Sounds.add(R.raw.brouj);
        MB3Sounds.add(R.raw.tareq);
        MB3Sounds.add(R.raw.aala);
        MB3Sounds.add(R.raw.ghashia);
        MB3Sounds.add(R.raw.fajr);
        MB3Sounds.add(R.raw.balad);
        MB3Sounds.add(R.raw.shams);
        MB3Sounds.add(R.raw.lail);
        MB3Sounds.add(R.raw.doha);
        MB3Sounds.add(R.raw.sharh);
        MB3Sounds.add(R.raw.ten);
        MB3Sounds.add(R.raw.alaq);
        MB3Sounds.add(R.raw.qadr);
        MB3Sounds.add(R.raw.bayna);
        MB3Sounds.add(R.raw.zalzala);
        MB3Sounds.add(R.raw.aadiat);
        MB3Sounds.add(R.raw.qareaa);
        MB3Sounds.add(R.raw.takathor);
        MB3Sounds.add(R.raw.asr);
        MB3Sounds.add(R.raw.homza);
        MB3Sounds.add(R.raw.fel);
        MB3Sounds.add(R.raw.quraish);
        MB3Sounds.add(R.raw.maaon);
        MB3Sounds.add(R.raw.kawther);
        MB3Sounds.add(R.raw.kaferon);
        MB3Sounds.add(R.raw.nasr);
        MB3Sounds.add(R.raw.masad);
        MB3Sounds.add(R.raw.ekhlas);
        MB3Sounds.add(R.raw.falaq);
        MB3Sounds.add(R.raw.nas);
        final ArrayList<String> MB3page =new ArrayList<>();
        MB3page.add(getString(R.string.nabaa));
        MB3page.add(getString(R.string.nazaat));
        MB3page.add("abasa");
        MB3page.add("takwer");
        MB3page.add("inftar");
        MB3page.add("motaffen");
        MB3page.add("enshqaq");
        MB3page.add("brouj");
        MB3page.add("tareq");
        MB3page.add("aala");
        MB3page.add("ghashia");
        MB3page.add("fajr");
        MB3page.add("balad");
        MB3page.add("shams");
        MB3page.add("lail");
        MB3page.add("doha");
        MB3page.add("sharh");
        MB3page.add("ten");
        MB3page.add("alaq");
        MB3page.add("qadr");
        MB3page.add("bayna");
        MB3page.add("zalzala");
        MB3page.add("aadiat");
        MB3page.add("qareaa");
        MB3page.add("takathor");
        MB3page.add("asr");
        MB3page.add("homza");
        MB3page.add("fel");
        MB3page.add("quraish");
        MB3page.add("maaon");
        MB3page.add("kawther");
        MB3page.add("kaferon");
        MB3page.add("nasr");
        MB3page.add("masad");
        MB3page.add("ekhlas");
        MB3page.add("falaq");
        MB3page.add("nas");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        rv_quraan = (RecyclerView) findViewById(R.id.recycler_quraan);

        Quraan_list = new ArrayList<>();
        Quraan_list.add(" سورة النبأ ");
        Quraan_list.add(" سورة النازعات ");
        Quraan_list.add(" سورة عبس ");
        Quraan_list.add(" سورة التكوير ");
        Quraan_list.add(" سورة الانفطار ");
        Quraan_list.add(" سورة المطففين ");
        Quraan_list.add(" سورة الانشقاق ");
        Quraan_list.add(" سورة البروج ");
        Quraan_list.add(" سورة الطارق ");
        Quraan_list.add(" سورة الاعلي ");
        Quraan_list.add(" سورة الغاشية ");
        Quraan_list.add(" سورة الفجر ");
        Quraan_list.add(" سورة البلد ");
        Quraan_list.add(" سورة الشمس ");
        Quraan_list.add(" سورة الليل ");
        Quraan_list.add(" سورة الضحى ");
        Quraan_list.add(" سورة الشرح ");
        Quraan_list.add(" سورة التين ");
        Quraan_list.add(" سورة العلق ");
        Quraan_list.add(" سورة القدر ");
        Quraan_list.add(" سورة البينة ");
        Quraan_list.add(" سورة الزلزلة ");
        Quraan_list.add(" سورة العاديات ");
        Quraan_list.add(" سورة القارعة ");
        Quraan_list.add(" سورة التكاثر ");
        Quraan_list.add(" سورة العصر ");
        Quraan_list.add(" سورة الهمزة ");
        Quraan_list.add(" سورة الفيل ");
        Quraan_list.add(" سورة قريش ");
        Quraan_list.add(" سورة الماعون ");
        Quraan_list.add(" سورة الكوثر ");
        Quraan_list.add(" سورة الكافرون ");
        Quraan_list.add( " سورة النصر ");
        Quraan_list.add(" سورة المسد ");
        Quraan_list.add(" سورة الاخلاص ");
        Quraan_list.add(" سورة الفلق ");
        Quraan_list.add(" سورة الناس ");

        Recycler_Adapter_String adapter = new Recycler_Adapter_String(Quraan_list,"#553114" ,new OnClickListener_Stories_anasheed_quraan(){
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getBaseContext(), WebView_Stories_Quraan.class);
                intent.putExtra("currentWeb", 3);
                intent.putExtra("itemName", Quraan_list.get(position));
                intent.putExtra("sound", MB3Sounds.get(position));
                intent.putExtra("page", MB3page.get(position));
                startActivity(intent);


            }
        });

        rv_quraan.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_quraan.setHasFixedSize(true);
        rv_quraan.setLayoutManager(layoutManager);

}}




