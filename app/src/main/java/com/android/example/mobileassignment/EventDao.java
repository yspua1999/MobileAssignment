package com.android.example.mobileassignment;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertEvent(Event event);

//    @Query("Select * FROM event_table WHERE event_category = :category")
//    LiveData<List<Event>> loadAllEventWithCategory(String category);
//    //public Event[] loadAllEventWithCategory(String category);

    @Query("Select * FROM event_table")
    LiveData<List<Event>> loadAllEvent();

    @Query("Select * from event_table WHERE event_id=:id")
    Event findEventDetails(int id);
}
