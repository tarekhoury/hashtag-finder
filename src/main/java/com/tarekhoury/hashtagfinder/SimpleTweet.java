package com.tarekhoury.hashtagfinder;

import java.util.Date;

public class SimpleTweet {

    private String owner;
    private String text;
    private Date createdDate;
    private int favoriteCount;
    private int retweetCount;

    SimpleTweet(String owner, String text, Date createdDate, int favoriteCount, int retweetCount) {
        this.owner = owner;
        this.text = text;
        this.createdDate = createdDate;
        this.favoriteCount = favoriteCount;
        this.retweetCount = retweetCount;
    }

    public String getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }
}
