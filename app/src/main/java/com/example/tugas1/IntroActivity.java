package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager welcomeSlideViewpager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position;
    Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make activity fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        //Hide the action bar

        getSupportActionBar().hide();

        //ini Views
        btnNext = findViewById(R.id.btnNext);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        tabIndicator = findViewById(R.id.tabIndicator);

        //fill list welcome
        final List<WelcomeItem> mListWelcome= new ArrayList<>();
        mListWelcome.add(new WelcomeItem("Welcome To DTS VSGA","What is going to happen tomorrow ?",R.drawable.ic_eventlist,R.drawable.bg_red));
        mListWelcome.add(new WelcomeItem("Work Happen","Get Notified When Work Happens",R.drawable.ic_superhero,R.drawable.bg_blue));
        mListWelcome.add(new WelcomeItem("Task and Assign","Task and Assign them to colleagues",R.drawable.ic_assign,R.drawable.bg_purple));

        //setup viewpager
        welcomeSlideViewpager = findViewById(R.id.welcomeViewPager);
        introViewPagerAdapter= new IntroViewPagerAdapter(this,mListWelcome);
        welcomeSlideViewpager.setAdapter(introViewPagerAdapter);

        //setup tablayout with viewpager
        tabIndicator.setupWithViewPager(welcomeSlideViewpager);

        //next btn click listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = welcomeSlideViewpager.getCurrentItem();
                if(position<mListWelcome.size()){
                    position++;
                    welcomeSlideViewpager.setCurrentItem(position);
                }if(position == mListWelcome.size()-1){
//                   //show the GETSTARTED Button and hide the indicator and the next button

                    loadLastScreen();
                }
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mListWelcome.size()-1){
                    //show the GETSTARTED Button and hide the indicator and the next button
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // show the GETSTARTED Button and hide the indicator and the next button
    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

    }
    public void clickGetStarted(View view) {
        Intent i = new Intent(IntroActivity.this, FragmentLayout.class);
        startActivity(i);
    }
    public void clickSkip(View view){
        Intent i = new Intent(IntroActivity.this, FragmentLayout.class);
        startActivity(i);
    }
}
