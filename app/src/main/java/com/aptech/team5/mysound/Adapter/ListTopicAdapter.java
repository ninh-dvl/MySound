package com.aptech.team5.mysound.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aptech.team5.mysound.Activity.ListCategoryByTopicActivity;
import com.aptech.team5.mysound.Model.Topic;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListTopicAdapter extends  RecyclerView.Adapter<ListTopicAdapter.ViewHolder>{
    Context context;
    ArrayList<Topic> arrayTopic;

    public ListTopicAdapter(Context context, ArrayList<Topic> arrayTopic) {
        this.context = context;
        this.arrayTopic = arrayTopic;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_topic,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Topic topic = arrayTopic.get(position);
        Picasso.with(context).load(topic.getImageTopic()).into(holder.imgtopic);
    }

    @Override
    public int getItemCount() {
        return arrayTopic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgtopic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtopic = itemView.findViewById(R.id.imageviewinlinetopic);
            imgtopic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListCategoryByTopicActivity.class);
                    intent.putExtra("topic",arrayTopic.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
