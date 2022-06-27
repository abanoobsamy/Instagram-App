package com.home.intagramapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.home.intagramapp.Fragment.HomeFragment;
import com.home.intagramapp.Fragment.NotificationFragment;
import com.home.intagramapp.Fragment.ProfileFragment;
import com.home.intagramapp.Fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView ;
    Fragment selectedFagrament = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView  = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemReselectedListener(navigationItemSelectedListner);

        Bundle intent = getIntent().getExtras();
        if(intent != null){

            String publisher = intent.getString("publisherid");

            SharedPreferences.Editor editor = getSharedPreferences("PREFS",MODE_PRIVATE).edit();
            editor.putString("profileid", publisher);
            editor.apply();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();

        }else {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();

        }





    }
    private  BottomNavigationView.OnNavigationItemReselectedListener navigationItemSelectedListner =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFagrament = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFagrament = new SearchFragment();
                            break;
                        case R.id.nav_add:
                            selectedFagrament = null;
                            startActivity(new Intent(MainActivity.this, PostActivity.class));
                            break;
                        case R.id.nav_heart:
                            selectedFagrament = new NotificationFragment();
                            break;
                        case R.id.nav_profile:
                            SharedPreferences.Editor editor = getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                            editor.putString("profileid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                            editor.apply();

                            selectedFagrament = new ProfileFragment();
                            break;
                    }



                    if (selectedFagrament != null) {

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFagrament).commit();

                    }
                     return ;
                }

            };
}
