package com.rogfer.crm.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rogfer.crm.AppointmentListActivity;
import com.rogfer.crm.LeadsListActivity;
import com.rogfer.crm.R;
import com.rogfer.crm.models.HomeGridModels;

import java.util.ArrayList;

public class HomeGridAdapter extends RecyclerView.Adapter<HomeGridAdapter.ViewHolder> {
    ArrayList<HomeGridModels> homeGridModels;
    Activity activity;
    Context context;

    public HomeGridAdapter(ArrayList<HomeGridModels> homeGridModels, Activity activity, Context context) {
        this.homeGridModels = homeGridModels;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_blocks, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(homeGridModels.get(position).getName());
        //holder.image.setImageResource();
        Glide.with(context).load(homeGridModels.get(position).getImg()).into(holder.image);
        holder.Rowlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (homeGridModels.get(position).getId()) {
                    case "1":
                        break;

                    case "2":
                        Intent intent = new Intent(activity, LeadsListActivity.class);
                        activity.startActivity(intent);
                        break;
                    case"6":
                        Intent intent1 = new Intent(activity, AppointmentListActivity.class);
                        activity.startActivity(intent1);
                        break;

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return homeGridModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView Rowlayout;
        TextView title;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Rowlayout = itemView.findViewById(R.id.Rowlayout);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);

        }
    }
}
