package com.example.taskblackcoffer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.taskblackcoffer.fragments.adapters.VPadapter;
import com.example.taskblackcoffer.fragments.group;
import com.example.taskblackcoffer.fragments.place;
import com.example.taskblackcoffer.fragments.work;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout refineView;
    TabLayout tablaout;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refineView = findViewById(R.id.refine);
        tablaout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        tablaout.setupWithViewPager(viewpager);

        VPadapter vPadapter = new VPadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        vPadapter.addFragment(new group(),"\uD83D\uDC64");
        vPadapter.addFragment(new work(),"\uD83D\uDC5C");
        vPadapter.addFragment(new place(),"\uD83C\uDFEA");

        viewpager.setAdapter(vPadapter);

        refineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "HEhe..", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, refine.class);
                startActivity(i);
            }
        });

    }
}