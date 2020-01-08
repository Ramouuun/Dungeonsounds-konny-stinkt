package com.example.dungeonsounds;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends FragmentActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;
    private TabItem tab1, tab2, tab3;
    public PageAdapter pageAdapter;
    public boolean play = false;
    public boolean pause = true;
    public boolean stop = true;
    public boolean reset = true;
    private LoopMediaPlayer wind;
    private LoopMediaPlayer forest;
    AudioManager awind;
    SeekBar swind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lautstärke
        swind = (SeekBar) findViewById(R.id.swind);
        awind = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        swind.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar swind, int iwind, boolean bwind) {
                awind.setStreamVolume(awind.STREAM_MUSIC, iwind, 0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar swind) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar swind) {
            }
        });

        //Fragmente
        tablayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        tab1 = (TabItem) findViewById(R.id.Atmosphere);
        tab2 = (TabItem) findViewById(R.id.Music);
        tab3 = (TabItem) findViewById(R.id.Effects);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pageAdapter.notifyDataSetChanged();
                }
                   else if (tab.getPosition() == 1) {
                    pageAdapter.notifyDataSetChanged();
                }
                       else if (tab.getPosition() == 2) {
                            pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        //Button
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final ImageButton playButton = findViewById(R.id.playButton);
        final ImageButton pauseButton = findViewById(R.id.pauseButton);
        final ImageButton stopButton = findViewById(R.id.stopButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play == false) {
                    playButton.setBackgroundResource(R.drawable.roundbuttonrechts_clicked);
                    vibe.vibrate(35);
                    pauseButton.setBackgroundResource(R.drawable.roundbuttonmitte);
                    stopButton.setBackgroundResource(R.drawable.roundbuttonlinks);
                    playButton();
                    play = true;
                    pause = false;
                    stop = false;
                }
                else if (play == true);
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pause == false) {
                    playButton.setBackgroundResource(R.drawable.roundbuttonrechts);
                    pauseButton.setBackgroundResource(R.drawable.roundbuttonmitte_clicked);
                    vibe.vibrate(35);
                    stopButton.setBackgroundResource(R.drawable.roundbuttonlinks);
                    pauseButton();
                    pause = true;
                    stop = false;
                    play = false;
                }
                else if (pause == true);
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stop == false) {
                    playButton.setBackgroundResource(R.drawable.roundbuttonrechts);
                    pauseButton.setBackgroundResource(R.drawable.roundbuttonmitte);
                    stopButton.setBackgroundResource(R.drawable.roundbuttonlinks_clicked);
                    vibe.vibrate(35);
                    stopButton();
                    pause = true;
                    stop = true;
                    play = false;
                }
                else if (stop == true);
            }

        });
    }
    public void playButton() {
        if (reset == true) {
            wind = LoopMediaPlayer.create(this, R.raw.wind);
            reset = false;
        }
        wind.start();
    }
    public void pauseButton() {
        wind.pause();
        forest.pause();
    }
    public void stopButton() {
        wind.release();
        reset = true;
    }
}
