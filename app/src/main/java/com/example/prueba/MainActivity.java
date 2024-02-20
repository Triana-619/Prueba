package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edad, peso, altura;
    Button calcular;

    TextView panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        edad = findViewById(R.id.txtedad);
        peso = findViewById(R.id.txtpeso);
        altura = findViewById(R.id.txtaltura1);
        calcular = (Button) findViewById(R.id.btncalcular);
        panel = (TextView) findViewById(R.id.lblpanel);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("passedad", edad.getText().toString());
                bundle.putString("passpeso", peso.getText().toString());
                bundle.putString("passaltura", altura.getText().toString());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    protected void onStop() {
        super.onStop();
        panel.setText("Usted visitó la pantalla 2");
    }
}