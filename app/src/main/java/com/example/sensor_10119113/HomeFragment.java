package com.example.sensor_10119113;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class HomeFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;
    private Button btnFind;
    private double currentLat = 0, currentLong = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_home, container, false);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        btnFind = (Button) fragment.findViewById(R.id.btn_find);

        getCurrentLocation();

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.88473319759774, 107.61640276608132);
                        LatLng lokasi2 = new LatLng(-6.884381698848637, 107.61411752401223);
                        LatLng lokasi3 = new LatLng(-6.884403001811196, 107.61349525152424);
                        LatLng lokasi4 = new LatLng(-6.882826579999446, 107.61364545522824);
                        LatLng lokasi5 = new LatLng(-6.884871666764502, 107.61701430973018);

                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Dapur Eyang Restaurant");
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Ikan Laut Sambal Pesisir");
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Yagami Ramen House Dago");
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Tizi Cake Shop & Restaurant");
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Raja Basa 9");

                        googleMap.addMarker(options1);
                        googleMap.addMarker(options2);
                        googleMap.addMarker(options3);
                        googleMap.addMarker(options4);
                        googleMap.addMarker(options5);

                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi2, 16));
                    }
                });
            }
        });

        return fragment;
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(mapFragment.getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (mapFragment.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLat = location.getLatitude();
                    currentLong = location.getLongitude();
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            LatLng lokasi = new LatLng(currentLat,currentLong);
                            MarkerOptions options = new MarkerOptions().position(lokasi).title("Lokasi Saat Ini");
                            googleMap.addMarker(options);
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 17));
                        }
                    });
                }
            }
        });
    }
}

//NIM : 10119113
//Nama : Dafa Rizky Fahreza
//Kelas : IF3