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

public class Entertainment_Stories extends AppCompatActivity {
    RecyclerView rv_entermainment_stories;
    DataBase_Stories db ;
    ArrayList<Stories_Card> Stories;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment__stories);
        //  final MediaPlayer name_story=MediaPlayer.create(Educational_Stories.this, R.raw.adam_voice);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // ??
        db = new DataBase_Stories(this);
        rv_entermainment_stories = (RecyclerView)findViewById(R.id.rv_enter_stories);
       final String [] storyNames = {"هرة فى الأحذية", "الخنازير الثلاثة", "الغربان الذكية","الأميرة والضفدع", "الأمير الثعبان" , "الأرنب والسلحفاة"  ,"الجنود الشجعان الثلاثة" , "الحورية الصغيرة", "الماعز الثلاثة","الثعلب والماعز","فطيرة كبيرة","حكاية توم الإصبع"};  // at the top of webView...
       final ArrayList<Integer>MB3Sounds =new ArrayList<>();
        MB3Sounds.add(R.raw.catinshoes);
        MB3Sounds.add(R.raw.el5anazerelse8aeelslasa);
        MB3Sounds.add(R.raw.el8erbanelzakya);
        MB3Sounds.add(R.raw.elamiraweldofd3);
        MB3Sounds.add(R.raw.elamirelso3ban);
        MB3Sounds.add(R.raw.elarnabwelsolhfa);
        MB3Sounds.add(R.raw.elgnodelsheg3an);
        MB3Sounds.add(R.raw.elhoryaelsa8era);
        MB3Sounds.add(R.raw.elmma3ezelslasa);
        MB3Sounds.add(R.raw.els3labwelma3ez);
        MB3Sounds.add(R.raw.feteraelkebera);
        MB3Sounds.add(R.raw.hekayettomelesb3);
    final ArrayList<String>MB3page =new ArrayList<>();
        MB3page.add("catinshoes");
        MB3page.add("el5anazerelse8aeelslasa");
        MB3page.add("el8erbanelzakya");
        MB3page.add("elamiraweldofd3");
        MB3page.add("elamirelso3ban");
        MB3page.add("elarnabwelsolhfa");
        MB3page.add("elgnodelsheg3an");
        MB3page.add("elhoryaelsa8era");
        MB3page.add("elmma3ezelslasa");
        MB3page.add("els3labwelma3ez");
        MB3page.add("feteraelkebera");
        MB3page.add("hekayettomelesb3");

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
        Intent intent = new Intent(Entertainment_Stories.this, webView_Entertainment_Stories.class);
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
        rv_entermainment_stories.setAdapter(adapter_stories);
        rv_entermainment_stories.setLayoutManager(new LinearLayoutManager(Entertainment_Stories.this));
        }}

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment__stories);
        rv_entermainment_stories = findViewById(R.id.rv_anbyaa_stories);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
                Intent intent = new Intent(Entertainment_Stories.this, webView_Anbyaa_Stories.class);
                intent.putExtra("page",position);
                intent.putExtra("sound",position);
                startActivity(intent);
            }});
        db.insertStory(story1);
        db.insertStory(story2);
        db.insertStory(story3);
        db.insertStory(story4);
        db.insertStory(story5);
        rv_entermainment_stories.setAdapter(adapter_stories);
        rv_entermainment_stories.setLayoutManager(new LinearLayoutManager(Entertainment_Stories.this));
     }}
*/