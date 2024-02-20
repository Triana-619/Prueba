package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView edad2, peso2, altura2, estadoNutricional;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        edad2 = findViewById(R.id.lbledad2);
        peso2 = findViewById(R.id.lblpeso2);
        altura2 = findViewById(R.id.lblaltura2);
        estadoNutricional = findViewById(R.id.lblestadoNutricional);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String infoedad = extras.getString("passedad");
            edad2.setText(infoedad);

            String infopeso = extras.getString("passpeso");
            peso2.setText(infopeso);

            String infoaltura = extras.getString("passaltura");
            altura2.setText(infoaltura);

            double peso = Double.parseDouble(infopeso);
            double altura = Double.parseDouble(infoaltura);
            double imc = peso / (altura * altura);

            String estado = "";
            if (imc < 18.5) {
                estado = "Desnutrición";
            } else if (imc >= 18.5 && imc < 25) {
                estado = "Normal";
            } else {
                estado = "Sobrepeso";
            }

            estadoNutricional.setText(estado);
        }
    }
}