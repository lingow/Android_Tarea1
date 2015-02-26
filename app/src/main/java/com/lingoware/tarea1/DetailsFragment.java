package com.lingoware.tarea1;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
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
        name = (TextView) v.findViewById(R.id.car_name);
        return v;
    }

    public void loadDetails(int i){
        TypedArray arr = getResources().obtainTypedArray(R.array.car_images);
        img.setImageResource(arr.getResourceId(i,-1));

        rating.setRating(getResources().getIntArray(R.array.car_ratings)[i]/2);
        LayerDrawable ld = (LayerDrawable)rating.getProgressDrawable();
        ld.getDrawable(2).setColorFilter(getResources().getColor(R.color.starFull), PorterDuff.Mode.SRC_ATOP);
        ld.getDrawable(1).setColorFilter(getResources().getColor(R.color.starStarPartial), PorterDuff.Mode.SRC_ATOP);
        ld.getDrawable(0).setColorFilter(getResources().getColor(R.color.starStarNot), PorterDuff.Mode.SRC_ATOP);

        txt.setText(getResources().getStringArray(R.array.car_text)[i]);

        name.setText(getResources().getStringArray(R.array.car_names)[i]);
    }
}
