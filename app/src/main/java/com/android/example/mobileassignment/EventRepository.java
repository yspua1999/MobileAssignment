package com.android.example.mobileassignment;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EventRepository {
    private EventDao eventDao;
    //private LiveData<List<Event>> mGetCategories;
    private LiveData<List<Event>> allEvent;


    EventRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        eventDao = db.getEventDao();
        allEvent = eventDao.loadAllEvent();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
//    LiveData<List<Event>> getCategories() {
//        return mGetCategories;
//    }

    LiveData<List<Event>> getAllEvents() {
        return allEvent;
    }

   public void insertEvent(Event event) {
        new InsertAsyncTask(eventDao).execute(event);
    }

    static class InsertAsyncTask extends AsyncTask<Event, Void, Void>{
        private EventDao eventDao;

        public InsertAsyncTask(EventDao dao) {
            this.eventDao = dao;
        }

        @Override
        protected Void doInBackground(final Event... events) {
            eventDao.insertEvent(events[0]);
            return null;
        }
    }
}

//public class EventRepository {
//    private LiveData<List<Event>> mGetASCRating;
//    private EventDao eventDao;
//
//
//    EventRepository(Context context) {
//        EventRoomDatabase db = EventRoomDatabase.getDatabase(context.getApplicationContext());
//        eventDao = db.getEventDao();
//        mGetASCRating = eventDao.loadASCRating();
//    }
//
//    LiveData<List<Event>> getASCRating() {
//        return mGetASCRating;
//    }
//
//    void insertEvent(Event event) {
//        new InsertAsyncTask(eventDao).execute(event);
//    }
//
//
//    static class InsertAsyncTask extends AsyncTask<Event, Void, Void> {
//        private EventDao eventDao;
//
//        InsertAsyncTask(EventDao eventDao) {
//            this.eventDao = eventDao;
//        }
//
//        @Override
//        protected Void doInBackground(Event... events) {
//            eventDao.insertEvent(events[0]);
//            return null;
//        }
//    }
//
//}