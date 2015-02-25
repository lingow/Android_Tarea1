package com.lingoware.tarea1;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentNavigationDrawer extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public FragmentNavigationDrawer(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView= inflater.inflate(R.layout.layout_navigation_drawer, container, false);
        ListView list = (ListView) fragmentView.findViewById(R.id.navigation_list_view);
        list.setAdapter(new ArrayAdapter<String>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.car_names)
        ));

        list.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener) getActivity());
        ListView labeledIcons = (ListView) fragmentView.findViewById(R.id.navigation_icon_list_view);
        String[] labels = getResources().getStringArray(R.array.navigation_items_with_icons);
        TypedArray icons = getResources().obtainTypedArray(R.array.navicons);
        List<LabeledIcon> lst = new ArrayList<>();
        for (int i = 0 ; i < labels.length;i++){
            lst.add(new LabeledIcon(labels[i], icons.getResourceId(i, -1)));
        }
        labeledIcons.setAdapter(new IconListAdapter(
                lst,
                this.getActivity(),
                Arrays.asList(labels)
        ));
        labeledIcons.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener) getActivity());
        return fragmentView;
    }

}
