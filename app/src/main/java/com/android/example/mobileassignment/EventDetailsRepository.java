package com.android.example.mobileassignment;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EventDetailsRepository {
    private EventDao eventDao;

    EventDetailsRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        eventDao = db.getEventDao();
    }

    Event findEventDetails(int id){ return eventDao.findEventDetails(id); }

    static class FindEventDetailsAsyncTask extends AsyncTask<Integer, Void, Void> {
        private EventDao eventDao;

        public FindEventDetailsAsyncTask(EventDao eventDao){this.eventDao = eventDao;}

        @Override
        protected Void doInBackground(Integer...integers) {
            eventDao.findEventDetails(integers[0]);
            return null;
        }
    }
}
