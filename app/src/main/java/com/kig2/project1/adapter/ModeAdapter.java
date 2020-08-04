package com.kig2.project1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.kig2.project1.R;
import com.kig2.project1.model.Mode;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ModeAdapter extends BaseAdapter {
    ArrayList<Mode> arrayMode;
    Context context;

    public ModeAdapter(ArrayList<Mode> arrayMode, Context context) {
        this.arrayMode = arrayMode;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayMode.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayMode.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public  class ViewHolder{
        TextView txtMode;
        ImageView ivMode;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view == null){
            viewHolder =new ViewHolder();
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.dong_listview_adv,null);
            viewHolder.txtMode=view.findViewById(R.id.tvMode);
            viewHolder.ivMode=view.findViewById(R.id.ivMode);
            view.setTag(viewHolder);
        }
        else{
            viewHolder= (ModeAdapter.ViewHolder) view.getTag();

        }
        Mode mode= (Mode) getItem(i);
        viewHolder.txtMode.setText(mode.getModeName());
        Picasso.with(context).load(mode.getImage())
                .placeholder(R.drawable.no)
                .error(R.drawable.error)
                .into(viewHolder.ivMode);
        return view;
    }
}
