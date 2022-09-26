package com.aptech.team5.mysound.Service;

import com.aptech.team5.mysound.Model.Advertisement;
import com.aptech.team5.mysound.Model.PlayList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("songbanner.php")
    Call<List<Advertisement>> GetDataBanner();
    @GET("playlist.php")
    Call<List<PlayList>> getPlayListCurrentDay();
}
