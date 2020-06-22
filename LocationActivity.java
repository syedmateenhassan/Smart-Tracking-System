package com.example.sts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sts.model.Locate;
import com.example.sts.model.User;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.snapshot.DoubleNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener {

    GoogleMap mMap;
    GoogleApiClient gAC;
    LocationRequest lR;
    Location lastLoacation;
    private DatabaseReference database;
    Marker currentUserLocationMarker;
    FirebaseAuth firebaseAuth;
    Locate loc;
    private static final int REQUEST_CODE = 99;
    private double latitude, longitude, aLx, aLy;
    EditText eT;
    String address;
    List<String> tim;
    viewlocations datav;
    List<String> localist;
    UserLogInActivity id;
        LoadingLocationActivity data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        firebaseAuth = FirebaseAuth.getInstance();
        tim = new ArrayList<>();
        localist= new ArrayList<>();
            Log.i("longi",datav.longi);
//        Log.i("sss",""+data.iid);
//        Log.i("see",""+data.name);
        database = FirebaseDatabase.getInstance().getReference();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkUserLocationPermission();
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        database.child("LOCATION").child(data.iid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());


                for (DataSnapshot data : snapshot.getChildren()){
                    localist.add(data.getValue().toString());



                }

                Log.i("www",""+localist);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });



    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        lR=new LocationRequest();
        lR.setInterval(1100);
        lR.setFastestInterval(1100);
        lR.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(gAC,lR,this);
            //LocationServices.FusedLocationApi.requestLocationUpdates(gAC,lR,this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
            latitude =location.getLatitude();
            longitude=location.getLongitude();

            lastLoacation=location;

            if(currentUserLocationMarker !=null)
            {
                currentUserLocationMarker.remove();
            }

            LatLng latLng =new LatLng(location.getLatitude(),location.getLongitude());

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("YOU ARE HERE");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
            currentUserLocationMarker=mMap.addMarker(markerOptions);

            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomBy(14f));

            if(gAC !=null)
            {
                LocationServices.FusedLocationApi.removeLocationUpdates(gAC,this);
                //            LocationServices.FusedLocationApi.removeLocationUpdates(gAC,this);
            }


        }

    @Override
    public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            boolean success = googleMap.setMapStyle( MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style));
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED) {

                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);

            }

    }


    public void gsm(Double x, Double y)
    {
        LatLng WahCantt = new LatLng(x,y);
        mMap.addMarker(new MarkerOptions().position(WahCantt).title("Employee at this location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WahCantt,24f));
    }

   /*
    public void gsm(double Lx,Double Ly)
    {
        LatLng WahCantt = new LatLng(Lx,Ly);
        mMap.addMarker(new MarkerOptions().position(WahCantt).title("Employee at this location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WahCantt,24f));
    }

    public void EmLocation(View xy)
    {
        final DatabaseReference DBref = FirebaseDatabase.getInstance().getReference("USERS");
        DBref.child("0016321").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String n = String.valueOf(dataSnapshot.child("Username").getValue());
                String m = String.valueOf(dataSnapshot.child("Password").getValue());
                aLx = Double.valueOf(n);
                aLy = Double.valueOf(m);
                gsm(aLx,aLy);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.",
            }
        });

    }

    */

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

   /* public void schButton(View kuchBhi)
    {
        eT = (EditText)findViewById(R.id.Search_locationL);
        address =eT.getText().toString();
        List <Address> addressList= null;
        MarkerOptions userMarkerOptions= new MarkerOptions();
        if(!TextUtils.isEmpty(address))
        {
            Geocoder gC = new Geocoder(this);
            try {
                addressList = gC.getFromLocationName(address,5);

                if(addressList !=null)
                {
                    for(int i = 0; i <addressList.size(); i++)
                    {
                        Address userAddress = addressList.get(i);
                        LatLng latLng =new LatLng(userAddress.getLatitude(),userAddress.getLongitude());
                        userMarkerOptions.position(latLng);
                        userMarkerOptions.title(address);
                        userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                        mMap.addMarker(userMarkerOptions);
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(15f));
                    }
                }
                else
                {
                    Toast.makeText(this,"Location Not Found",Toast.LENGTH_SHORT).show();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            Toast.makeText(this,"Please Write Any Address",Toast.LENGTH_SHORT).show();
        }
    }
*/
    public boolean checkUserLocationPermission() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);

            }
            return false;
        }
        else {
            return true;
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED)
                {
                    if( ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        if (gAC==null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else
                {
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    protected synchronized void buildGoogleApiClient(){
        gAC=new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        gAC.connect();
    }


}

