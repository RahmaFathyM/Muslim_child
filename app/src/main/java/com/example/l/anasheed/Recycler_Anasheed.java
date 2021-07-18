package com.example.l.anasheed;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.R;
import com.example.l.adapter.OnClickListener_Stories_anasheed_quraan;
import com.example.l.adapter.Recycler_Adapter_String;

import java.util.ArrayList;

public class Recycler_Anasheed extends AppCompatActivity {
    RecyclerView rv_anasheed;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasheed);
        rv_anasheed = findViewById(R.id.rv_anasheed);
        arrayList = new ArrayList<>();
        arrayList.add("الله ربى والإسلام دينى");
        arrayList.add("أركان الإسلام");
        arrayList.add("محمد نبينا");
        arrayList.add("الصلاة");
        arrayList.add("قرآنى");
        arrayList.add("الله أكبر بسم الله");
        arrayList.add("طلع البدر علينا");
        arrayList.add("أهلاً رمضان");
        arrayList.add("الشهور الهجرية");

        Recycler_Adapter_String recyclerAdapter_anasheed = new Recycler_Adapter_String(arrayList, "#81CAAD", new OnClickListener_Stories_anasheed_quraan() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Recycler_Anasheed.this, Play_Anasheed.class);
                intent.putExtra("position", position);

                startActivity(intent);
            }
        });


        rv_anasheed.setAdapter(recyclerAdapter_anasheed);
        rv_anasheed.setLayoutManager(new LinearLayoutManager(Recycler_Anasheed.this));
    }
}
