package com.co.riloti.tappsi_test;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.co.riloti.tappsi_test.models.Booking;
import com.co.riloti.tappsi_test.models.Solicitud;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Positions extends AppCompatActivity {
    public static final String BASE_URL = "https://raw.githubusercontent.com/tappsi/test_recruiting/master/sample_files/";
    private EndointInterface endointInterface;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private boolean isGPSEnabled;
    private boolean isNetworkEnabled;
    private Location myLocation;
    private Location centroide;
    private List<Location> puntos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!isGPSEnabled && !isNetworkEnabled) {
            System.out.println("CURRENT_POSITION: Faliled, no enabled");
        } else {
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    myLocation = location;
                    locationManager.removeUpdates(locationListener);
                    consumirJson();
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
            if (isNetworkEnabled) {

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                } else {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000*60, 5, locationListener);
                }
            }
            if (isGPSEnabled){
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                } else {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000*60, 5, locationListener);
                }
            }
        }


    }

    public void calculateCentroid(Solicitud sol, int code){
        System.out.println("CONSUM_JSON Ok Response: "+code);
        System.out.println("CONSUM_JSON "+sol.toString());

        double sumLat = 0;
        double sumLon = 0;

        puntos = new ArrayList<Location>();

        for (Booking bk : sol.getBookings()){
            Location loc = new Location("Json");
            loc.setLatitude(bk.getLat());
            loc.setLongitude(bk.getLon());
            puntos.add(loc);
        }
        puntos.add(this.myLocation);

        for (Location l : puntos){
            sumLat = sumLat + l.getLatitude();
            sumLon = sumLon + l.getLongitude();
        }

        this.centroide = new Location("Calculate");
        this.centroide.setLongitude(sumLon/puntos.size());
        this.centroide.setLatitude(sumLat/puntos.size());

        this.puntos.add(this.centroide);
    }

    public void consumirJson(){
        System.out.println("CURRENT_POSITION Ok Response= Lat:"+myLocation.getLatitude()+" Lon:"+myLocation.getLongitude());

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        this.endointInterface = retrofit.create(EndointInterface.class);

        Call<Solicitud> call = endointInterface.getDriverInfo();
        call.enqueue(new Callback<Solicitud>() {
            @Override
            public void onResponse(Call<Solicitud> call, Response<Solicitud> response) {
                int responseCode = response.code();
                Solicitud sol = response.body();
                calculateCentroid(sol, responseCode);
            }

            @Override
            public void onFailure(Call<Solicitud> call, Throwable t) {
                System.out.println("CONSUM_JSON Response ERROR Message: "+ t.getMessage());
                System.out.println("CONSUM_JSON Response ERROR StacTrace: "+t.getLocalizedMessage());
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_positions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
