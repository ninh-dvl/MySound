package com.aptech.team5.mysound.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Activity.PlaySongActivity;
import com.aptech.team5.mysound.Adapter.PlaySongAdapter;
import com.aptech.team5.mysound.R;

public class Fragment_Play_Song_List extends Fragment {
    View view;
    RecyclerView recyclerViewplaysong;
    PlaySongAdapter playSongAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_song_list,container,false);
        recyclerViewplaysong = view.findViewById(R.id.recyclerviewPLaysong);
        if(PlaySongActivity.arraySong.size() > 0){
            playSongAdapter = new PlaySongAdapter(getActivity(), PlaySongActivity.arraySong);
            recyclerViewplaysong.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaysong.setAdapter(playSongAdapter);
        }

        return view;
    }
}
