package com.rogfer.crm;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.rogfer.crm.adapter.LeadListAdapter;
import com.rogfer.crm.models.LeadListModels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class LeadsListActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Toolbar toolbar;
    LeadListAdapter adapter;
    ArrayList<LeadListModels> listModels;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads_list);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initToolbar();

        listModels = new ArrayList<>();
        recyclerView = findViewById(R.id.rc_customer);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeadsListActivity.this, LeadAddActivity.class);
                startActivity(intent);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new LeadListAdapter(listModels, LeadsListActivity.this, getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listModels.add(new LeadListModels("1", "Bala", "+91 9876543210"));
        listModels.add(new LeadListModels("2", "Ashwin", "+91 9876543210"));
        listModels.add(new LeadListModels("3", "Karthi", "+91 9876543210"));
        listModels.add(new LeadListModels("4", "Dhaya", "+91 9876543210"));
        listModels.add(new LeadListModels("5", "Raj", "+91 9876543210"));
        listModels.add(new LeadListModels("6", "Saravana", "+91 9876543210"));
        adapter.notifyDataSetChanged();

    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Leads");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
