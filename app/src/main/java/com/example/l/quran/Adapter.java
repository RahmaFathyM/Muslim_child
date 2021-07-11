package com.example.l.quran;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.R;
import com.example.l.adapter.OnClickListener_Stories_anasheed;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {
    ArrayList<QuranDataBase> arrayList;
    OnClickListener_Stories_anasheed mylistener;

    public Adapter(ArrayList<QuranDataBase> arrayList1, OnClickListener_Stories_anasheed onClickListener_stories) {
        this.arrayList = arrayList;
        this.mylistener = onClickListener_stories;

    }

    @NonNull
    @Override
    public Adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_quraan, null, false);
        myviewholder myviewholder = new myviewholder(view);

        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.myviewholder holder, int position) {
        holder.textView.setText(arrayList.get(position).getName());
        holder.imageView.setImageResource(arrayList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.img_quran);
            textView =  itemView.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mylistener.onClick(getAdapterPosition());


                }
            });
        }
    }
}
