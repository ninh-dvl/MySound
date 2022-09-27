package com.aptech.team5.mysound.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Advertisement implements Serializable {

    @SerializedName("IdAdvertisement")
    @Expose
    private String idAdvertisement;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Content")
    @Expose
    private String content;
    @SerializedName("IdSong")
    @Expose
    private String idSong;
    @SerializedName("NameSong")
    @Expose
    private String nameSong;
    @SerializedName("ImageSong")
    @Expose
    private String imageSong;

    public String getIdAdvertisement() {
        return idAdvertisement;
    }

    public void setIdAdvertisement(String idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIdSong() {
        return idSong;
    }

    public void setIdSong(String idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getImageSong() {
        return imageSong;
    }

    public void setImageSong(String imageSong) {
        this.imageSong = imageSong;
    }

}