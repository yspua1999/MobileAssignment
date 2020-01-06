package com.android.example.mobileassignment;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private EventRepository mRepository;

    private LiveData<List<Event>> mASCRating;

    public EventViewModel(Application application){
        super(application);
        mRepository = new EventRepository(application);
        mASCRating = mRepository.getASCRating();
    }

    LiveData<List<Event>> getmASCRating(){
        return mASCRating;
    }

    public void insert (Event event){
        mRepository.insert(event);
    }
}
