package com.water.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class AuthentificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        Fragment signinFragment= new SigninFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.authentification_container,signinFragment).commit();
    }
}