package com.jal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jal.interfaces.OnRyClickListener;
import com.jal.weatherdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEELE on 2017/4/24.
 */

public class CityRyAdapter extends RecyclerView.Adapter<CityRyAdapter.CityViewHolder> {

    private Context context;

    private List<String> city;

    private OnRyClickListener listener;

    public CityRyAdapter(Context context) {
        this.context = context;
        this.city = new ArrayList<>();
    }

    public void setListener(OnRyClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<String> city) {
        this.city = city;
        this.notifyDataSetChanged();
    }

    public void removeDate(int position) {
        city.remove(position);
        notifyItemRemoved(position);
    }

    public List<String> getCity() {
        return city;
    }

    public void addCity(String city){
        this.city.add(city);
        this.notifyDataSetChanged();
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(inflate, listener);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.tvName.setText(city.get(position));
    }

    @Override
    public int getItemCount() {
        return city.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivImage;
        private OnRyClickListener listener;

        public CityViewHolder(final View itemView, final OnRyClickListener listener) {
            super(itemView);
            this.listener = listener;
            tvName = (TextView) itemView.findViewById(R.id.tv_city_name);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_del);
            ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(itemView, getAdapterPosition());
                    }
                }
            });

        }
    }
}
