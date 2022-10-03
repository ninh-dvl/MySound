package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Activity.SongListActivity;
import com.aptech.team5.mysound.Model.Album;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllAlbumAdapter extends RecyclerView.Adapter<AllAlbumAdapter.ViewHolder>{
    Context context;
    ArrayList<Album> albumArrayList;

    public AllAlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_all_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);
        Picasso.with(context).load(album.getImageAlbum()).into(holder.imgallalbum);
        holder.txtnameallalbum.setText(album.getNameAlbum());
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgallalbum;
        TextView txtnameallalbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgallalbum = itemView.findViewById(R.id.imageviewallalbum);
            txtnameallalbum = itemView.findViewById(R.id.textviewallalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SongListActivity.class);
                    intent.putExtra("album",albumArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
