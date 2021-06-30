package com.example.l.stories;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.R;
import com.example.l.Recycler_Adapter_Stories;

import java.util.ArrayList;

public class Educational_Stories extends AppCompatActivity {
    RecyclerView rv_educational_stories;
    DataBase_Stories db ;
    ArrayList<Stories_Card> Stories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational__stories);
      //  final MediaPlayer name_story=MediaPlayer.create(Educational_Stories.this, R.raw.adam_voice);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // ??
        db = new DataBase_Stories(this);
        rv_educational_stories = (RecyclerView)findViewById(R.id.rv_eduStory);
        final String [] storyNames = {"قصة بناء الكعبة", "قصة الأععمال الطيبة", "النصر فى الإتحاد","الصدق هو أفضل ضمان", "الطمع" , "فضل الصيام"  ,"ثمرة الإحسان" , "تحية الإسلام", "كيف كان النمر متواضعاً", "كن مهذباً"};  // at the top of webView...
        final ArrayList<Integer>MB3Sounds =new ArrayList<>();
        MB3Sounds.add(R.raw.bnaaelk3ba);
        MB3Sounds.add(R.raw.ela3maleltyba);
        MB3Sounds.add(R.raw.elnasrfeeelethad);
        MB3Sounds.add(R.raw.elsedkhwaafdaldman);
        MB3Sounds.add(R.raw.eltm3);
        MB3Sounds.add(R.raw.fadlelsyam);
        MB3Sounds.add(R.raw.samretelehsan);
        MB3Sounds.add(R.raw.thyeteleslam);
        MB3Sounds.add(R.raw.howthetigerwashumble);
        MB3Sounds.add(R.raw.konmohzaban);
        final ArrayList<String>MB3page =new ArrayList<>();
        MB3page.add("bnaaelk3ba");
        MB3page.add("ela3maleltyba");
        MB3page.add("elnasrfeeelethad");
        MB3page.add("elsedkhwaafdaldman");
        MB3page.add("eltm3");
        MB3page.add("fadlelsyam");
        MB3page.add("samretelehsan");
        MB3page.add("thyeteleslam");
        MB3page.add("howthetigerwashumble");
        MB3page.add("konmohzaban");
        Stories = new ArrayList<>();        // khleh yget men el data base ;
        Stories_Card story1 = new Stories_Card(storyNames[0] , R.drawable.icon);
        Stories_Card story2 = new Stories_Card(storyNames[1] , R.drawable.icon);
        Stories_Card story3 = new Stories_Card(storyNames[2] , R.drawable.icon);
        Stories_Card story4 = new Stories_Card(storyNames[3] , R.drawable.icon);
        Stories_Card story5 = new Stories_Card(storyNames[4] , R.drawable.icon);
        Stories_Card story6 = new Stories_Card(storyNames[5] , R.drawable.icon);
        Stories_Card story7 = new Stories_Card(storyNames[6] , R.drawable.icon);
        Stories_Card story8 = new Stories_Card(storyNames[7] , R.drawable.icon);
        Stories_Card story9 = new Stories_Card(storyNames[8] , R.drawable.icon);
        Stories_Card story10 = new Stories_Card(storyNames[9] , R.drawable.icon);

        Stories = db.getAllStories();
        Recycler_Adapter_Stories adapter_stories = new Recycler_Adapter_Stories(Stories, new OnClickListener_Stories_anasheed() {
            @Override
            public void onClick(int position) {
                //   name_story.start();
                Intent intent = new Intent(Educational_Stories.this, webView_Educational_Stories.class);
                intent.putExtra("storyName", storyNames[position]);
                intent.putExtra("page", MB3page.get(position));
                intent.putExtra("sound", MB3Sounds.get(position));
                startActivity(intent);
            }}
        );
        db.insertStory(story1);
        db.insertStory(story2);
        db.insertStory(story3);
        db.insertStory(story4);
        db.insertStory(story5);
        db.insertStory(story6);
        db.insertStory(story7);
        db.insertStory(story8);
        db.insertStory(story9);
        db.insertStory(story10);
        rv_educational_stories.setAdapter(adapter_stories);
        rv_educational_stories.setLayoutManager(new LinearLayoutManager(Educational_Stories.this));
    }}

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational__stories);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //???
        rv_educational_stories = findViewById(R.id.rv_eduStory);
        db = new DataBase_Stories(this);
        Stories = new ArrayList<>();        // khleh yget men el data base ;
        Stories_Card story1 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story2 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story3 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story4 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story5 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories = db.getAllStories();
        Recycler_Adapter_Stories adapter_stories = new Recycler_Adapter_Stories(Stories, new OnClickListener_Stories() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Educational_Stories.this, webView_Anbyaa_Stories.class);
                intent.putExtra("page",position);
                intent.putExtra("sound",position);
                startActivity(intent);
            }});
        db.insertStory(story1);
        db.insertStory(story2);
        db.insertStory(story3);
        db.insertStory(story4);
        db.insertStory(story5);
        rv_educational_stories.setAdapter(adapter_stories);
        rv_educational_stories.setLayoutManager(new LinearLayoutManager(Educational_Stories.this));
    }} */
