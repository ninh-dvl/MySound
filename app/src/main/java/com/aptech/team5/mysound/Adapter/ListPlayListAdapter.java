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
import com.aptech.team5.mysound.Model.PlayList;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListPlayListAdapter extends RecyclerView.Adapter<ListPlayListAdapter.ViewHolder>{
    Context context;
    ArrayList<PlayList> arrayplaylist;

    public ListPlayListAdapter(Context context, ArrayList<PlayList> arrayplaylist) {
        this.context = context;
        this.arrayplaylist = arrayplaylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_list_play_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayList playList = arrayplaylist.get(position);
        Picasso.with(context).load(playList.getBackground()).into(holder.imgbackground);
        holder.txtnameplaylist.setText(playList.getName());
    }

    @Override
    public int getItemCount() {
        return arrayplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgbackground;
        TextView txtnameplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgbackground = itemView.findViewById(R.id.imageviewlistplaylist);
            txtnameplaylist = itemView.findViewById(R.id.textviewnamelistplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SongListActivity.class);
                    intent.putExtra("itemplaylist",arrayplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
