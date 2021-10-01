package com.water.reminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SignupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          View v =inflater.inflate(R.layout.signup_fragment,container,false);
          Fragment sgininFragment= new SigninFragment();
        Button btnBack= v.findViewById(R.id.back_to_signin);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.authentification_container,sgininFragment).commit();

            }
        });

        return v;
    }
}
