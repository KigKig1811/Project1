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
import com.kig2.project1.model.Adv;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SaleAdapter extends BaseAdapter {
    Context context;
    ArrayList<Adv> arraySale;

    public SaleAdapter(Context context, ArrayList<Adv> arraySale) {
        this.context = context;
        this.arraySale = arraySale;
    }

    @Override
    public int getCount() {
        return arraySale.size();
    }

    @Override
    public Object getItem(int i) {
        return arraySale.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        public TextView txtten,txtprice,txtcontent;
        public ImageView iv;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){


             viewHolder=new ViewHolder();
             LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             view=layoutInflater.inflate(R.layout.dong_sale,null);
             viewHolder.txtten=view.findViewById((R.id.tvTen));
            viewHolder.txtprice=view.findViewById((R.id.tvPrice));
            viewHolder.txtcontent=view.findViewById((R.id.tvHeader));
            viewHolder.iv=view.findViewById(R.id.imageviewSale);
            view.setTag(viewHolder);


        }
        else{
            viewHolder= (ViewHolder) view.getTag();

        }
        Adv adv= (Adv) getItem(i);
        viewHolder.txtten.setText(adv.getHeader());
        viewHolder.txtprice.setText((int) adv.getPrice());
        viewHolder.txtcontent.setText(adv.getContent());
        Picasso.with(context).load(adv.getPhoto())
                .placeholder(R.drawable.no)
                .error(R.drawable.error)
                .into(viewHolder.iv);
        return view;
    }
}
