package com.jal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jal.interfaces.OnRyClickListener;
import com.jal.weatherdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEELE on 2017/4/20.
 */

public class StarRyAdapter extends RecyclerView.Adapter<StarRyAdapter.MyViewHolder> {

    private Context context;
    private List<Integer> images = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private OnRyClickListener listener;

    public StarRyAdapter(Context context, int[] images, List<String> names) {
        this.context = context;
        this.names = names;
        for (int i = 0; i < images.length; i++) {
            this.images.add(images[i]);
        }

    }

    public void setListener(OnRyClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_select_ry, parent, false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvStar.setText(names.get(position));
        Glide.with(context)
                .load(images.get(position))
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.ivStar);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView ivStar;
        private TextView tvStar;
        private OnRyClickListener listener;

        public MyViewHolder(View itemView, OnRyClickListener listener) {
            super(itemView);
            this.listener = listener;
            ivStar = (ImageView) itemView.findViewById(R.id.iv_star);
            tvStar = (TextView) itemView.findViewById(R.id.tv_star_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(itemView, getAdapterPosition());
            }
        }
    }
}
