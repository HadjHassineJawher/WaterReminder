package com.water.reminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SignupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          View v =inflater.inflate(R.layout.signup_fragment,container,false);
          Fragment sgininFragment= new SigninFragment();
          Button btnBack= v.findViewById(R.id.back_to_signin);
          Button btn_sgin_up=v.findViewById(R.id.btn_sgin_up);
          EditText edt_email=v.findViewById(R.id.edt_email);
          EditText edt_password=v.findViewById(R.id.edt_password);
          EditText edt_confirme_password=v.findViewById(R.id.edt_confirme_password);
          EditText edt_height=v.findViewById(R.id.edt_height);
          EditText edt_weight=v.findViewById(R.id.edt_weight);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.authentification_container,sgininFragment).commit();

            }
        });

        btn_sgin_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        (
                                checkEmail(edt_email)&&
                                checkPassword(edt_password)&&
                                checkConfirmePassword(edt_confirme_password,edt_password)&&
                                isEmpty(edt_height)&&
                                isEmpty(edt_weight)
                        )==true
                ){
                    getFragmentManager().beginTransaction().replace(R.id.authentification_container,sgininFragment).commit();
                }

            }
        });
        return v;
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

    public  boolean checkConfirmePassword(EditText editTextone,EditText editTexttow){
        boolean res= true;
        if(!(editTextone.getText().toString().equals(editTexttow.getText().toString()))){
            editTextone.setError("Password dosent much !!!");
            res= false;

        }
        return res;
    }
    public  boolean isEmpty(EditText editText){
        boolean res= true;
        if (editText.getText().length()==0){
            editText.setError("This field is empty!!!");
            res=false;
        }
        return res;
    }
}
