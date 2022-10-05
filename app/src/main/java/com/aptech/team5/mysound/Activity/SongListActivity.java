package com.aptech.team5.mysound.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aptech.team5.mysound.Adapter.SongListAdapter;
import com.aptech.team5.mysound.Model.Advertisement;
import com.aptech.team5.mysound.Model.Album;
import com.aptech.team5.mysound.Model.Category;
import com.aptech.team5.mysound.Model.PlayList;
import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongListActivity extends AppCompatActivity {
    Advertisement advertisement;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewsonglist;
    FloatingActionButton floatingActionButton;
    ImageView imgsonglist;
    ArrayList<Song> arraySong;
    SongListAdapter songListAdapter;
    PlayList playList;
    Category category;
    Album album;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        DataIntent();
        Mapping();
        Init();

        if(advertisement != null && !advertisement.getNameSong().equals("")){
            setValueInView(advertisement.getNameSong(),advertisement.getImageSong());
            GetDataAdvertisement(advertisement.getIdAdvertisement());
        }

      if(playList != null && !playList.getName().equals("")){
          setValueInView(playList.getName(),playList.getBackground());
          GetDataPLayList(playList.getIdPlayList());
      }

        if(category != null && !category.getNameCategory().equals("")){
            setValueInView(category.getNameCategory(),category.getImageCategory());
            GetDataCategory(category.getIdCategory());
        }
        if(album != null && !album.getNameAlbum().equals("")){
            setValueInView(album.getNameAlbum(),album.getImageAlbum());
            GetDataAlbum(album.getIdAlbum());
        }
    }

    private void GetDataAlbum(String idAlbum) {
        DataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getSongListAlbum(idAlbum);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                arraySong = (ArrayList<Song>) response.body();
                songListAdapter = new SongListAdapter(SongListActivity.this,arraySong);
                recyclerViewsonglist.setLayoutManager(new LinearLayoutManager(SongListActivity.this));
                recyclerViewsonglist.setAdapter(songListAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void GetDataCategory(String IdCategory) {
        DataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getSongListCategory(IdCategory);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                arraySong = (ArrayList<Song>) response.body();
                songListAdapter = new SongListAdapter(SongListActivity.this,arraySong);
                recyclerViewsonglist.setLayoutManager(new LinearLayoutManager(SongListActivity.this));
                recyclerViewsonglist.setAdapter(songListAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }


    private void GetDataPLayList(String IdPlayList) {
        DataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getSongListPLayList(IdPlayList);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                arraySong = (ArrayList<Song>) response.body();
                songListAdapter = new SongListAdapter(SongListActivity.this,arraySong);
                recyclerViewsonglist.setLayoutManager(new LinearLayoutManager(SongListActivity.this));
                recyclerViewsonglist.setAdapter(songListAdapter);
                eventClick();
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String name , String image) {
        collapsingToolbarLayout.setTitle(name);
        try {
            URL url = new URL(image);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
           if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
               collapsingToolbarLayout.setBackground(bitmapDrawable);
           }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(image).into(imgsonglist);
    }
    private void GetDataAdvertisement(String idadvertisement) {
        DataService dataService = APIService.getService();
        Call<List<Song>> callback = dataService.getSongListAdvertisement(idadvertisement);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                arraySong = (ArrayList<Song>) response.body();
                songListAdapter = new SongListAdapter(SongListActivity.this,arraySong);
                recyclerViewsonglist.setLayoutManager(new LinearLayoutManager(SongListActivity.this));
                recyclerViewsonglist.setAdapter(songListAdapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setCollapseIcon(R.drawable.iconback);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        floatingActionButton.setEnabled(false);
    }

    private void Mapping() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar =  findViewById(R.id.toolbarsonglist);
        recyclerViewsonglist = findViewById(R.id.recyclerviewsonglist);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        imgsonglist = findViewById(R.id.imageviewsonglist);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                advertisement = (Advertisement) intent.getSerializableExtra("banner");
              //  Toast.makeText(this, advertisement.getNameSong(), Toast.LENGTH_SHORT).show();
            }

            if(intent.hasExtra("itemplaylist")) {
                playList = (PlayList) intent.getSerializableExtra("itemplaylist");
            }

            if(intent.hasExtra("idcategory")) {
                category = (Category) intent.getSerializableExtra("idcategory");
            }

            if(intent.hasExtra("album")) {
                album = (Album) intent.getSerializableExtra("album");
            }
        }
    }

    private void eventClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongListActivity.this,PlaySongActivity.class);
                intent.putExtra("listsong",arraySong);
                startActivity(intent);
            }
        });
    }
}