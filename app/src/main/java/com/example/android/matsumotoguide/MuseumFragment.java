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
import android.widget.TextView;

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
        places.add(new Place("Matsumoto Castle",
                "Matsumoto Castle is one of the most complete and beautiful among Japan's " +
                        "original castles.  Matsumoto Castle is unique for having both a secondary " +
                        "donjon and a turret adjoined to its main keep. The castle structures, in " +
                        "combination with their characteristic black wainscoting, give off an air " +
                        "of grandeur and poise.", "8:30am - 5pm (doors close 4:30pm)",
                R.drawable.matsumoto_castle, "geo:36.238652,137.9667664,17z?q=Matsumoto Castle"));
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
        places.add(new Place("Matsumoto City Museum of Art",
                "the Matsumoto City Museum of Art’s four fundamental themes are Appreciation, " +
                        "Representation, Learning and Communication. At the entrance is a dynamic " +
                        "outdoor installation by Matsumoto native Yayoi Kusama. Her contemporary art " +
                        "takes viewers to another world with its almost hallucinatory energy." +
                        " The museum features works by other Matsumoto artists as well as pieces " +
                        "taking inspiration from the nearby Japanese Alps.",
                "9:00 - 17:00",
                R.drawable.museum_art, "geo:36.231628,137.9743083,17z?q=Matsumotoshi Museum"));
        places.add(new Place("Matsumoto Timepiece Museum",
                "49th year of the Showa era(1974), Mr.Chikazo Honda donated his old " +
                        "western and Japanese timepiece collection, in which he devoted himself to, " +
                        "hoping many people could enjoy it for a long time. Over the course of time," +
                        " some citizens donated more timepieces and enriched the collection, which led" +
                        " to the opening of Matsumoto Timepiece Museum on September 1st, 2002. The biggest " +
                        "feature of the museum is that many of the timepieces are displayed working." +
                        " There are more than 300 timepieces. The museum hopes that it will become" +
                        " a landmark in Matsumoto and every visitor has a wonderful time.",
                "9am - 5pm (doors close 4:30pm)",
                R.drawable.timepiece_museum, "geo:36.2337941,137.9664543,17z?q=Matsumotoshi Timepiece Museum"));

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
