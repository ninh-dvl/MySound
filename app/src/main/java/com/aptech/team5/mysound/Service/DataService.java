package com.aptech.team5.mysound.Service;

import com.aptech.team5.mysound.Model.Advertisement;
import com.aptech.team5.mysound.Model.Album;
import com.aptech.team5.mysound.Model.Category;
import com.aptech.team5.mysound.Model.PlayList;
import com.aptech.team5.mysound.Model.Song;
import com.aptech.team5.mysound.Model.Topic;
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
    @POST("songlist.php")
    Call<List<Song>> getSongListAdvertisement(@Field("IdAdvertisement") String IdAdvertisement);

    @FormUrlEncoded
    @POST("songlist.php")
    Call<List<Song>> getSongListPLayList(@Field("IdPlayList") String IdPlayList);

    @GET("listplaylist.php")
    Call<List<PlayList>> getListPlayList();

    @FormUrlEncoded
    @POST("songlist.php")
    Call<List<Song>> getSongListCategory(@Field("IdCategory") String IdCategory);

    @GET("alltopic.php")
    Call<List<Topic>> getAllTopic();

    @FormUrlEncoded
    @POST("categorybytopic.php")
    Call<List<Category>> getCategorybyTopic(@Field("IdTopic") String IdTopic);

    @GET("allalbum.php")
    Call<List<Album>> getallAlbum();

    @FormUrlEncoded
    @POST("songlist.php")
    Call<List<Song>> getSongListAlbum(@Field("IdAlbum") String IdAlbum);

    @FormUrlEncoded
    @POST("updatelikes.php")
    Call<String> updateLikes(@Field("Likes") String Likes,@Field("IdSong") String IdSong);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<Song>> GetSearchBaihat(@Field("tukhoa") String tukhoa);
}
