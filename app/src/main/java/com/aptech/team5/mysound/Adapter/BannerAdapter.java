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
import androidx.viewpager.widget.PagerAdapter;

import com.aptech.team5.mysound.Activity.SongListActivity;
import com.aptech.team5.mysound.Model.Advertisement;
import com.aptech.team5.mysound.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Advertisement> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<Advertisement> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_banner,null);
        ImageView imgbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitlesongbanner =view.findViewById(R.id.textviewtilebannersong);
        TextView txtcontent = view.findViewById(R.id.textviewcontent);

        Picasso.with(context).load(arrayListBanner.get(position).getImage()).into(imgbackgroundbanner);
        Picasso.with(context).load(arrayListBanner.get(position).getImageSong()).into(imgsongbanner);
        txttitlesongbanner.setText(arrayListBanner.get(position).getNameSong());
        txtcontent.setText(arrayListBanner.get(position).getContent());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SongListActivity.class);
                intent.putExtra("banner",arrayListBanner.get(position));
                context.startActivity(intent);
        //        Toast.makeText(context, "asdasdadasda", Toast.LENGTH_SHORT).show();

            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
