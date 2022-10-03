package com.aptech.team5.mysound.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aptech.team5.mysound.Adapter.ListcategorybytopicAdapter;
import com.aptech.team5.mysound.Model.Category;
import com.aptech.team5.mysound.Model.Topic;
import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCategoryByTopicActivity extends AppCompatActivity {
    Topic topic;
    RecyclerView recyclerViewCategorybyTopic;
    Toolbar toolbarcategorybytopic;
    ListcategorybytopicAdapter listcategorybytopicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category_by_topic);
        GetIntent();
        Init();
        GetData();
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Category>> callback = dataService.getCategorybyTopic(topic.getIdTopic());
        callback.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                ArrayList<Category> arrayCategory = (ArrayList<Category>) response.body();
                listcategorybytopicAdapter = new ListcategorybytopicAdapter(ListCategoryByTopicActivity.this,arrayCategory);
                recyclerViewCategorybyTopic.setLayoutManager(new GridLayoutManager(ListCategoryByTopicActivity.this,2));
                recyclerViewCategorybyTopic.setAdapter(listcategorybytopicAdapter);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        recyclerViewCategorybyTopic = findViewById(R.id.recyclerviewcategorybytopic);
        toolbarcategorybytopic = findViewById(R.id.toolbarcategorybytopic);
        setSupportActionBar(toolbarcategorybytopic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(topic.getNameTopic());
        toolbarcategorybytopic.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("topic")){
            topic= (Topic) intent.getSerializableExtra("topic");
        }
    }
}