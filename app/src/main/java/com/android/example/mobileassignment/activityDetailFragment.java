package com.android.example.mobileassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;


public class activityDetailFragment extends Fragment implements OnMapReadyCallback {
    EventDetailsViewModel eventDetailsViewModel;
    TextView eventName, eventLocation, eventHour, eventDescription;
    private String longitude, latitude, title;
    private SupportMapFragment googleMap;
    private GoogleMap mMap;
    public activityDetailFragment() {
        // Required empty public constructor
    }

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
            eventHour.setText(Html.fromHtml(eventDetails.getStartOperationTime() + "-" + eventDetails.getEndOperationTime() + "<br><br> <font><b>Rating : </b></font>"+ eventDetails.getRating() + "/5"));
            eventDescription.setText((eventDetails.getDescription()));
            longitude = eventDetails.getLongitude();
            latitude = eventDetails.getLatitude();
            title = eventDetails.getName();
        }
        googleMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));

        if(googleMap == null){
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            googleMap = SupportMapFragment.newInstance();
            ft.replace(R.id.map, googleMap).commit();
        }
        googleMap.getMapAsync(this);
        //MapsInitializer.initialize(getActivity().getApplicationContext());

//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(38.7222524, -9.139336599999979))
//                .title("MyLocation")
//                );
//
//        // Move the camera instantly  with a zoom of 15.
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom( new LatLng( 38.7222524, -9.139336599999979), 15));
//
//        // Zoom in, animating the camera.
//        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12), 1000, null);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng UCA = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        mMap.addMarker(new MarkerOptions().position(UCA).title(title)).showInfoWindow();

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(UCA, 17));

    }
}
