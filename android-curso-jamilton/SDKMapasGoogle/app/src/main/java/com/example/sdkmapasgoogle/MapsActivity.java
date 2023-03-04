package com.example.sdkmapasgoogle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.sdkmapasgoogle.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        // mMap.setMapStyle(GoogleMap.MAP_TYPE_SATELLITE); -> definir estilo de mapa
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "Lat " + latitude + "Long " + longitude,
                        Toast.LENGTH_SHORT).show();

                mMap.addMarker(new MarkerOptions().position(latLng).title("Local").snippet("Descrição")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                );
            }
        });

        LatLng sydney = new LatLng(-34, 151);

//        CircleOptions circleOptions = new CircleOptions();
//        circleOptions.center(sydney);
//        circleOptions.radius(500); // em metros
//        circleOptions.strokeWidth(10);
//        circleOptions.strokeColor(Color.GREEN);
//        circleOptions.fillColor(Color.argb(128, 255, 153, 0)); // 0 até 255 alpha
//        mMap.addCircle(circleOptions);

//        PolygonOptions polygonOptions = new PolygonOptions();
//        polygonOptions.add(new LatLng(-34, 151),
//                new LatLng(-34.000012, 151.000104),
//                new LatLng(-34.000060, 151.000023));
//        polygonOptions.strokeColor(Color.GREEN);
//        polygonOptions.strokeWidth(10);
//        polygonOptions.fillColor(Color.argb(128, 255, 153, 0));
//        mMap.addPolygon(polygonOptions);

        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(new LatLng(-34.000012, 151.000104));
        polylineOptions.add(new LatLng(-34.000060, 151.000023));
        polylineOptions.color(Color.BLUE);
        polylineOptions.width(20);
        mMap.addPolyline(polylineOptions);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney")
                //.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)) -> define cor marcador
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.logo)) -> define ícone
                );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
    }
}