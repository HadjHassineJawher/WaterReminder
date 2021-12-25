package com.water.reminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.water.reminder.SQLITE.DatabaseHelper;
import com.water.reminder.SQLITE.User;
import com.water.reminder.SharedPrefernces.UserSessionManager;


public class ProfileFragment extends Fragment {
    UserSessionManager session;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        session= new UserSessionManager(getContext());
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        User user = session.getUserDetails();
        User current_user= dbHelper.getUserByID(Integer.parseInt(user.getId()));

        TextView txt_username, txt_email, txt_weight, txt_height;

        txt_username= v.findViewById(R.id.txt_username);
        txt_email= v.findViewById(R.id.txt_email);
        txt_weight= v.findViewById(R.id.txt_weight);
        txt_height= v.findViewById(R.id.txt_height);

        txt_username.setText(user.getUsername());
        txt_email.setText(current_user.getEmail());
        txt_weight.setText(current_user.getWeigth());
        txt_height.setText(current_user.getHeigth());

        return  v;
    }
}