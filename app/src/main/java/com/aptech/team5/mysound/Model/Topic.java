package com.aptech.team5.mysound.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Topic {

@SerializedName("IdTopic")
@Expose
private String idTopic;
@SerializedName("NameTopic")
@Expose
private String nameTopic;
@SerializedName("ImageTopic")
@Expose
private String imageTopic;

public String getIdTopic() {
return idTopic;
}

public void setIdTopic(String idTopic) {
this.idTopic = idTopic;
}

public String getNameTopic() {
return nameTopic;
}

public void setNameTopic(String nameTopic) {
this.nameTopic = nameTopic;
}

public String getImageTopic() {
return imageTopic;
}

public void setImageTopic(String imageTopic) {
this.imageTopic = imageTopic;
}

}