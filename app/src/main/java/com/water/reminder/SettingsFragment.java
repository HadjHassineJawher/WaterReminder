package com.water.reminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.water.reminder.SQLITE.DatabaseHelper;
import com.water.reminder.SQLITE.User;
import com.water.reminder.SharedPrefernces.UserSessionManager;

public class SettingsFragment extends Fragment {
    UserSessionManager session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.settings_fragment,container,false);
        session= new UserSessionManager(getContext());
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        User user = session.getUserDetails();
        User user_settings= dbHelper.getUserByID(Integer.parseInt(user.getId()));
        Fragment home_fragment = new HomeFragment();

        Button btn_update = v.findViewById(R.id.btn_update);
        EditText edt_username = v.findViewById(R.id.edt_username);
        EditText edt_password = v.findViewById(R.id.edt_password);
        EditText edt_confirme_password = v.findViewById(R.id.edt_confirme_password);
        EditText edt_height = v.findViewById(R.id.edt_height);
        EditText edt_weight = v.findViewById(R.id.edt_weight);
        System.out.println("id current user :" + user_settings.getId());

       try{
            user.toString();
            edt_username.setText(user_settings.getUsername());
            edt_password.setText(user_settings.getPassword());
            edt_height.setText(user_settings.getHeigth());
            edt_weight.setText(user_settings.getWeigth());
        }catch (Exception e){
            e.printStackTrace();
        }

       btn_update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (
                       (
                          checkPassword(edt_password) &&
                          checkConfirmePassword(edt_confirme_password, edt_password) &&
                          isEmpty(edt_height) &&
                          isEmpty(edt_weight)
                       ) == true
               ){

                   String username = edt_username.getText().toString();
                   String password = edt_password.getText().toString();
                   String weight = edt_weight.getText().toString();
                   String height = edt_height.getText().toString();

                   dbHelper.updateUser(username,password,weight,height,Integer.parseInt(user.getId()));
                   Toast.makeText(getActivity(), "Profile updated successfully ;)", Toast.LENGTH_LONG).show();
                   //getFragmentManager().beginTransaction().replace(R.id.authentification_container,home_fragment).commit();

               }else {
                   Toast.makeText(getActivity(), "Error in updating profile ", Toast.LENGTH_LONG).show();
               }
           }
       });




        return v;
    }


    public boolean checkPassword(EditText editText) {
        boolean res = true;
        if (editText.getText().toString().trim().length() == 0) {
            editText.setError("This field is empty!!!");
            res = false;
        } else if (editText.getText().toString().length() < 6) {
            editText.setError("Password must contain at least seven characters !!!");
            res = false;
        }
        return res;
    }

    public boolean checkConfirmePassword(EditText editTextone, EditText editTexttow) {
        boolean res = true;
        if (!(editTextone.getText().toString().equals(editTexttow.getText().toString()))) {
            editTextone.setError("Password dosent much !!!");
            res = false;

        }
        return res;
    }

    public boolean isEmpty(EditText editText) {
        boolean res = true;
        if (editText.getText().length() == 0) {
            editText.setError("This field is empty!!!");
            res = false;
        }
        return res;
    }
}
