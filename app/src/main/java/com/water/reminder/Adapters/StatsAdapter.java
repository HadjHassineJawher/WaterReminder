package com.water.reminder.Adapters;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.water.reminder.Class.status;
import com.water.reminder.R;


import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.statsViewHolder>{
    public static Context context;
    List<status> listStats;


    public StatsAdapter(Context context,List<status>listStats){
        this.context= context;
        this.listStats= listStats;

    }
    public static Context getContext() {
        return context;
    }
    @NonNull
    @Override
    public StatsAdapter.statsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new statsViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.stats_recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StatsAdapter.statsViewHolder holder, int position) {
        status status= listStats.get(position);

        String img = status.getImage();
        String icon = status.getIcon();
        int id_img = getContext().getResources().getIdentifier(img, "drawable", getContext().getPackageName());
        int id_icon = getContext().getResources().getIdentifier(icon, "drawable", getContext().getPackageName());
        Drawable drawable_img = getContext().getResources().getDrawable(id_img);
        Drawable drawable_icon = getContext().getResources().getDrawable(id_icon);

        holder.txtv_day.setText(status.getDay());
        holder.txtv_percentage.setText(status.getPercentege());
        holder.imgv_sats.setImageDrawable(drawable_img);
        holder.imgv_icon.setImageDrawable(drawable_icon);
    }

    @Override
    public int getItemCount() {
        return this.listStats.size();
    }

    public class statsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout_stats;
        ImageView imgv_sats;
        TextView txtv_day;
        TextView txtv_percentage;
        ImageView imgv_icon;


        public statsViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout_stats= (LinearLayout) itemView.findViewById(R.id.llay_stats);
            imgv_sats= (ImageView) itemView.findViewById(R.id.imgv_stats);
            txtv_day= (TextView) itemView.findViewById(R.id.txtv_day);
            txtv_percentage= (TextView) itemView.findViewById(R.id.txtv_percentage);
            imgv_icon= (ImageView) itemView.findViewById(R.id.imgv_icon);

        }
    }
}
