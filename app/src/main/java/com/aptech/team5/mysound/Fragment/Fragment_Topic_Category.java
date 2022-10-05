package com.aptech.team5.mysound.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.aptech.team5.mysound.Activity.ListCategoryByTopicActivity;
import com.aptech.team5.mysound.Activity.ListTopicActivity;
import com.aptech.team5.mysound.Activity.SongListActivity;
import com.aptech.team5.mysound.Model.Category;
import com.aptech.team5.mysound.Model.Topic;
import com.aptech.team5.mysound.Model.TopicCategory;
import com.aptech.team5.mysound.R;
import com.aptech.team5.mysound.Service.APIService;
import com.aptech.team5.mysound.Service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Topic_Category extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtseemoretopiccategory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_topic_category,container,false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollview);
        txtseemoretopiccategory = view.findViewById(R.id.textviewseemore);
        txtseemoretopiccategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListTopicActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<TopicCategory> callback = dataService.getTopicCategoryMusic();
        callback.enqueue(new Callback<TopicCategory>() {
            @Override
            public void onResponse(Call<TopicCategory> call, Response<TopicCategory> response) {
                TopicCategory topicCategory = response.body();
                final ArrayList<Category> categoryArrayList = new ArrayList<>();
                categoryArrayList.addAll(topicCategory.getCategory());
                final ArrayList<Topic> topicArrayList = new ArrayList<>();
                topicArrayList.addAll(topicCategory.getTopic());
//                Log.d("test", String.valueOf(topicArrayList.addAll(topicCategory.getTopic())));
                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(780,350);
                layout.setMargins(10,20,10,30);
                for (int i = 0; i < (topicArrayList.size()); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(topicArrayList.get(i).getImageTopic() != null) {
                        Picasso.with(getActivity()).load(topicArrayList.get(i).getImageTopic()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                    int finalI = i;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), ListCategoryByTopicActivity.class);
                            intent.putExtra("topic",topicArrayList.get(finalI));
                            startActivity(intent);
                        }
                    });
                }
                for (int j = 0; j < (topicArrayList.size()); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if(categoryArrayList.get(j).getImageCategory() != null) {
                        Picasso.with(getActivity()).load(categoryArrayList.get(j).getImageCategory()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);

                    int finalJ = j;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), SongListActivity.class);
                            intent.putExtra("idcategory",categoryArrayList.get(finalJ));
                            startActivity(intent);
                        }
                    });
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<TopicCategory> call, Throwable t) {

            }
        });
    }
}
