package com.example.portatil.compuglobalhipermeganet;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactoActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
<<<<<<< HEAD
        LatLng sydney = new LatLng(38.9929953, -1.8605619);
        mMap.addMarker(new MarkerOptions().position(sydney).title("ToyLand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
=======
        LatLng tienda = new LatLng(38.9936115, -1.85956);
        mMap.addMarker(new MarkerOptions().position(tienda).title("Tienda fisica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tienda,12));
>>>>>>> 84cf3ee7213ec351f74c5c41901c664723502bc2
    }
}
