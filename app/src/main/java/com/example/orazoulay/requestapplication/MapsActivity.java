package com.example.orazoulay.requestapplication;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private String address;
    private GoogleMap mMap;
    TextView firstNameTV;
    TextView cityTV;
    TextView emailTV;
    TextView phoneNumberTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        firstNameTV=findViewById(R.id.mapFirstName_TV);
        cityTV=findViewById(R.id.mapCity_TV);
        emailTV=findViewById(R.id.mapEmail_TV);
        phoneNumberTV=findViewById(R.id.mapPhoneNumber_TV);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String value = extras.getString("firstname")+" "+extras.getString("lastname");
            firstNameTV.setText(value);
            value=extras.getString("city")+" "+extras.getString("street");;
            cityTV.setText(value);
            address =value;
            value=extras.getString("email");
            emailTV.setText(value);
            value=extras.getString("phonenumber");
            phoneNumberTV.setText(value);
        }
    }


    public static LatLng getCityLatitude(Context context, String city) {
          Geocoder geocoder = new Geocoder(context,context.getResources().getConfiguration().locale);
          List<Address> addresses = null;
          LatLng latLng = null;
          try {
              addresses = geocoder.getFromLocationName(city, 1);
              Address address = addresses.get(0);
              latLng = new LatLng(address.getLatitude(), address.getLongitude());
          } catch (Exception e) {
              e.printStackTrace();
          }
          return latLng;
      }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(53, 135);
        LatLng s= getCityLatitude(this,address);
        mMap.addMarker(new MarkerOptions().position(s).title("Marker in Sydney"));
        ////////////////////////////////////////////////////////////////////all is new down there
        mMap.moveCamera(CameraUpdateFactory.newLatLng(s));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

    }
    private void getCurrentLocation() {
        mMap.clear();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }

   }

}
