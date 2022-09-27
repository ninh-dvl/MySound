package com.aptech.team5.mysound.Service;

import com.aptech.team5.mysound.Model.Advertisement;
import com.aptech.team5.mysound.Model.Album;
import com.aptech.team5.mysound.Model.PlayList;
import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.Model.TopicCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("songbanner.php")
    Call<List<Advertisement>> GetDataBanner();
    @GET("playlist.php")
    Call<List<PlayList>> getPlayListCurrentDay();
    @GET("topicandcategory.php")
    Call<TopicCategory> getTopicCategoryMusic();
    @GET("album.php")
    Call<List<Album>> getAlbum();
    @GET("likes.php")
    Call<List<Song>> getSong();

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<Song>> GetSearchBaihat(@Field("tukhoa") String tukhoa);
}
