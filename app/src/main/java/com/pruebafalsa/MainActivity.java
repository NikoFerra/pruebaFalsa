package com.pruebafalsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText feca;
    Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        sp1 = (Spinner) findViewById(R.id.spinner_origen);
        sp2 = (Spinner) findViewById(R.id.spinnerDestino);
        feca = (EditText) findViewById(R.id.cjn_fechasss);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sp1.getSelectedItemPosition()== 0){
                    Toast.makeText(getApplicationContext(), "Debe seleccionar una ciudad de origen",Toast.LENGTH_LONG).show();
                }
                if (sp2.getSelectedItemPosition() == 0) {
                    Toast.makeText(getApplicationContext(),"Debe seleccioar una ciudad de destino", Toast.LENGTH_LONG).show();
                }
                else{
                    String orirg = sp1.getSelectedItem().toString();
                    String dest = sp2.getSelectedItem().toString();
                    String fec = feca.getText().toString();
                    Intent I = new Intent(getApplicationContext(),part2.class);
                    I.putExtra("Orgg", orirg);
                    I.putExtra("destii",dest);
                    I.putExtra("fech", fec);
                    startActivity(I);

                }

            }
        });


    }
}