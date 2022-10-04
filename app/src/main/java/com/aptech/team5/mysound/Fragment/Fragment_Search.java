package com.aptech.team5.mysound.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Adapter.SearchSongAdapter;
import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Search extends Fragment {
    View view;
    Toolbar toolbar;
    RecyclerView recyclerViewsearchbaihat;
    TextView txtkhongcodulieu;
    SearchSongAdapter searchSongAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search,container,false);
        toolbar = view.findViewById(R.id.toolbarsearchbaihat);
        recyclerViewsearchbaihat = view.findViewById(R.id.recyclerViewsearchbaihat);
        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.search_view,menu);
        MenuItem menuitem = menu.findItem(R.id.menu_search);
        SearchView searchview = (SearchView) menuitem.getActionView();

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                SearchTuKhoaBaiHat(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }
    private void SearchTuKhoaBaiHat(String query){
        DataService dataservice = APIService.getService();
        Call<List<Song>> callback = dataservice.GetSearchBaihat(query);
        ((Call<List<Song>>) callback).enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> arraysong = (ArrayList<Song>) response.body();
                if(arraysong.size() > 0){
                    searchSongAdapter = new SearchSongAdapter(getActivity(),arraysong);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchbaihat.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchbaihat.setAdapter(searchSongAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchbaihat.setVisibility(View.VISIBLE);
                }else{
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}