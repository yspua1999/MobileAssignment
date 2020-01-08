package com.android.example.mobileassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class searchActivityFragment extends Fragment {

    private String eventName;
    SearchActivityViewModel searchActivityViewModel;
    TextView result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_activity, container, false);

        searchActivityViewModel = ViewModelProviders.of(this).get(SearchActivityViewModel.class);
        eventName = getArguments().getString("eventName");

        result = view.findViewById(R.id.result);
        if(searchActivityViewModel.searchEvent(eventName) != null){
            result.setText("Search result matching " + "\"" + eventName + "\"");
        }else{
            result.setText("No result found");
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EventListAdapter adapter = new EventListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        searchActivityViewModel.searchEvent(eventName).observe(this, events -> adapter.setEvents(events));

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
