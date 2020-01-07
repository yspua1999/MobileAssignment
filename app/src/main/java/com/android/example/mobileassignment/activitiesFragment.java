package com.android.example.mobileassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class activitiesFragment extends Fragment {

    EventViewModel eventViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

//        Event event = new Event(0,"event 14", "indoor", "so fun to play here", "B-10-12 B V-Residentsi, Persiaran Selayang Height, Batu Caves.", 4, "15:00" , "17:00");
//        eventViewModel.insertEvent(event);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EventListAdapter adapter = new EventListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        eventViewModel.getAllEvents().observe(this, events -> adapter.setEvents(events));

        adapter.setOnItemClickListener(new EventListAdapter.OnEventItemClickListener() {
            @Override
            public void onItemClick(int position) {
                activityDetailFragment activityDetail = new activityDetailFragment();
                Bundle bundle = new Bundle();
                String eventId = ((TextView) recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.hidden_id)).getText().toString();
                bundle.putInt("eventId", Integer.parseInt(eventId));
                activityDetail.setArguments(bundle);

                getFragmentManager().beginTransaction().addToBackStack(null).replace(getId(), activityDetail).commit();
            }
        });

        return view;
    }

}
