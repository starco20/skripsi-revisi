package com.example.skripsi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    private FloatingActionButton fa_btn,btn_logout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3;;
    public PageAdapter pagerAdapter;
    TextView tpH;
    String ap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        tpH = findViewById(R.id.tpView);
//        ap = getIntent().getExtras().getString("Vtp");
//        tpH.setText(ap);

        tabLayout =(TabLayout)findViewById(R.id.tablayout);
        tab1 = (TabItem)findViewById(R.id.Tab1);
        tab2 = (TabItem)findViewById(R.id.Tab2);
        tab3 = (TabItem)findViewById(R.id.Tab3);
        viewPager = findViewById(R.id.viewpager);
        fa_btn = findViewById(R.id.fa_btn);
        btn_logout = findViewById(R.id.out_btn);

        fa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Notification.class));
//                Intent i = new Intent(Home.this, Notification.class);
//                i.putExtra("Vtp", ap);
//                startActivity(i);
//                finish();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0) {
                    pagerAdapter.notifyDataSetChanged();
                }else if(tab.getPosition()==1) {
                    pagerAdapter.notifyDataSetChanged();
                }else if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
    private void configurationJoin(){
        Button Btn_Join = (Button) findViewById(R.id.Btn_Join);
        Btn_Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, JoinUs.class));
            }
        });
    }
}

