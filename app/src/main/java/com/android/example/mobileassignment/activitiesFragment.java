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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class activitiesFragment extends Fragment {

    EventViewModel eventViewModel;
    Button search;
    EditText name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

//        Event event = new Event(0,"Wangsa Siaga Basketball Court", "outdoor", "so fun to play here", "Taman Wangsa Melawati, 54200 Kuala Lumpur, Federal Territory of Kuala Lumpur", 4, "15:00" , "17:00", "3.200476", "101.747272");
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

        search = view.findViewById(R.id.button_search);
        name = view.findViewById(R.id.search_activity);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchActivityFragment searchActivityFragment = new searchActivityFragment();
                Bundle bundle = new Bundle();
                bundle.putString("eventName", name.getText().toString());
                searchActivityFragment.setArguments(bundle);

                getFragmentManager().beginTransaction().addToBackStack(null).replace(getId(), searchActivityFragment).commit();
            }
        });

        return view;
    }

}
