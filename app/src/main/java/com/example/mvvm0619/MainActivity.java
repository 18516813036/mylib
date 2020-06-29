package com.example.mvvm0619;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.account.AccountFragment;
import com.example.finalce.FinalceFragment;
import com.example.home.HomeFragment;
import com.example.more.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager actMainVp;
    private BottomNavigationView actMainBottombar;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actMainBottombar = (BottomNavigationView) findViewById(R.id.act_main_bottombar);
        actMainVp = (ViewPager) findViewById(R.id.act_main_vp);

        initData();
        initEvent();
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FinalceFragment());
        fragments.add(new AccountFragment());
        fragments.add(new MoreFragment());

        FragmentPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), fragments);
        actMainVp.setAdapter(adapter);
    }

    private void initEvent() {
        actMainBottombar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.menu_home:
                        Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                        actMainVp.setCurrentItem(0);
                        return true;
                    case R.id.menu_finalce:
                        Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                        actMainVp.setCurrentItem(1);
                        return true;
                    case R.id.menu_account:
                        Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                        actMainVp.setCurrentItem(2);
                        return true;
                    case R.id.menu_more:
                        Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                        actMainVp.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });

        actMainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actMainBottombar.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
