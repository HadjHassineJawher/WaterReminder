package com.water.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SigninFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.signin_fragment,container,false);
        TextView sign_up = v.findViewById(R.id.SignUp);
        Fragment sign_up_fragment= new SignupFragment();

        Button btnsignIn= v.findViewById(R.id.btn_login);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.authentification_container,sign_up_fragment).commit();

            }


        });
        btnsignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        return  v;


    }
}
