package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>{
    Context context;
    ArrayList<Song> songArrayList;

    public SongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.txtname.setText(song.getNameSong());
        holder.txtartist.setText(song.getArtist());
        Picasso.with(context).load(song.getImageSong()).into(holder.imgsong);
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,txtartist;
        ImageView imgsong,imglikes;
        public ViewHolder(View itemView){
            super(itemView);
            txtname = itemView.findViewById(R.id.textviewsong);
            txtartist = itemView.findViewById(R.id.textviewartistsong);
            imgsong = itemView.findViewById(R.id.imageviewsong);
            imglikes = itemView.findViewById(R.id.imageviewlikes);
        }

    }
}
