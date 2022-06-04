package com.example.l.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.l.Adapter;
import com.example.l.DataBase;
import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.Recycler_Adapter_Stories;
import com.example.muslim_child.R;

import java.util.ArrayList;

public class Quran extends AppCompatActivity {
    RecyclerView recyclerView;
    //DataBase dataBase ;
    TextView textView ;
    ArrayList<QuranDataBase> quraan_list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        textView = (TextView)findViewById(R.id.txt_title_name);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.
                LayoutParams.FLAG_FULLSCREEN);

        quraan_list = new ArrayList<>();
        //dataBase = new DataBase(this);
        //QuranDataBase first = new QuranDataBase( " سورة عم ",R.drawable.boy);
        //quraan_list = dataBase.getallsor() ;






        Adapter adapter = new Adapter(quraan_list, new OnClickListener_Stories_anasheed() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Quran.this,web_view_quraan.class);
                intent.putExtra("page",position);
                intent.putExtra("sound",position );
                startActivity(intent);
                Toast.makeText(Quran.this, "arwa", Toast.LENGTH_SHORT).show();
            }

        });

        //dataBase.insertquraan(first);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

    }


}
