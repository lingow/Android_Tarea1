package com.lingoware.tarea1;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsFragment extends Fragment {

    ImageView img;
    RatingBar rating;
    TextView txt;
    TextView name;

    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_activity_main_container, container, false);
        img = (ImageView) v.findViewById(R.id.content_image);
        rating = (RatingBar) v.findViewById(R.id.content_rating);
        txt = (TextView) v.findViewById(R.id.content_text);

        return v;
    }

    public void loadDetails(int i){
        TypedArray arr = getResources().obtainTypedArray(R.array.car_images);
        img.setImageResource(arr.getResourceId(i,-1));

        rating.setNumStars(getResources().getIntArray(R.array.car_ratings)[i]/2);

        txt.setText(getResources().getStringArray(R.array.car_text)[i]);

        name.setText(getResources().getStringArray(R.array.car_names)[i]);
    }
}
