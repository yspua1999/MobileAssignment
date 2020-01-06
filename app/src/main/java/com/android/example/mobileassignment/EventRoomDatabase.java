package com.android.example.mobileassignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Event.class, version = 1)
public abstract class EventRoomDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

    private static volatile EventRoomDatabase eventRoomInstance;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static EventRoomDatabase getDatabase(final Context context) {
        if (eventRoomInstance == null) {
            synchronized (EventRoomDatabase.class) {
                if (eventRoomInstance == null) {
                    eventRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            EventRoomDatabase.class, "event_database")
                            .build();
                }
            }
        }
        return eventRoomInstance;
    }
}
