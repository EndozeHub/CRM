package com.rogfer.crm.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rogfer.crm.R;
import com.rogfer.crm.models.LeadListModels;

import java.util.ArrayList;

public class LeadListAdapter extends RecyclerView.Adapter<LeadListAdapter.ViewHolder> {
    ArrayList<LeadListModels> listModels;
    Activity activity;
    Context context;

    public LeadListAdapter(ArrayList<LeadListModels> listModels, Activity activity, Context context) {
        this.listModels = listModels;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lead_list_block, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LeadListModels lm = listModels.get(position);
        holder.name.setText(lm.getName());
        holder.phone.setText(lm.getPhone());

        holder.dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + lm.getPhone()));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, phone;
        ImageButton dialer;
        RelativeLayout Rowlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            dialer = itemView.findViewById(R.id.dialer);
            Rowlayout = itemView.findViewById(R.id.Rowlayout);

        }
    }
}
