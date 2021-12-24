package com.water.reminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.water.reminder.SQLITE.User;
import com.water.reminder.SharedPrefernces.UserSessionManager;

public class SettingsFragment extends Fragment {
    UserSessionManager session;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.settings_fragment,container,false);
        session= new UserSessionManager(getContext());
        TextView ev_id= v.findViewById(R.id.txtv_id);
        TextView ev_username= v.findViewById(R.id.txtv_username);
        TextView ev_email= v.findViewById(R.id.txtv_email);
        Button btn_logout= v.findViewById(R.id.button);
        User user = session.getUserDetails();
        ev_id.setText(user.getId());
        ev_username.setText(user.getUsername());
        ev_email.setText(user.getEmail());
        System.out.println("id :"+user.getId());
        System.out.println("username :"+user.getUsername());
        System.out.println("email :"+user.getEmail());

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();
            }
        });
        return v;
    }
}
