package com.aptech.team5.mysound.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Song {

@SerializedName("IdSong")
@Expose
private String idSong;
@SerializedName("NameSong")
@Expose
private String nameSong;
@SerializedName("ImageSong")
@Expose
private String imageSong;
@SerializedName("Artist")
@Expose
private String artist;
@SerializedName("LinkSong")
@Expose
private String linkSong;
@SerializedName("Likes")
@Expose
private String likes;

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

public String getArtist() {
return artist;
}

public void setArtist(String artist) {
this.artist = artist;
}

public String getLinkSong() {
return linkSong;
}

public void setLinkSong(String linkSong) {
this.linkSong = linkSong;
}

public String getLikes() {
return likes;
}

public void setLikes(String likes) {
this.likes = likes;
}

}