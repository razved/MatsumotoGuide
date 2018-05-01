package com.example.android.matsumotoguide;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpaFragment extends Fragment {

    @BindView(R.id.list) ListView listView;
    private Unbinder unbinder;

    public SpaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.biwanoyu_spa_name),
                getString(R.string.biwanoyu_spa_description),
                getString(R.string.biwanoyu_spa_hours),
                R.drawable.biwanoyu_spa,
                getString(R.string.biwanoyu_spa_location)));
        places.add(new Place(getString(R.string.hotplaza_spa_name),
                getString(R.string.hotplaza_spa_description),
                getString(R.string.hotplaza_spa_hours),
                R.drawable.hotplaza_spa,
                getString(R.string.hotplaza_spa_location)));
        places.add(new Place(getString(R.string.utsukushigahara_spa_name),
                getString(R.string.utsukushigahara_spa_description),
                getString(R.string.utsukushigahara_spa_hours),
                R.drawable.shiroito_spa,
                getString(R.string.utsukushigahara_spa_loaction)));

        //create a PlaceAdater (class successor of ArrayAdapter) and fill it by places ArrayList.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        //create connection among listView and PlaceAdapter to display list of places
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Context context = view.getContext();
                Intent intent = new Intent(context, PlaceActivity.class);
                intent.putExtra(Consts.NAME_STRING, places.get(position).getName());
                intent.putExtra(Consts.DESCRIPTION_STRING, places.get(position).getDescription());
                intent.putExtra(Consts.BUSINESS_HOURS_STRING, places.get(position).getBusinessHours());
                intent.putExtra(Consts.LOCATION_STRING, places.get(position).getLocation());
                intent.putExtra(Consts.IMAGE_ID, places.get(position).getImage());
                context.startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //destroy binding among variables and views
        unbinder.unbind();
    }
}
