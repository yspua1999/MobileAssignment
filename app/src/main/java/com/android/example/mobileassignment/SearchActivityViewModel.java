package com.android.example.mobileassignment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SearchActivityViewModel extends AndroidViewModel {
    private SearchActivityRepository searchActivityRepository;

    public SearchActivityViewModel(@NonNull Application application) {
        super(application);
        searchActivityRepository = new SearchActivityRepository(application);
    }

    LiveData<List<Event>> searchEvent(String name) { return searchActivityRepository.searchEvent(name); }
}

