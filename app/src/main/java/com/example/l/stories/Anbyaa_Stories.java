package com.example.l.stories;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.R;
import com.example.l.adapter.OnClickListener_Stories_anasheed_quraan;
import com.example.l.adapter.Recycler_Adapter_String;

import java.util.ArrayList;

import static com.example.l.R.id;
import static com.example.l.R.layout;
import static com.example.l.R.raw;

public class Anbyaa_Stories extends AppCompatActivity {
    RecyclerView rv_anbyaa_stories;

    ArrayList<String> Stories_anbyaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final ArrayList<Integer> MB3Sounds = new ArrayList<>();
        MB3Sounds.add(R.raw.sydnaadam);
        MB3Sounds.add(R.raw.sydnanooh);
        MB3Sounds.add(R.raw.sydnahoud);
        MB3Sounds.add(R.raw.sydnasaleh);
        MB3Sounds.add(R.raw.sydnayounos);
        MB3Sounds.add(R.raw.sydnamosa);
        MB3Sounds.add(R.raw.dawoodandsoliman);
        MB3Sounds.add(R.raw.sydnamohamed);
        MB3Sounds.add(raw.sydnaebraheem);
        final ArrayList<String> MB3page = new ArrayList<>();
        MB3page.add("sydnaadm");
        MB3page.add("sydnanoh");
        MB3page.add("sydnahod");
        MB3page.add("sydnasaleh");
        MB3page.add("sydnayounos");
        MB3page.add("sydnamousa");
        MB3page.add("dawoodandsoliman");
        MB3page.add("sydnamohamed");
        MB3page.add("sydnaebrahem");
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_anbyaa__stories);
        rv_anbyaa_stories = findViewById(id.rv_anbyaa_stories);
        Stories_anbyaa = new ArrayList<>();
        Stories_anbyaa.add("قصة سيدنا آدم");
        Stories_anbyaa.add("قصة سيدنا نوح");
        Stories_anbyaa.add("قصة سيدنا هود");
        Stories_anbyaa.add("قصة سيدنا صالح");
        Stories_anbyaa.add("قصة سيدنا يونس");
        Stories_anbyaa.add("قصة سيدنا موسى");
        Stories_anbyaa.add("قصة سيدنا داوود وسيدنا سليمان");
        Stories_anbyaa.add("قصة سيدنا محمد");
        Stories_anbyaa.add("قصة سيدنا إبراهيم");

        Recycler_Adapter_String adapter_stories = new Recycler_Adapter_String(Stories_anbyaa, "#653915", new OnClickListener_Stories_anasheed_quraan() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Anbyaa_Stories.this, WebView_Stories_Quraan.class);
                intent.putExtra("currentWeb", 0);
                intent.putExtra("itemName", Stories_anbyaa.get(position));
                intent.putExtra("page", MB3page.get(position));
                intent.putExtra("sound", MB3Sounds.get(position));
                startActivity(intent);
            }
        }
        );

        rv_anbyaa_stories.setAdapter(adapter_stories);
        rv_anbyaa_stories.setLayoutManager(new LinearLayoutManager(Anbyaa_Stories.this));

    }

}
