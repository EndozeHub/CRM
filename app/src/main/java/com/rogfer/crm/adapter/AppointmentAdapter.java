package com.rogfer.crm.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rogfer.crm.AppointmentAddActivity;
import com.rogfer.crm.R;
import com.rogfer.crm.models.AppointmentLisymodels;
import com.rogfer.crm.models.LeadListModels;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    ArrayList<AppointmentLisymodels> listModels;
    Activity activity;
    Context context;

    public AppointmentAdapter(ArrayList<AppointmentLisymodels> listModels, Activity activity, Context context) {
        this.listModels = listModels;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AppointmentLisymodels lm = listModels.get(position);
        holder.apTpe.setText(lm.getDesc());
        holder.apVisit.setText(lm.getVistLevel());
        holder.apTit.setText(lm.getTittle());
        holder.apVisit1.setText(lm.getVistLevel());
        holder.apId.setText(lm.getId());
        holder.apTp.setText(lm.getDesc());
        holder.Rowlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, AppointmentAddActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView aptme, apVisit, apTpe, apTit, apVisit1, apId, apTp;
        RelativeLayout Rowlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            aptme = itemView.findViewById(R.id.ap_time);
            apVisit = itemView.findViewById(R.id.ap_visit_level);
            apTpe = itemView.findViewById(R.id.ap_tpe);
            apTit = itemView.findViewById(R.id.ap_tit);
            apVisit1 = itemView.findViewById(R.id.ap_visit_level1);
            apId = itemView.findViewById(R.id.ap_id);
            apTp = itemView.findViewById(R.id.ap_tp);
            Rowlayout = itemView.findViewById(R.id.Rowlayout);

        }
    }
}
