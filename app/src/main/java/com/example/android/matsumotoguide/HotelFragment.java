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
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {

    @BindView(R.id.list) ListView listView;
    private Unbinder unbinder;

    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Richmond Hotel Matsumoto",
                "Situated in Matsumoto, just a short walk from Matsumoto Railway Station," +
                        " the hotel provides 4-star accommodation and free wireless internet. It also" +
                        " offers room service, a beauty centre and massage services. " +
                        "This hotel provides rooms with an en suite bathroom, air conditioning and a" +
                        " TV. Hot drinks can be made with the provided tea and coffee supplies. " +
                        "Richmond Hotel Matsumoto boasts convenient dining options, including Japanese " +
                        "dishes at Isemachi Yobanashi and Japanese food at Ohashi Café Gust. " +
                        "Matsumoto's popular attractions and landmarks are within close proximity to " +
                        "the hotel, with Matsumoto Castle only a short stroll away. Matsumoto Airport " +
                        "is a 25-minute drive away.",
                R.drawable.richmond_hotel, "geo:36.2328025,137.9654184,17z?q=Richmond Hotel Matsumoto"));
        places.add(new Place("Dormy Inn Matsumoto",
                "Dormy Inn Matsumoto provides a modern setting when in Matsumoto. It also" +
                        " features massage services, a sauna and free Wi-Fi. " +
                        "A 24-hour reception, luggage storage and a laundry service are just some of " +
                        "the convenient services at the hotel. The in-house spa and wellness centre " +
                        "provides a variety of treatments and a chance to relax. " +
                        "The modern rooms at Dormy Inn Matsumoto have air conditioning and offer " +
                        "slippers, tea and coffee making facilities and a refrigerator. They have an " +
                        "en suite bathroom with bathrobes, a hair dryer and a bathtub. " +
                        "Those staying at Dormy Inn Matsumoto can enjoy a unique dining experience " +
                        "at the in-house restaurant, conveniently situated for those who want to " +
                        "stay nearby when looking to sit down to a meal. " +
                        "The hotel is close to Matsumoto Railway Station, making it easy for guests" +
                        "to discover Matsumoto and its surrounding areas. Matsumoto Castle is within" +
                        " walking distance.",
                R.drawable.dormyinn_hotel, "geo:36.2313822,137.9666229,17z?q=Dormy Inn Matsumoto"));
        places.add(new Place("Ace Inn Matsumoto",
                "Ace Inn Matsumoto offers 3-star accommodation in Matsumoto. It provides" +
                        " complimentary Wi-Fi, free bicycle rental and off-site parking. " +
                        "Ace Inn features 158 air conditioned rooms equipped with all the necessities " +
                        "to ensure a comfortable stay. After settling in to their room, " +
                        "guests can explore the local area with use of Matsumoto Railway Station," +
                        " which is within a five-minute walk of the hotel. " +
                        "Those staying at the property can wake up to a satisfying breakfast prepared " +
                        "every morning, before heading out from Ace Inn Matsumoto to discover the " +
                        "surrounding area. Ace Inn is surrounded by the area's well-known sightseeing " +
                        "attractions, including Matsumoto Castle, which is a short walk away. " +
                        "The Kaichi School Museum is in close proximity to the property.",
                R.drawable.aceinn_hotel, "geo:36.2300698,137.9636495,17z?q=Ace Inn Matsumoto"));
        places.add(new Place("Premier Hotel Cabin Matsumoto",
                "Premier Hotel Cabin Matsumoto is situated in Matsumoto and is close to" +
                        " the area's tourist attractions. It offers complimentary Wi-Fi, massage " +
                        "services and laundry facilities. The hotel has 106 rooms and has been " +
                        "recently refurbished. Welcoming and professional team members are available " +
                        "24 hours a day. The air conditioned rooms at Premier Hotel Cabin Matsumoto " +
                        "are well-appointed. Each has a bathroom that has a hair dryer and slippers. " +
                        "Serving Japanese dishes, the on-site restaurant features an air-conditioned " +
                        "dining room along with an outdoor terrace. There is also a variety of " +
                        "breakfast options to choose from every day. Premier Hotel Cabin Matsumoto is " +
                        "within walking distance of Matsumoto Castle. The hotel's multilingual staff " +
                        "are available to ensure that every traveller has a comfortable stay.",
                R.drawable.premiercabin_hotel, "geo:36.2306073,137.9639813,17z?q=Premier Hotel Cabin Matsumoto"));

        places.add(new Place("Oiwakeya Ryokan",
                "Beautiful Ryokan in a quiet residential area of Matsumoto. The service" +
                        " is excellent, a real Japanese experience. The Ryokan is nicely decorated " +
                        "and there are also Koi fish inside! The room is big with Tatami floor. " +
                        "They have both public and private Onsen, the private is relaxing with " +
                        "external and internal pool. Had a full Kaiseki Dinner, that was good but " +
                        "not the best I had in Japan. The Ryokan is a bit far from the train " +
                        "station, about 10 minutes by cab.",
                R.drawable.ryoukan_hotel, "geo:36.2454033,137.9961833,17z?q=Oiwakeya"));


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
