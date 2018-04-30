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

    @BindView(R.id.list) ListView listView;
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
        places.add(new Place("Spa Biwanoyu",
                "Biwa No Yu is an onsen with more than 400 years of history. " +
                        "It was founded by the first lord of Matsumoto Castle, Ishikawa, who bathed " +
                        "at the onsen. The onsen remained a private area maintained by the palace " +
                        "for many years, and to this day is maintained by an ancestor of Lord Ishikawa.",
                "9am – 9pm (doors close 8pm)",
                R.drawable.biwanoyu_spa, "geo:36.266124,137.9891843?q=Biwanoyu"));
        places.add(new Place("Kaichi Gakko Primary School",
                "One of the oldest elementary schools in Japan. The school was completed " +
                        "in 1876 and combines Japan and Western architecture; it operated until " +
                        "March 1963. It is a Meiji era cultural site. Various instruction materials " +
                        "and furnishings are on display. The school was reconstructed at its current " +
                        "location and restored as a museum of education",
                "8:30am - 4:30pm (doors close 5pm)",
                R.drawable.kaichi_gakko, "geo:36.2430524,137.9660708,17z?q=Kaichi School Museum"));
        places.add(new Place("Japan Ukiyo-e Museum",
                "Japan Ukiyo-e (Ukiyoe) Museum is a print maker's dream, holding the " +
                        "largest private collection of ukiyo-e (woodblock prints), paintings screens " +
                        "and old books in the world. The Sakai family has collected more than 100,000 " +
                        "pieces over several generations. English information is limited, but there " +
                        "is a pamphlet you can get at the front and the staff are very friendly.",
                "10am - 5pm (doors close 4:30pm)",
                R.drawable.ukiyoe_museum, "geo:36.2318727,137.9323625,17z?q=Japan Ukiyo-e Museum"));



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
