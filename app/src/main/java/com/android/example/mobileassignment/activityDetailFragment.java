package com.android.example.mobileassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class activityDetailFragment extends Fragment {
    EventDetailsViewModel eventDetailsViewModel;
    TextView eventName, eventLocation, eventHour, eventDescription;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_detail, container, false);

        eventDetailsViewModel = ViewModelProviders.of(this).get(EventDetailsViewModel.class);

        int eventId = getArguments().getInt("eventId");

        eventName = view.findViewById(R.id.eventName);
        eventLocation = view.findViewById(R.id.tvLocationDetail);
        eventHour = view.findViewById(R.id.tvOperationHours);
        eventDescription = view.findViewById(R.id.tvDescriptionDetail);

        if(eventDetailsViewModel.findEventDetails(eventId).getId() == eventId){
            Event eventDetails =  eventDetailsViewModel.findEventDetails(eventId);

            eventName.setText(eventDetails.getName());
            eventLocation.setText(eventDetails.getLocation());
            eventHour.setText(eventDetails.getStartOperationTime() + "-" + eventDetails.getEndOperationTime());
            eventDescription.setText((eventDetails.getDescription()));
        }

       return view;
    }
}
