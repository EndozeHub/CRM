package com.rogfer.crm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rogfer.crm.adapter.AppointmentAdapter;
import com.rogfer.crm.adapter.LeadListAdapter;
import com.rogfer.crm.models.AppointmentLisymodels;
import com.rogfer.crm.models.LeadListModels;

import java.util.ArrayList;

public class AppointmentListActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Toolbar toolbar;
    AppointmentAdapter adapter;
    ArrayList<AppointmentLisymodels> listModels;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_list);
        initToolbar();
        listModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rc_customer);

        /*fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppointmentListActivity.this, AppointmentAddActivity.class);
                startActivity(intent);
            }
        });*/


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new AppointmentAdapter(listModels, AppointmentListActivity.this, getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listModels.add(new AppointmentLisymodels("1", "Test IDEA Indv", "Coal Estate","12345678","Breakdown","Air Conditioner"));
        listModels.add(new AppointmentLisymodels("2", "Test IDEA Indv", "Coal Estate","12345678","Breakdown","Air Conditioner"));
        listModels.add(new AppointmentLisymodels("3", "Test IDEA Indv", "Coal Estate","12345678","Breakdown","Air Conditioner"));
        listModels.add(new AppointmentLisymodels("4", "Test IDEA Indv", "Coal Estate","12345678","Breakdown","Air Conditioner"));
        adapter.notifyDataSetChanged();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Appointments");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
