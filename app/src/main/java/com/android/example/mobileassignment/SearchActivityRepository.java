package com.android.example.mobileassignment;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class SearchActivityRepository {

    private EventDao eventDao;

    SearchActivityRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        eventDao = db.getEventDao();
    }

    LiveData<List<Event>> searchEvent(String name){ return eventDao.searchEvent(name); }
}
