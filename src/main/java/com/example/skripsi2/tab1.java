package com.example.skripsi2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    MapView Vmap;
    View mView;


    public tab1() {
        // Required empty public constructor
    }

    ViewFlipper v_flipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_tab1, container, false);
        Button build = (Button)mView.findViewById(R.id.build);
        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Te.class));
            }
        });
        return mView;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Vmap = (MapView) mView.findViewById(R.id.map);
        if (Vmap != null) {
            Vmap.onCreate(null);
            Vmap.onResume();
            Vmap.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        map = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(1.417634, 124.984343)).title("Unklab"));
        CameraPosition UK = CameraPosition.builder().target(new LatLng(1.417634, 124.984343)).zoom(16).bearing(0).tilt(15).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(UK));
    }
}