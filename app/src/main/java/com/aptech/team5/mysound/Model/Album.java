package com.aptech.team5.mysound.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Album implements Serializable {

@SerializedName("IdAlbum")
@Expose
private String idAlbum;
@SerializedName("NameAlbum")
@Expose
private String nameAlbum;
@SerializedName("NameArtistAlbum")
@Expose
private String nameArtistAlbum;
@SerializedName("ImageAlbum")
@Expose
private String imageAlbum;

public String getIdAlbum() {
return idAlbum;
}

public void setIdAlbum(String idAlbum) {
this.idAlbum = idAlbum;
}

public String getNameAlbum() {
return nameAlbum;
}

public void setNameAlbum(String nameAlbum) {
this.nameAlbum = nameAlbum;
}

public String getNameArtistAlbum() {
return nameArtistAlbum;
}

public void setNameArtistAlbum(String nameArtistAlbum) {
this.nameArtistAlbum = nameArtistAlbum;
}

public String getImageAlbum() {
return imageAlbum;
}

public void setImageAlbum(String imageAlbum) {
this.imageAlbum = imageAlbum;
}

}