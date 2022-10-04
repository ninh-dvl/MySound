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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            imglikes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imglikes.setImageResource(R.drawable.heartfull);
                    DataService dataService = APIService.getService();
                    Call<String> callback = dataService.updateLikes("1",arraysong.get(getPosition()).getIdSong());
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaySongActivity.class);
                    intent.putExtra("song",arraysong.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
