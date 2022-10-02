package com.aptech.team5.mysound.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class PlayList implements Serializable {

@SerializedName("IdPlayList")
@Expose
private String idPlayList;
@SerializedName("Name")
@Expose
private String name;
@SerializedName("Background")
@Expose
private String background;
@SerializedName("ImageIcon")
@Expose
private String imageIcon;

public String getIdPlayList() {
return idPlayList;
}

public void setIdPlayList(String idPlayList) {
this.idPlayList = idPlayList;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getBackground() {
return background;
}

public void setBackground(String background) {
this.background = background;
}

public String getImageIcon() {
return imageIcon;
}

public void setImageIcon(String imageIcon) {
this.imageIcon = imageIcon;
}

}