package com.example.android.matsumotoguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.backdrop) ImageView image;
    @BindView(R.id.description) TextView description;
    @BindView(R.id.hours) TextView businessHours;
    @BindView(R.id.hours_header) TextView businessHoursHeader;
    @BindView(R.id.whereitis) ImageView locationLogo;

    String locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_place);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String nameText = intent.getStringExtra(Consts.NAME_STRING);
        String descriptionText = intent.getStringExtra(Consts.DESCRIPTION_STRING);
        String hoursText = intent.getStringExtra(Consts.BUSINESS_HOURS_STRING);
        locationText = intent.getStringExtra(Consts.LOCATION_STRING);
        int imageId = intent.getIntExtra(Consts.IMAGE_ID, 0);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar.setTitle(nameText);
        image.setImageResource(imageId);

        if (!hoursText.isEmpty()) {
            businessHours.setText(hoursText);
        } else {
            businessHours.setVisibility(View.GONE);
            businessHoursHeader.setVisibility(View.GONE);
        }
        description.setText(descriptionText);

    }

    /**
     * when you click on Where it is logo, app open other map application with this place
     */
    @OnClick(R.id.whereitis)
    public void openMap() {
        Uri placeLocation = Uri.parse(locationText);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, placeLocation);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

}
