package com.water.reminder;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationlistener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationlistener =
            item -> {
                Fragment selectedFragment = null;
                switch(item.getItemId()){
                    case R.id.navigation_home:
                        selectedFragment =new HomeFragment();
                        break;
                    case R.id.navigation_stats:
                        selectedFragment =new StatsFragment();
                        break;
                    case R.id.navigation_settings:
                        selectedFragment =new SettingsFragment();
                        break;
                };
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            };
}