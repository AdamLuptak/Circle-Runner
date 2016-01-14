package com.example.aluptak.circle_runner;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private static final String TAG = "MainActivity";
    private LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                3000, 5, this);
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        Location location = locationManager.getLastKnownLocation(locationProvider);


        String msg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();
        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setText("New Latitude: " + location.getLatitude());
        tx = (TextView) findViewById(R.id.textView2);
        tx.setText("New Longitude: " + location.getLongitude());

    }

    @Override
    public void onLocationChanged(Location location) {
        String msg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();
        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setText("New Latitude: " + location.getLatitude());
        tx = (TextView) findViewById(R.id.textView2);
        tx.setText("New Longitude: " + location.getLongitude());
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void getLocation(View view) {
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        Location location = locationManager.getLastKnownLocation(locationProvider);
        Log.i(TAG, "si klikol");

        String msg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();
        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setText("New Latitude: " + location.getLatitude());
        tx = (TextView) findViewById(R.id.textView2);
        tx.setText("New Longitude: " + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Toast.makeText(getBaseContext(), "Gps is turned off!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getBaseContext(), "Gps is turned on!! ",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
