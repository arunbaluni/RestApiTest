package pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote{
    private ArrayList<String> tags;
    private boolean favorite;
    private String author_permalink;
    private String body;
    private int id;
    private int favorites_count;
    private int upvotes_count;
    private int downvotes_count;
    private boolean dialogue;
    private String author;
    private String url;
    
    Quote() {}
    
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setAuthorPermalink(String author_permalink) {
        this.author_permalink = author_permalink;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFavoritesCount(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public void setUpvotesCount(int upvotes_count) {
        this.upvotes_count = upvotes_count;
    }

    public void setDownvotesCount(int downvotes_count) {
        this.downvotes_count = downvotes_count;
    }

    public void setDialogue(boolean dialogue) {
        this.dialogue = dialogue;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public String getAuthorPermalink() {
        return author_permalink;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public int getFavoritesCount() {
        return favorites_count;
    }

    public int getUpvotesCount() {
        return upvotes_count;
    }

    public int getDownvotesCount() {
        return downvotes_count;
    }

    public boolean getDialogue() {
        return dialogue;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }
}