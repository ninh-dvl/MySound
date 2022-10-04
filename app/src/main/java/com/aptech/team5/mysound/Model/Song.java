package com.aptech.team5.mysound.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Song implements Parcelable {

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

    protected Song(Parcel in) {
        idSong = in.readString();
        nameSong = in.readString();
        imageSong = in.readString();
        artist = in.readString();
        linkSong = in.readString();
        likes = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idSong);
        parcel.writeString(nameSong);
        parcel.writeString(imageSong);
        parcel.writeString(artist);
        parcel.writeString(linkSong);
        parcel.writeString(likes);
    }
}