package com.water.reminder;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SigninFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.signin_fragment,container,false);
        TextView sign_up = v.findViewById(R.id.SignUp);
        Fragment sign_up_fragment= new SignupFragment();
        EditText edt_email=v.findViewById(R.id.edt_email);
        EditText edt_password= v.findViewById(R.id.edt_password);

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

               checkEmail(edt_email);
               checkPassword(edt_password);
               if ((checkEmail(edt_email)==true)&&(checkPassword(edt_password))){
                   Intent intent =new Intent(getContext(),MainActivity.class);
                   startActivity(intent);
               }
            }
        });
        return  v;


    }

    public boolean checkEmail(EditText editText){
        boolean res= true;
        if(editText.getText().toString().trim().length()==0){
            editText.setError("This field is empty!!!");
            res=false;
        }else if(!editText.getText().toString().contains("@")){
            editText.setError("Invalid email !!!");
            res=false;
        }
        return res;
    }

    public boolean checkPassword(EditText editText){
        boolean res= true;
        if(editText.getText().toString().trim().length()==0){
            editText.setError("This field is empty!!!");
            res=false;
        }else if(editText.getText().toString().length()<6){
            editText.setError("Password must contain at least seven characters !!!");
            res=false;
        }
        return res;
    }

}


