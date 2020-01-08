package com.android.example.mobileassignment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "event_table")
public class Event {
    @ColumnInfo(name = "event_id")
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "event_name")
    private String name;

    @ColumnInfo(name = "event_category")
    private String category;

    @ColumnInfo(name = "event_description")
    private String description;

    @ColumnInfo(name = "event_location")
    private String location;

    @ColumnInfo(name = "event_rating")
    private int rating;

    @ColumnInfo(name = "event_startTime")
    private String startOperationTime;

    @ColumnInfo(name = "event_endTime")
    private String endOperationTime;

    @ColumnInfo(name = "event_latitude")
    private String latitude;

    @ColumnInfo(name = "event_longitude")
    private String longitude;


    public Event(int id, String name, String category, String description, String location, int rating, String startOperationTime, String endOperationTime, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.location = location;
        this.rating = rating;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() { return location; }

    public int getRating() {
        return rating;
    }

    public String getStartOperationTime() {
        return startOperationTime;
    }

    public String getEndOperationTime() {
        return endOperationTime;
    }

    public String getLatitude() { return latitude; }

    public String getLongitude() { return longitude; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setStartOperationTime(String startOperationTime) {
        this.startOperationTime = startOperationTime;
    }

    public void setEndOperationTime(String endOperationTime) {
        this.endOperationTime = endOperationTime;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
