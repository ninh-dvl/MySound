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
import com.aptech.team5.mysound.Model.Category;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListcategorybytopicAdapter extends RecyclerView.Adapter<ListcategorybytopicAdapter.ViewHolder>{

    Context context;
    ArrayList<Category> arrayCategory;

    public ListcategorybytopicAdapter(Context context, ArrayList<Category> arrayCategory) {
        this.context = context;
        this.arrayCategory = arrayCategory;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inline_category_topic,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = arrayCategory.get(position);
        Picasso.with(context).load(category.getImageCategory()).into(holder.imageView);
        holder.txtnamecategory.setText(category.getNameCategory());
    }

    @Override
    public int getItemCount() {
        return arrayCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtnamecategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageviewcategorytopic);
            txtnamecategory = itemView.findViewById(R.id.textviewnamecategorytopic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SongListActivity.class);
                    intent.putExtra("idcategory",arrayCategory.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
