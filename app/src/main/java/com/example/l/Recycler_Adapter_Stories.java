package com.example.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.adapter.OnClickListener_Stories_anasheed;
import com.example.l.stories.Stories_Card;
import com.example.muslim_child.R;

import java.util.ArrayList;

public class Recycler_Adapter_Stories extends RecyclerView.Adapter<Recycler_Adapter_Stories.ViewHolderStories> {

    OnClickListener_Stories_anasheed listener_stories ;
    ArrayList<Stories_Card> arrayList ;
    public Recycler_Adapter_Stories(ArrayList<Stories_Card> arrayList, OnClickListener_Stories_anasheed listener_stories) {
        this.listener_stories = listener_stories;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolderStories onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_stories_layout,null,false);
        ViewHolderStories viewHolderStories = new ViewHolderStories(v);
        return viewHolderStories;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStories holder, int position) {
        Stories_Card c =  arrayList.get(position);

        holder.tv_story_name.setText(c.getNameStory());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class ViewHolderStories extends RecyclerView.ViewHolder{

        TextView tv_story_name;
        public ViewHolderStories(@NonNull View itemView) {
            super(itemView);

            tv_story_name = itemView.findViewById(R.id.tv_story_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener_stories.onClick(getAdapterPosition());

                }
            });
        }
    }
}
