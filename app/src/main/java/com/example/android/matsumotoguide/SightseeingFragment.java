package com.example.android.matsumotoguide;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class SightseeingFragment extends Fragment {

    @BindView(R.id.list)
    ListView listView;
    private Unbinder unbinder;

    public SightseeingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Matsumoto Castle",
                "Matsumoto Castle is one of the most complete and beautiful among Japan's " +
                        "original castles.  Matsumoto Castle is unique for having both a secondary " +
                        "donjon and a turret adjoined to its main keep. The castle structures, in " +
                        "combination with their characteristic black wainscoting, give off an air " +
                        "of grandeur and poise.",
                R.drawable.matsumoto_castle, "geo:36.238652,137.9667664,17z?q=Matsumoto Castle"));
        places.add(new Place("Nawate Dori street",
                "Located 5 minutes on foot from Matsumoto Castle and 10 min from Matsumoto " +
                        "Station, Nawate-dori is a shopping street that gives the feel of the city's " +
                        "history as a castle town. Lined with around 50 shops that vary from antique " +
                        "dealers and 'dagashi' candy stores to stylish bakeries and designer boutiques, " +
                        "the frog-themed street makes a great place to stroll when seeing the castle.",
                R.drawable.nawate_street, "geo:36.2344467,137.9673989,17z?q=Nawate Dori "));
        places.add(new Place("Nakamachi District",
                "During the Edo period (1603-1867) in Japan, Nakamachi Street was located" +
                        " in the center part of the castle town of Matsumoto City thus denoting its " +
                        "name: “Naka” – meaning in or center, and “machi” – meaning town. It was" +
                        " located on the old Zenkoji Kaido, a route connecting Zenkoji Temple to" +
                        " Nagoya and Kyoto and prospered as the main business district where wholesale " +
                        "dealers sold their goods (mainly sake brewers and kimono merchants). Many" +
                        " of the historical buildings found in Nakamachi used to function as storehouses. " +
                        "These buildings are called kura or dozo and some are more than a 100 years old.",
                R.drawable.nakamachi_street, "geo:36.233834,137.9695607,17z?q=Nakamachi shopping street promotion association"));
        places.add(new Place("Agatanomori Park",
                "Agatanomori Park in Matsumoto, Japan, is very much a local’s park. This" +
                        " forest park is a great place for families, couples, or people who want " +
                        "to relax in a peaceful and beautiful park. You’ll see animals, ponds, " +
                        "waterfalls, old buildings, and tall trees. You can also learn a bit about" +
                        " Matsumoto history by touring the historical Matsumoto High School building." +
                        " Although it’s called a “high school,” back in the day the school curriculum" +
                        " was actually the equivalent to what we consider a college curriculum today," +
                        " and served as the original location for Shinshu University.",
                R.drawable.agatanomori, "geo:36.2312858,137.9816192,17z?q=Agata Forest Park"));


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
