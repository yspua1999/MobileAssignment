package com.android.example.mobileassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {

    private OnEventItemClickListener mListener;

    public interface OnEventItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnEventItemClickListener listener){
        mListener = listener;
    }

   static class EventViewHolder extends RecyclerView.ViewHolder {
        private final TextView eventIdView, eventNameView, eventAddressView, eventOprtHourView;

        private EventViewHolder(View itemView, OnEventItemClickListener listener) {
            super(itemView);
            eventIdView = itemView.findViewById(R.id.hidden_id);
            eventNameView = itemView.findViewById(R.id.name);
            eventAddressView = itemView.findViewById(R.id.address);
            eventOprtHourView = itemView.findViewById(R.id.operation_hour);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    private final LayoutInflater mInflater;
    private List<Event> Events;

    EventListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_activities, parent, false);
        return new EventViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        if (Events != null) {
            Event current = Events.get(position);
            holder.eventIdView.setText(String.valueOf(current.getId()));
            holder.eventNameView.setText("Event name : " + current.getName());
            holder.eventAddressView.setText("Address : " + current.getLocation());
            holder.eventOprtHourView.setText("Operation Hours : " + current.getStartOperationTime() + "-" + current.getEndOperationTime());
        } else {
            // Covers the case of data not being ready yet.
            holder.eventNameView.setText("Invalid");
        }
    }

    void setEvents(List<Event> events){
        Events = events;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (Events != null)
            return Events.size();
        else return 0;
    }
}
