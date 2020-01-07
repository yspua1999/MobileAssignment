package com.android.example.mobileassignment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


public class EventDetailsViewModel extends AndroidViewModel {
    private EventDetailsRepository eventDetailsRepository;

    public EventDetailsViewModel(@NonNull Application application) {
        super(application);
        eventDetailsRepository = new EventDetailsRepository(application);
    }


    Event findEventDetails(int id) { return eventDetailsRepository.findEventDetails(id); }
}
