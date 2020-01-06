package com.android.example.mobileassignment;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EventRepository {
    private EventDao mEventDao;
    //private LiveData<List<Event>> mGetCategories;
    private LiveData<List<Event>> mGetASCRating;


    EventRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        mEventDao = db.eventDao();
       // mGetCategories = mEventDao.loadAllEventWithCategory(String category);
        mGetASCRating = mEventDao.loadASCRating();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    LiveData<List<Event>> getCategories() {
//        return mGetCategories;
//    }

    LiveData<List<Event>> getASCRating() {
        return mGetASCRating;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Event event) {
        EventRoomDatabase.databaseWriteExecutor.execute(() -> {
            mEventDao.insert(event);
        });
    }
}
