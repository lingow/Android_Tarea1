package com.lingoware.tarea1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lingow on 25/02/15.
 */
public class IconListAdapter extends ArrayAdapter<String> {
    private List<LabeledIcon> labeledIcons;
    private Context context;

    public IconListAdapter(List<LabeledIcon> labeledIcons, Context ctx, List<String> strs) {
        super(ctx, android.R.layout.simple_list_item_1, strs);
        this.labeledIcons = labeledIcons;
        this.context = ctx;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position,convertView,parent);
        // First let's verify the convertView is not null
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_labeled_icon, parent, false);
        }
        // Now we can fill the layout with the right values
        LabeledIcon li = labeledIcons.get(position);
        ((TextView)convertView).setCompoundDrawablesWithIntrinsicBounds(li.iconid, 0, 0, 0);

        return convertView;
    }
}
