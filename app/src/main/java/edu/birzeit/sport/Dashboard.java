package edu.birzeit.sport;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import edu.birzeit.sport.fragments.HomeFragment;
import edu.birzeit.sport.fragments.StaticsFragment;

public class Dashboard extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menue);
        bottomNavigationView = findViewById(R.id.menue_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home_nav);

        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home_nav:
                        fragment = new HomeFragment();
                        break;
                    case R.id.statics_nav:
                        fragment = new StaticsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();


            }
        });


    }
}
