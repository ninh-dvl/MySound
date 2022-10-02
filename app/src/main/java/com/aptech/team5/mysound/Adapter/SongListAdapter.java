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

import java.util.ArrayList;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> arraysong;

    public SongListAdapter(Context context, ArrayList<Song> arraysong) {
        this.context = context;
        this.arraysong = arraysong;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_song_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = arraysong.get(position);
        holder.txtartist.setText(song.getArtist());
        holder.txtnamesong.setText(song.getNameSong());
        holder.txtindex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return arraysong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtindex,txtnamesong,txtartist;
        ImageView imglikes;
        public ViewHolder(View itemView) {
            super(itemView);
            txtartist = itemView.findViewById(R.id.textviewartist);
            txtindex = itemView.findViewById(R.id.textviewsonglistindex);
            txtnamesong= itemView.findViewById(R.id.textviewnamesong);
            imglikes = itemView.findViewById(R.id.imageviewlikessonglist);
        }
    }
}