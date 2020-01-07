package com.android.example.mobileassignment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private EventRepository eventRepository;

    public EventViewModel(Application application){
        super(application);
        eventRepository = new EventRepository(application);
    }

    public LiveData<List<Event>> getAllEvents(){ return eventRepository.getAllEvents(); }


    public void insertEvent(Event event){ eventRepository.insertEvent(event); }
}
//
//public class EventViewModel extends AndroidViewModel {
//    private EventRepository eventRepository;
//
//    public EventViewModel(@NonNull Application application) {
//        super(application);
//        eventRepository = new EventRepository(application);
//    }
//
//    public LiveData<List<Event>> getmASCRating(){ return eventRepository.getmGetASCRating(); }
//
//    public void insertEvent(Event event){ eventRepository.insertEvent(event); }
//}