package com.aptech.team5.mysound.Model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TopicCategory {

    @SerializedName("category")
    @Expose
    private List<Category> category = null;
    @SerializedName("topic")
    @Expose
    private List<Topic> topic = null;

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }
}
