package com.example.l.azkar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.l.R;
import com.example.l.adapter.OnClickListener_Stories_anasheed_quraan;

import java.util.ArrayList;

public class Azkar_Adapter extends RecyclerView.Adapter<Azkar_Adapter.Azkar_VH> {
    ArrayList<Integer> arrayList;
    OnClickListener_Stories_anasheed_quraan listener_azkar;

    public Azkar_Adapter(ArrayList<Integer> arrayList, OnClickListener_Stories_anasheed_quraan listener_azkar) {
        this.arrayList = arrayList;
        this.listener_azkar = listener_azkar;
    }

    @NonNull
    @Override
    public Azkar_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Azkar_VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.azkar_card, null));
    }

    @Override
    public void onBindViewHolder(@NonNull Azkar_VH holder, int position) {
        int zekr_image = arrayList.get(position);
        holder.zekr_image.setImageResource(zekr_image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Azkar_VH extends RecyclerView.ViewHolder {
        ImageView zekr_image;

        public Azkar_VH(@NonNull View itemView) {

            super(itemView);
            zekr_image = itemView.findViewById(R.id.card_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener_azkar.onClick(getAdapterPosition());
                }
            });
        }
    }
}
