package com.aptech.team5.mysound.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.aptech.team5.mysound.Adapter.MainViewPagerAdapter;
import com.aptech.team5.mysound.Fragment.Fragment_Homepage;
import com.aptech.team5.mysound.Fragment.Fragment_Search;
import com.aptech.team5.mysound.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    //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
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        init();
    }

    private void init(){
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Homepage(),"Home");
        mainViewPagerAdapter.addFragment(new Fragment_Search(),"Search");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.search);
    }

    private void mapping() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}