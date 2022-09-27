package com.aptech.team5.mysound.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.aptech.team5.mysound.Model.Advertisement;
import com.aptech.team5.mysound.R;

public class SongListActivity extends AppCompatActivity {
    Advertisement advertisement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        DataIntent();
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null) {
            if(intent.hasExtra("banner")){
                advertisement = (Advertisement) intent.getSerializableExtra("banner");
            }
        }
    }
}