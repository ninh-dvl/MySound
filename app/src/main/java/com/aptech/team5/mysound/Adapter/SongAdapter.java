package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Activity.PlaySongActivity;
import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaySongActivity.class);
                    intent.putExtra("song",songArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imglikes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imglikes.setImageResource(R.drawable.heartfull);
                    DataService dataService = APIService.getService();
                    Call<String> callback = dataService.updateLikes("1",songArrayList.get(getPosition()).getIdSong());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result = response.body();
                            if(result.equals("Success")){
                                Toast.makeText(context, "Liked", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();

                            }                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imglikes.setEnabled(false);
                }
            });

        }

    }
}
