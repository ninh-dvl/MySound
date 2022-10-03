package com.aptech.team5.mysound.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Category implements Serializable {

@SerializedName("IdCategory")
@Expose
private String idCategory;
@SerializedName("IdTopic")
@Expose
private String idTopic;
@SerializedName("NameCategory")
@Expose
private String nameCategory;
@SerializedName("ImageCategory")
@Expose
private String imageCategory;

public String getIdCategory() {
return idCategory;
}

public void setIdCategory(String idCategory) {
this.idCategory = idCategory;
}

public String getIdTopic() {
return idTopic;
}

public void setIdTopic(String idTopic) {
this.idTopic = idTopic;
}

public String getNameCategory() {
return nameCategory;
}

public void setNameCategory(String nameCategory) {
this.nameCategory = nameCategory;
}

public String getImageCategory() {
return imageCategory;
}

public void setImageCategory(String imageCategory) {
this.imageCategory = imageCategory;
}

}