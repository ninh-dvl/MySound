package com.aptech.team5.mysound.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aptech.team5.mysound.Adapter.ViewPagerPlaylistsong;
import com.aptech.team5.mysound.Fragment.Fragment_Disc;
import com.aptech.team5.mysound.Fragment.Fragment_Play_Song_List;
import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlaySongActivity extends AppCompatActivity {
    Toolbar toolbarplaysong;
    TextView txtTimesong,txtTotaltimesong;
    SeekBar seektime;
    ImageButton imgplay,imgrepeat,imgnext,imgpre,imgrandom;
    ViewPager viewPagerplaysong;
    Fragment_Disc fragment_disc;
    Fragment_Play_Song_List fragment_play_song_list;
    public static ArrayList<Song> arraySong = new ArrayList<>();
    public static ViewPagerPlaylistsong adaptersong;
    MediaPlayer mediaPlayer;
    int position = 0;
    boolean repeat = false;
    boolean checkrandom = false;
    boolean next = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        GetDataFromIntent();
        Init();
        eventClick();
    }

    private void eventClick() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(adaptersong.getItem(1) != null) {
                    if(arraySong.size() > 0) {
                        fragment_disc.PlaySong(arraySong.get(0).getImageSong());
                        handler.removeCallbacks(this);
                    }else  {
                        handler.postDelayed(this,300);
                    }
                }
            }
        },500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    imgplay.setImageResource(R.drawable.play);
                }else {
                    mediaPlayer.start();
                    imgplay.setImageResource(R.drawable.pause);
                }
            }
        });
        imgrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeat == false){
                    if(checkrandom == true) {
                        checkrandom = false;
                        imgrepeat.setImageResource(R.drawable.repeatfull);
                        imgrandom.setImageResource(R.drawable.suffle);
                    }
                    imgrepeat.setImageResource(R.drawable.repeatfull);
                    repeat=true;
                }else {
                    imgrepeat.setImageResource(R.drawable.repeat);
                    repeat= false;
                }
            }
        });

        imgrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkrandom == false){
                    if(repeat == true) {
                        repeat = false;
                        imgrandom.setImageResource(R.drawable.shuffle);
                        imgrepeat.setImageResource(R.drawable.repeat);
                    }
                    imgrandom.setImageResource(R.drawable.shuffle);
                    checkrandom=true;
                }else {
                    imgrandom.setImageResource(R.drawable.suffle);
                    checkrandom= false;
                }
            }
        });

        seektime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arraySong.size() >0){
                    if(mediaPlayer.isPlaying() || mediaPlayer !=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < (arraySong.size())){
                        imgplay.setImageResource(R.drawable.pause);
                        position++;
                        if (repeat == true){
                            if (position == 0){
                                position = arraySong.size();
                            }
                            position -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(arraySong.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }
                        if (position > (arraySong.size() -1)){
                            position = 0;
                        }
                        new PlayMp3().execute(arraySong.get(position).getLinkSong());
                        fragment_disc.PlaySong(arraySong.get(position).getImageSong());
                        getSupportActionBar().setTitle(arraySong.get(position).getNameSong());
                        UpdateTime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },3000);
            }
        });

        imgpre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arraySong.size() >0){
                    if(mediaPlayer.isPlaying() || mediaPlayer !=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < (arraySong.size())){
                        imgplay.setImageResource(R.drawable.pause);
                        position--;
                        if (position < 0) {
                            position = arraySong.size() -1;
                        }
                        if (repeat == true){
                            position += 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(arraySong.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }

                        new PlayMp3().execute(arraySong.get(position).getLinkSong());
                        fragment_disc.PlaySong(arraySong.get(position).getImageSong());
                        getSupportActionBar().setTitle(arraySong.get(position).getNameSong());
                        UpdateTime();
                    }
                }
                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },3000);
            }
        });
    }

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        arraySong.clear();
        if(intent != null){
            if(intent.hasExtra("song")){
                Song song = intent.getParcelableExtra("song");
                arraySong.add(song);
            }

            if (intent.hasExtra("listsong")) {
                ArrayList<Song> songArrayList = intent.getParcelableArrayListExtra("listsong");
                arraySong = songArrayList;
            }
        }

    }

    private void Init() {
        toolbarplaysong = findViewById(R.id.toolbarplaysong);
        txtTimesong = findViewById(R.id.textviewtimesong);
        txtTotaltimesong = findViewById(R.id.textviewtotaltimesong);
        seektime = findViewById(R.id.seekbarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonrepeat);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
        imgpre = findViewById(R.id.imagebuttonpre);
        viewPagerplaysong = findViewById(R.id.viewpagerplaysong);
        setSupportActionBar(toolbarplaysong);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaysong.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                mediaPlayer.stop();
                arraySong.clear();
            }
        });
        toolbarplaysong.setTitleTextColor(Color.WHITE);
        fragment_disc = new Fragment_Disc();
        fragment_play_song_list = new Fragment_Play_Song_List();
        adaptersong = new ViewPagerPlaylistsong(getSupportFragmentManager());
        adaptersong.AddFragment(fragment_play_song_list);
        adaptersong.AddFragment(fragment_disc);
        viewPagerplaysong.setAdapter(adaptersong);
        fragment_disc = (Fragment_Disc) adaptersong.getItem(1);
        if(arraySong.size() > 0){
            getSupportActionBar().setTitle(arraySong.get(0).getNameSong());
            new PlayMp3().execute(arraySong.get(0).getLinkSong());
            imgplay.setImageResource(R.drawable.pause);
        }
    }

    class PlayMp3 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String song) {
            super.onPostExecute(song);
            try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.reset();
                }
            });
            mediaPlayer.setDataSource(song);
            mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
            UpdateTime();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotaltimesong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seektime.setMax(mediaPlayer.getDuration());
    }

    private  void  UpdateTime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seektime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimesong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this,300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            next = true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        },300);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (next == true){
                    if (position < (arraySong.size())){
                        imgplay.setImageResource(R.drawable.pause);
                        position++;
                        if (repeat == true){
                            if (position == 0){
                                position = arraySong.size();
                            }
                            position -= 1;
                        }
                        if (checkrandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(arraySong.size());
                            if (index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }
                        if (position > (arraySong.size() -1)){
                            position = 0;
                        }
                        new PlayMp3().execute(arraySong.get(position).getLinkSong());
                        fragment_disc.PlaySong(arraySong.get(position).getImageSong());
                        getSupportActionBar().setTitle(arraySong.get(position).getNameSong());
                    }

                imgpre.setClickable(false);
                imgnext.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgpre.setClickable(true);
                        imgnext.setClickable(true);
                    }
                },3000);
                next = false;
                handler1.removeCallbacks(this);
                }else {
                    handler1.postDelayed(this,1000);
                }
            }
        },1000);
    }
}