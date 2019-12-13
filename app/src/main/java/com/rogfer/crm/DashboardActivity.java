package com.rogfer.crm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rogfer.crm.adapter.HomeGridAdapter;
import com.rogfer.crm.adapter.ItemOffsetDecoration;
import com.rogfer.crm.models.HomeGridModels;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    private HomeGridAdapter adapter;
    ArrayList<HomeGridModels> homeGridModels;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.rc_grid);
        homeGridModels = new ArrayList<>();

        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getApplicationContext(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

        adapter = new HomeGridAdapter(homeGridModels, DashboardActivity.this, getApplicationContext());
        recyclerView.setAdapter(adapter);

        homeGridModels.add(new HomeGridModels("1", "Calender", "", R.drawable.ic_calender));
        homeGridModels.add(new HomeGridModels("2", "Leads", "", R.drawable.ic_leads));
        homeGridModels.add(new HomeGridModels("3", "Contact", "", R.drawable.ic_contact));
        homeGridModels.add(new HomeGridModels("4", "ToDo list", "", R.drawable.ic_todo));
        homeGridModels.add(new HomeGridModels("5", "Events", "", R.drawable.ic_events));
        homeGridModels.add(new HomeGridModels("6", "Appointments", "", R.drawable.ic_appointments));
        homeGridModels.add(new HomeGridModels("7", "Activity", "", R.drawable.ic_activities));
        homeGridModels.add(new HomeGridModels("8", "Team Feeds", "", R.drawable.ic_teamfeeds));
        adapter.notifyDataSetChanged();


    }
}
