package com.example.l.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.R;

import java.util.ArrayList;

public class Recycler_Adapter_String extends RecyclerView.Adapter<Recycler_Adapter_String.ViewHolderString> {

    OnClickListener_Stories_anasheed_quraan listener;
    ArrayList<String> arrayList;
    String color_story_name;

    public Recycler_Adapter_String(ArrayList<String> arrayList, String color_story_name, OnClickListener_Stories_anasheed_quraan listener_stories) {
        this.listener = listener_stories;
        this.arrayList = arrayList;
        this.color_story_name = color_story_name;

    }

    @NonNull
    @Override
    public ViewHolderString onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycler_tv_layout, null, false);
        ViewHolderString viewHolderStories = new ViewHolderString(v);
        return viewHolderStories;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderString holder, int position) {
        String card_item_name = arrayList.get(position);
        holder.tv_card_name.setText(card_item_name);
        holder.tv_card_name.setTextColor(Color.parseColor(color_story_name));
        holder.tv_card_name.setShadowLayer(2, 2, 0, Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolderString extends RecyclerView.ViewHolder {
        TextView tv_card_name;

        public ViewHolderString(@NonNull View itemView) {
            super(itemView);
            tv_card_name = itemView.findViewById(R.id.tv_card_name);
            // tv_card_name.setTextColor(Color.parseColor("#ffffff"));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition());

                }
            });
        }
    }
}
