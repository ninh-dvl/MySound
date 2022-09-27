package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Model.Album;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    Context context;
    ArrayList<Album> arrayAlbum;

    public AlbumAdapter(Context context, ArrayList<Album> arrayAlbum) {
        this.context = context;
        this.arrayAlbum = arrayAlbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = arrayAlbum.get(position);
        holder.txtartistalbum.setText(album.getNameArtistAlbum());
        holder.txtnamealbum.setText(album.getNameAlbum());
        Picasso.with(context).load(album.getImageAlbum()).into(holder.imgImageAlbum);
    }

    @Override
    public int getItemCount() {
        return arrayAlbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImageAlbum;
        TextView txtnamealbum,txtartistalbum;
        public ViewHolder(View itemView){
            super(itemView);
            imgImageAlbum = itemView.findViewById(R.id.imageviewalbum);
            txtnamealbum = itemView.findViewById(R.id.textviewnamealbum);
            txtartistalbum = itemView.findViewById(R.id.textviewnameartistalbum);
        }
    }

}
