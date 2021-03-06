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

public class Entertainment_Stories extends AppCompatActivity {

    RecyclerView rv_entertainment_stories;
    ArrayList<String> Stories_entertainment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ArrayList<Integer> MB3Sounds = new ArrayList<>();
        MB3Sounds.add(R.raw.elarnabwelsolhfa);
        MB3Sounds.add(R.raw.catinshoes);
        MB3Sounds.add(R.raw.el5anazerelse8aeelslasa);
        MB3Sounds.add(R.raw.el8erbanelzakya);
        MB3Sounds.add(R.raw.elamiraweldofd3);
        MB3Sounds.add(R.raw.elamirelso3ban);
        MB3Sounds.add(R.raw.elgnodelsheg3an);
        MB3Sounds.add(R.raw.elhoryaelsa8era);
        MB3Sounds.add(R.raw.els3labwelma3ez);
        MB3Sounds.add(R.raw.feteraelkebera);
        MB3Sounds.add(R.raw.hekayettomelesb3);
        final ArrayList<String> MB3page = new ArrayList<>();
        MB3page.add("elarnabwelsolhfa");
        MB3page.add("catinshoes");
        MB3page.add("el5anazerelse8aeelslasa");
        MB3page.add("el8erbanelzakya");
        MB3page.add("elamiraweldofd3");
        MB3page.add("elamirelso3ban");
        MB3page.add("elgnodelsheg3an");
        MB3page.add("elhoryaelsa8era");
        MB3page.add("els3labwelm3ez");
        MB3page.add("feteraelkebera");
        MB3page.add("hekayettomelesb3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment__stories);

        rv_entertainment_stories = findViewById(R.id.rv_enter_stories);
        Stories_entertainment = new ArrayList<>();
        Stories_entertainment.add("???????????? ??????????????????");
        Stories_entertainment.add("?????? ???? ??????????????");
        Stories_entertainment.add("???????????????? ??????????????");
        Stories_entertainment.add("?????????????? ????????????");
        Stories_entertainment.add("?????????????? ??????????????");
        Stories_entertainment.add("???????????? ??????????????");

        Stories_entertainment.add("???????????? ?????????????? ??????????????");
        Stories_entertainment.add("?????????????? ??????????????");
        Stories_entertainment.add("???????????? ??????????????");
        Stories_entertainment.add("?????????? ??????????");
        Stories_entertainment.add("?????????? ?????? ????????????");


        Recycler_Adapter_String adapter_stories = new Recycler_Adapter_String(Stories_entertainment, "#ffffff", new OnClickListener_Stories_anasheed_quraan() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Entertainment_Stories.this, WebView_Stories_Quraan.class);
                intent.putExtra("currentWeb", 2);
                intent.putExtra("itemName", Stories_entertainment.get(position));
                intent.putExtra("page", MB3page.get(position));
                intent.putExtra("sound", MB3Sounds.get(position));
                startActivity(intent);
            }
        }
        );

        rv_entertainment_stories.setAdapter(adapter_stories);
        rv_entertainment_stories.setLayoutManager(new LinearLayoutManager(Entertainment_Stories.this));

    }

}





