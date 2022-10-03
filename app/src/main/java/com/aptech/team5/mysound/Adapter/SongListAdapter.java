package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Song> arraysong;

    public SongListAdapter(Context context, ArrayList<Song> arraysong) {
        this.context = context;
        this.arraysong = arraysong;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.inline_song_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = arraysong.get(position);
        holder.txtnamesong.setText(song.getNameSong());
        holder.txtartist.setText(song.getArtist());
        Picasso.with(context).load(song.getImageSong()).into(holder.imgsong);
    }

    @Override
    public int getItemCount() {
        return arraysong.size();
    }

//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.inline_song_list,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Song song = arraysong.get(position);
//        holder.txtartist.setText(song.getArtist());
//        holder.txtnamesong.setText(song.getNameSong());
//        Picasso.with(context).load(song.getImageSong()).into(holder.imgsong);
////        holder.txtindex.setText(position + 1 + "");
//    }
//
//    @Override
//    public int getItemCount() {
//        return arraysong.size();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtnamesong,txtartist;
        public ImageView imgsong,imglike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnamesong = itemView.findViewById(R.id.textviewnamesong);
            txtartist = itemView.findViewById(R.id.textviewartist);
            imgsong = itemView.findViewById(R.id.imageviewsonglistindex);
            imglike = itemView.findViewById(R.id.imageviewlikessonglist);
        }
    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView txtindex,txtnamesong,txtartist;
//        ImageView imgsong,imglikes;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            imgsong = itemView.findViewById(R.id.imageviewsonglistindex);
//            txtartist = itemView.findViewById(R.id.textviewartist);
////            txtindex = itemView.findViewById(R.id.textviewsonglistindex);
//            txtnamesong= itemView.findViewById(R.id.textviewnamesong);
//            imglikes = itemView.findViewById(R.id.imageviewlikessonglist);
//        }
//    }
}