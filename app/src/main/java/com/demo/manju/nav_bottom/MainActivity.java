package com.demo.manju.nav_bottom;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadF(new HomeFragment());
    }

    private boolean loadF(Fragment fragment){

        if (fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame,fragment)
                    .commit();

            return true;

        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null ;

        switch (item.getItemId()){

            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;


            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new NotificationFragment();
                break;

            case R.id.navigation_help:
                fragment = new HelpFragment();
                break;

        }
        return loadF(fragment);
    }
}
