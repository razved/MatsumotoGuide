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
        places.add(new Place("Biwanoyu",
                "Biwa No Yu is an onsen with more than 400 years of history. " +
                        "It was founded by the first lord of Matsumoto Castle, Ishikawa, who bathed " +
                        "at the onsen. The onsen remained a private area maintained by the palace " +
                        "for many years, and to this day is maintained by an ancestor of Lord Ishikawa.",
                "9am – 9pm (doors close 8pm)",
                R.drawable.biwanoyu_spa, "geo:36.266124,137.9891843?q=Biwanoyu"));
        places.add(new Place("Hot Plaza Asama",
                "If you need a wash, this is the place, as it’s the easiest to find from " +
                        "the bus station & opposite the post office, large & uncomplicated. It can " +
                        "get a bit busy as it is popular with the gray population as a social locus," +
                        " but the main pools are large & you’ll always find a stool to have a wash. " +
                        "Loads of room to sit & day dream while you wait for the rest of your party" +
                        " to surface, vending machines & massage chairs",
                "10am - 0am (doors close 11pm)",
                R.drawable.hotplaza_spa, "geo:36.2628454,137.9865075,17z?q=Hot plaza asama onsen"));
        places.add(new Place("Utsukushigahara",
                "Rebuilt fairly recently, this little place caters to the local community. " +
                        "As a result it has a regular clientelle & can give you ‘local’ feel. " +
                        "There’s a sign on the door saying ‘no drunks’ - actually good advice as a " +
                        "hot bath with a skinful can seriously damage your health! More of a sento " +
                        "than an onsen, but clean & cheerful, as well as cheap. Perhaps best to avoid " +
                        "local ‘rush hour’ - early evening. Your first challenge is to decode the " +
                        "vending machine that sells tickets just inside the door - tickets which you " +
                        "then hand over to the lady sitting 4 feet away watching you.",
                "April - Sept = 6am - 10pm (doors close 9.30pm)\n" +
                        "Oct - Mar  = 6.30am - 10pm (doors close 9.30pm)\n" +
                        "Weekends/holidays open from 6am\n",
                R.drawable.shiroito_spa, "geo:36.246055,137.9966342,17z?q=白糸の湯"));

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
