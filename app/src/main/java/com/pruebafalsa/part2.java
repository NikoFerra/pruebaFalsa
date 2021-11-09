package com.pruebafalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class part2 extends AppCompatActivity {
    TextView a1,a2,a3,l1,l2;
    Button bt1;
    String origen,destino,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        a1 = (TextView) findViewById(R.id.cjnOrigen);
        a2 = (TextView) findViewById(R.id.cjnDestino);
        a3 = (TextView) findViewById(R.id.cjnFecha);
        l1 = (TextView) findViewById(R.id.cjnLatitud);
        l2 = (TextView) findViewById(R.id.cjn_longitud);
        bt1 =(Button) findViewById(R.id.btn_tax);

        Bundle B = getIntent().getExtras();
        origen = B.getString("Orgg");
        destino = B.getString("destii");
        fecha = B.getString("fech");
        Double latitud = B.getDouble("lati");
        Double longitud = B.getDouble("long");

        a1.setText(origen);
        a2.setText(destino);
        a3.setText(fecha);
        l1.setText(""+latitud);
        l2.setText(""+longitud);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),part3.class);
                I.putExtra("Orgg",origen);
                I.putExtra("destii",destino);
                I.putExtra("fech",fecha);
                startActivity(I);
            }
        });

    }
}