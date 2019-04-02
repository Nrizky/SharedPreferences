package com.example.sharedpreferences.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;

import com.example.sharedpreferences.R;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie);
        bottomNavigationView = findViewById(R.id.BottomNavigation);
        loadFragment(new Fragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
        return false;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.movie_menu:
                fragment = new Fragment();
                break;

            case R.id.profile_menu:
                fragment = new Fragment();
                break;
        }
        return loadFragment(fragment);
    }
}
