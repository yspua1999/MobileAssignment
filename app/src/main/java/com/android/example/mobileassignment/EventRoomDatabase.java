package com.android.example.mobileassignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Event.class}, version = 1, exportSchema = false)
public abstract class EventRoomDatabase extends RoomDatabase {

    public abstract EventDao getEventDao();

    private static volatile EventRoomDatabase eventRoomInstance;

    public static EventRoomDatabase getDatabase(final Context context) {
        if (eventRoomInstance == null) {
            synchronized (EventRoomDatabase.class) {
                if (eventRoomInstance == null) {
                    eventRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            EventRoomDatabase.class, "events_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return eventRoomInstance;
    }
}
