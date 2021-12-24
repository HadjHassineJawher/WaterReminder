package com.water.reminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.water.reminder.Adapters.StatsAdapter;
import com.water.reminder.Class.status;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.stats_fragment,container,false);
        List listStats= new ArrayList<status>();


        status stat_1 = new status("Monday","100 %","@drawable/healthy_icon","@drawable/verified_icon");
        status stat_2 = new status("Tuesday","80 %","@drawable/healthy_icon","@drawable/verified_icon");
        status stat_3 = new status("Wednesdays","39 %","@drawable/sick_icon","@drawable/failed");
        status stat_4 = new status("Thursdays","70 %","@drawable/healthy_icon","@drawable/verified_icon");
        status stat_5 = new status("Fridays","20 %","@drawable/sick_icon","@drawable/failed");
        status stat_6 = new status("Saturdays","90 %","@drawable/healthy_icon","@drawable/verified_icon");
        status stat_7 = new status("Sundays","19 %","@drawable/sick_icon","@drawable/failed");


        listStats.add(stat_1);
        listStats.add(stat_2);
        listStats.add(stat_3);
        listStats.add(stat_4);
        listStats.add(stat_5);
        listStats.add(stat_6);
        listStats.add(stat_7);


        recyclerView = v.findViewById(R.id.recv_statistics);
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        StatsAdapter statsAdapter = new StatsAdapter(getContext(),listStats);
        recyclerView.setAdapter(statsAdapter);

        return  v;
    }
}
