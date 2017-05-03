package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * Created by gusbru on 4/28/17.
 */

public class EventsAdapter extends ArrayAdapter<Events> {

    /**
     *
     * @param context activity context
     * @param event ArrayList element with the earthquake event
     */
    public EventsAdapter(Activity context, ArrayList<Events> event) {
        //
        super(context, 0, event);
    }


    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return the populated listItemView
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.events_view,
                    parent,
                    false
            );
        }

        // Get the {@link Events} object located at this position in the list
        Events currentEvent = getItem(position);


        // Start to fill the elements at events_view
        // ==========================================

        // magnitude
        TextView magnitude = (TextView) listItemView.findViewById(R.id.events_magnitude);
        magnitude.setText(String.format(Locale.UK, "%2.1f", currentEvent.getmMagnitude()));

        // location
        TextView location = (TextView) listItemView.findViewById(R.id.events_location);
        location.setText(currentEvent.getmPlace());

        // date
        // here we convert the unix timestamp to human readable
        TextView date = (TextView) listItemView.findViewById(R.id.events_date);
        Date mDate = new Date((long)currentEvent.getmDate()*1000);
//        date.setText(String.format(Locale.US, "%d", mDate));
        date.setText(mDate.toString());

        return listItemView;
    }
}