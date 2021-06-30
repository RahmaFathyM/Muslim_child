package com.example.l.anasheed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.R;

import java.util.ArrayList;

 public class RecyclerAdapter_Anasheed extends RecyclerView.Adapter<RecyclerAdapter_Anasheed.ViewHolder_Anasheed> {
    OnClickListener_Stories_anasheed listener_stories ;
    ArrayList<Anasheed_Card> arrayList ;
     public RecyclerAdapter_Anasheed(ArrayList<Anasheed_Card> arrayList, OnClickListener_Stories_anasheed listener_stories) {
         this.listener_stories = listener_stories;
         this.arrayList = arrayList;
     }
     @NonNull
     @Override
     public ViewHolder_Anasheed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_anasheed_layout,null,false);
         ViewHolder_Anasheed viewHolder_anasheed = new ViewHolder_Anasheed(v);
         return  viewHolder_anasheed;
     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder_Anasheed holder, int position) {
         Anasheed_Card c =  arrayList.get(position);
        // holder.img.setImageResource(c.getId());
         holder.tv_title.setText(c.getTitle());
     }
     @Override
     public int getItemCount() {
         return arrayList.size();
     }


     class ViewHolder_Anasheed extends RecyclerView.ViewHolder{

        TextView tv_title;
        public ViewHolder_Anasheed(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title_name);
           itemView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          listener_stories.onClick(getAdapterPosition());

                                      }
                                  }
           );
        }
    }}
