package com.example.bookreviewapp.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "books")
public class Book implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String author;
    private String description;
    private float rating;
    private String thumbnail;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public String getThumbnail() { return thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
}