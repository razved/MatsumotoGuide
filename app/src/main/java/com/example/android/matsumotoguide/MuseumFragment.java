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
public class MuseumFragment extends Fragment {

    @BindView(R.id.list)
    ListView listView;
    private Unbinder unbinder;

    public MuseumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.matsumoto_castle_name),
                getString(R.string.matsumoto_castle_description),
                R.drawable.matsumoto_castle,
                getString(R.string.matsumoto_castle_location)));
        places.add(new Place(getString(R.string.kaichi_museum_name),
                getString(R.string.kaichi_museum_description),
                getString(R.string.kaichi_museum_hours),
                R.drawable.kaichi_gakko,
                getString(R.string.kaichi_museum_location)));
        places.add(new Place(getString(R.string.ukiyoe_museum_name),
                getString(R.string.ukiyoe_museum_descriptions),
                getString(R.string.ukiyoe_museum_hours),
                R.drawable.ukiyoe_museum,
                getString(R.string.ukiyoe_museum_location)));
        places.add(new Place(getString(R.string.art_museum_name),
                getString(R.string.art_museum_description),
                getString(R.string.art_museum_hours),
                R.drawable.museum_art,
                getString(R.string.art_museum_location)));
        places.add(new Place(getString(R.string.timepiece_museum_name),
                getString(R.string.timepiece_museum_description),
                getString(R.string.timepiece_museum_hours),
                R.drawable.timepiece_museum,
                getString(R.string.timepiece_museum_location)));

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
