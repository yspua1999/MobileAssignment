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


    public Event(int id, String name, String category, String description, String location, int rating, String startOperationTime, String endOperationTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.location = location;
        this.rating = rating;
        this.startOperationTime = startOperationTime;
        this.endOperationTime = endOperationTime;
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

    public String getLocation() {
        return location;
    }

    public int getRating() {
        return rating;
    }

    public String getStartOperationTime() {
        return startOperationTime;
    }

    public String getEndOperationTime() {
        return endOperationTime;
    }

}
