package com.example.l.stories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.R;
import com.example.l.Recycler_Adapter_Stories;

import java.util.ArrayList;

import static com.example.l.R.*;

public class Anbyaa_Stories extends AppCompatActivity {
    RecyclerView rv_anbyaa_stories ;
    DataBase_Stories db ;
    ArrayList<Stories_Card> Stories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String [] storyNames = {"قصة آدم", "قصة نوح", "قصة هود","قصصة صالح", "قصة إبراهيم" , "قصة يونس" , "قصة موسى", "قصة داوود وسليمان" ,"قصة محمد",};

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final ArrayList<Integer>MB3Sounds =new ArrayList<>();
        MB3Sounds .add(R.raw.sydnaadam);
        MB3Sounds .add(R.raw.sydnanooh);
        MB3Sounds .add(R.raw.sydnahoud);
        MB3Sounds .add(R.raw.sydnasaleh);
        MB3Sounds .add(R.raw.sydnaebraheem);
        MB3Sounds .add(R.raw.sydnayounos);
        MB3Sounds .add(R.raw.sydnamosa);
        MB3Sounds .add(R.raw.dawoodandsoliman);
        MB3Sounds .add(R.raw.sydnamohamed);
        final ArrayList<String>MB3page =new ArrayList<>();
        MB3page.add("sydnaadm");
        MB3page.add("sydnanoh");
        MB3page.add("sydnahod");
        MB3page.add("sydnasaleh");
        MB3page.add("sydnaebrahem");
        MB3page.add("sydnayounos");
        MB3page.add("sydnamousa");
        MB3page.add("dawoodandsoliman");
        MB3page.add("sydnamohamed");
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_anbyaa__stories);
        final MediaPlayer name_story=MediaPlayer.create(Anbyaa_Stories.this, raw.adam_voice);

//        db = new DataBase_Stories(this);
        rv_anbyaa_stories = (RecyclerView)findViewById(id.rv_anbyaa_stories);
        Stories = new ArrayList<>();        // khleh yget men el data base ;
    Stories_Card story1 = new Stories_Card("قصة سيدنا آدم" , drawable.icon);
        Stories_Card story2= new Stories_Card("قصة سيدنا نوح" , drawable.icon);
        Stories_Card story3 = new Stories_Card("قصة سيدنا هود" , drawable.icon);
        Stories_Card story4= new Stories_Card("قصة سيدنا صالح" , drawable.icon);
        Stories_Card story5 = new Stories_Card("قصة سيدنا إبراهيم" , drawable.icon);
        Stories_Card story6 = new Stories_Card("قصة سيدنا يونس" , drawable.icon);
        Stories_Card story7 = new Stories_Card("قصة سيدنا موسى" , drawable.icon);
        Stories_Card story8 = new Stories_Card("قصة سيدنا داوود وسيدنا سليمان" , drawable.icon);
        Stories_Card story9 = new Stories_Card("قصة سيدنا محمد" , drawable.icon);
Stories.add(story1);
        Stories.add(story2);
        Stories.add(story3);
        Stories.add(story4);
        Stories.add(story5);
        Stories.add(story6);
        Stories.add(story7);
        Stories.add(story8);
        Stories.add(story9);
//        Stories = db.getAllStories();
        Recycler_Adapter_Stories adapter_stories = new Recycler_Adapter_Stories(Stories, new OnClickListener_Stories_anasheed() {
            @Override
            public void onClick(int position) {

                name_story.start();
                Intent intent = new Intent(Anbyaa_Stories.this, webView_Anbyaa_Stories.class);
                intent.putExtra("storyName",storyNames[position]);
            intent.putExtra("page",MB3page.get(position));
                intent.putExtra("sound",MB3Sounds.get(position));
                startActivity(intent);
            }
        }
        );
//        db.insertStory(story1);
//        db.insertStory(story2);
//        db.insertStory(story3);
//        db.insertStory(story4);
//        db.insertStory(story5);
//        db.insertStory(story6);
//        db.insertStory(story7);
//        db.insertStory(story8);
//        db.insertStory(story9);
        rv_anbyaa_stories.setAdapter(adapter_stories);
        rv_anbyaa_stories.setLayoutManager(new LinearLayoutManager(Anbyaa_Stories.this));

    }

}
