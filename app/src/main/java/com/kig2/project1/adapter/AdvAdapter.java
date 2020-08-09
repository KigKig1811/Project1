package com.kig2.project1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kig2.project1.*;
import com.kig2.project1.model.Adv;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdvAdapter extends RecyclerView.Adapter<AdvAdapter.ItemHolder> {
    Context context;
    ArrayList<Adv> arrayAdv;

    public AdvAdapter(Context context, ArrayList<Adv> arrayAdv) {
        this.context = context;
        this.arrayAdv = arrayAdv;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_advnew,null);
        ItemHolder itemHolder=new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Adv adv=arrayAdv.get(position);
        holder.area.setText("Area"+(int) adv.area);
        holder.bedroom.setText("Bedroom"+adv.bedroom);
        Picasso.with(context).load(adv.getPhoto())
                .placeholder(R.drawable.no)
                .error(R.drawable.error)
                .into(holder.imageAdv);
    }

    @Override
    public int getItemCount() {
        return arrayAdv.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imageAdv;
        public TextView area;
        public TextView bedroom;


        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imageAdv=itemView.findViewById(R.id.ivAdv);
            area=itemView.findViewById(R.id.tvArea);
            bedroom=itemView.findViewById(R.id.tvBedroom);
        }
    }
}
