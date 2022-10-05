package com.aptech.team5.mysound.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.aptech.team5.mysound.Adapter.ListTopicAdapter;
import com.aptech.team5.mysound.Model.Topic;
import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTopicActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllTopic;
    Toolbar toolbarAllTopic;
    ListTopicAdapter listTopicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_topic);
        Init();
        GetData();
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Topic>> callback = dataService.getAllTopic();
        callback.enqueue(new Callback<List<Topic>>() {
            @Override
            public void onResponse(Call<List<Topic>> call, Response<List<Topic>> response) {
                ArrayList<Topic> arrayTopic = (ArrayList<Topic>) response.body();
                listTopicAdapter = new ListTopicAdapter(ListTopicActivity.this,arrayTopic);
                recyclerViewAllTopic.setLayoutManager(new GridLayoutManager(ListTopicActivity.this,1));
                recyclerViewAllTopic.setAdapter(listTopicAdapter);
            }

            @Override
            public void onFailure(Call<List<Topic>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        recyclerViewAllTopic = findViewById(R.id.recyclerviewalltopic);
        toolbarAllTopic = findViewById(R.id.toolbaralltopic);
        setSupportActionBar(toolbarAllTopic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Topic");
        toolbarAllTopic.setTitleTextColor(Color.WHITE);
        toolbarAllTopic.setCollapseIcon(R.drawable.iconback);
        toolbarAllTopic.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}