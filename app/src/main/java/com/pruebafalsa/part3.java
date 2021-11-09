package com.pruebafalsa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pruebafalsa.databinding.ActivityMapaBinding;

public class part3 extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private ActivityMapaBinding binding;

    TextView cjn1, cjn2;
    Button btn1;
    String origen, destino, fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        cjn1 = (TextView) findViewById(R.id.cjn_latitud);
        cjn2 = (TextView) findViewById(R.id.cjn_lon);
        btn1 = (Button) findViewById(R.id.btn_volver);

        Bundle s = getIntent().getExtras();
        origen = s.getString("Orgg");
        destino = s.getString("destii");
        fecha = s.getString("fech");


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double lat = Double.parseDouble(cjn1.getText().toString());
                double lon = Double.parseDouble(cjn2.getText().toString());

                LatLng Posicion = new LatLng(lat,lon);
                mMap.moveCamera((CameraUpdateFactory.newLatLng(Posicion)) );

                Intent I=  new Intent(getApplicationContext(),part2.class);
                I.putExtra("Orgg",origen);
                I.putExtra("destii",destino);
                I.putExtra("fech",fecha);
                I.putExtra("lati",lat);
                I.putExtra("long",lon);
                startActivity(I);

            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                cjn1.setText(latLng.latitude + "");
                cjn2.setText(latLng.longitude + "");
            }
        });
    }
}
