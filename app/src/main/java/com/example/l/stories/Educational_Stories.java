package com.example.l.stories;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.R;
import com.example.l.adapter.Recycler_Adapter_String;

import java.util.ArrayList;

public class Educational_Stories extends AppCompatActivity {
    RecyclerView rv_edu_stories ;
    ArrayList<String> Stories_edu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ArrayList<Integer>MB3Sounds =new ArrayList<>();
        MB3Sounds.add(R.raw.samretelehsan);
        MB3Sounds.add(R.raw.bnaaelk3ba);
        MB3Sounds.add(R.raw.ela3maleltyba);
        MB3Sounds.add(R.raw.elnasrfeeelethad);
        MB3Sounds.add(R.raw.elsedkhwaafdaldman);
        MB3Sounds.add(R.raw.eltm3);
        MB3Sounds.add(R.raw.fadlelsyam);

        MB3Sounds.add(R.raw.thyeteleslam);
        MB3Sounds.add(R.raw.howthetigerwashumble);
        final ArrayList<String>MB3page =new ArrayList<>();
        MB3page.add("samretelehsan");
        MB3page.add("bnaaelk3ba");
        MB3page.add("ela3maleltyba");
        MB3page.add("elnasrfeeelethad");
        MB3page.add("elsedkhwaafdaldman");
        MB3page.add("eltm3");
        MB3page.add("fadlelsyam");
        MB3page.add("thyeteleslam");
        MB3page.add("howthetigerwashumble");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational__stories);

        rv_edu_stories = (RecyclerView)findViewById(R.id.rv_eduStory);
        Stories_edu = new ArrayList<>();
        Stories_edu.add("ثمرة الإحسان" );
        Stories_edu.add("قصة بناء الكعبة");
        Stories_edu.add("قصة الأعمال الطيبة");
        Stories_edu.add("النصر فى الإتحاد");
        Stories_edu.add("الصدق هو أفضل ضمان");
        Stories_edu.add("الطمع");
        Stories_edu.add("فضل الصيام" );

        Stories_edu.add("تحية الإسلام");
        Stories_edu.add("كيف كان النمر متواضعاً");



        Recycler_Adapter_String adapter_stories = new Recycler_Adapter_String(Stories_edu, "#653915",new OnClickListener_Stories_anasheed() {
            @Override
            public void onClick(int position) {


                Intent intent = new Intent(Educational_Stories.this, WebView_Stories.class);
                intent.putExtra("currentWeb",1);
                intent.putExtra("storyName",Stories_edu.get(position));
                intent.putExtra("page",MB3page.get(position));
                intent.putExtra("sound",MB3Sounds.get(position));
                startActivity(intent);
            }
        }
        );

        rv_edu_stories.setAdapter(adapter_stories);
        rv_edu_stories.setLayoutManager(new LinearLayoutManager(Educational_Stories.this));

    }

}





