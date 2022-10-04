package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;

import java.util.ArrayList;

public class PlaySongAdapter extends RecyclerView.Adapter<PlaySongAdapter.ViewHolder>{
    Context context;
    ArrayList<Song> arraySong;

    public PlaySongAdapter(Context context, ArrayList<Song> arraySong) {
        this.context = context;
        this.arraySong = arraySong;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_play_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = arraySong.get(position);
        holder.txtartist.setText(song.getArtist());
        holder.txtindex.setText(position + 1 +"");
        holder.txtnamesong.setText(song.getNameSong());
    }

    @Override
    public int getItemCount() {
        return arraySong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtindex,txtnamesong,txtartist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtartist= itemView.findViewById(R.id.textviewplaysongartist);
            txtindex= itemView.findViewById(R.id.textviewplaysongindex);
            txtnamesong = itemView.findViewById(R.id.textviewplaynamesong);
        }
    }
}
