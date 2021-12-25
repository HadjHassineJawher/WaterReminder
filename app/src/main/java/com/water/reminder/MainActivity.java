package com.water.reminder;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.water.reminder.SQLITE.User;
import com.water.reminder.SharedPrefernces.UserSessionManager;

public class MainActivity extends AppCompatActivity {
     UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation_menu);

        final DrawerLayout dr = findViewById(R.id.drawerlayout);
        NavigationView nv = findViewById(R.id.sideBar);
        nv.setNavigationItemSelectedListener(sidnavListener);

        Fragment home_fragment= new HomeFragment();
        bottomNavigation.setOnNavigationItemSelectedListener(navigationlistener);

        session = new UserSessionManager(getApplicationContext());
        User user = session.getUserDetails();

        View header = nv.getHeaderView(0);

        TextView txtv_header_username = (TextView) header.findViewById(R.id.txt_header_username);
        TextView txtv_header_email = (TextView) header.findViewById(R.id.txtv_header_email);

        txtv_header_username.setText(user.getUsername());
        txtv_header_email.setText(user.getEmail());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,home_fragment).commit();
        if(session.checkLogin()){
            finish();
        }

        findViewById(R.id.Menu_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr.openDrawer(GravityCompat.START);
            }
        });


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

            public NavigationView.OnNavigationItemSelectedListener sidnavListener= new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    DrawerLayout dr = findViewById(R.id.drawerlayout);
                    switch (item.getItemId()) {
                        case R.id.itm_profile:
                            selectedFragment = new ProfileFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                            dr.closeDrawers();
                            break;
                        case R.id.itm_logout:
                           session.logoutUser();

                            break;


                };
                    return false;
            };
        };
}