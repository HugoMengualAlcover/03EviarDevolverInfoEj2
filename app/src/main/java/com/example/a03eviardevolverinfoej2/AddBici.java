package com.example.a03eviardevolverinfoej2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03eviardevolverinfoej2.modelos.Bici;
import com.example.a03eviardevolverinfoej2.modelos.Coche;

public class AddBici extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtPulgadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bici);

        inicializarVistas();
    }


    public void onClick(View boton){
        if(boton.getId() == R.id.btnCrearBici) {

            String marca = txtMarca.toString();
            String pulgadas = txtPulgadas.toString();


            if (!marca.isEmpty() && !pulgadas.isEmpty()) {

                Bici bici = new Bici(marca, pulgadas);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("BICI", bici);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            } else if (boton.getId() == R.id.btncancelarBici) {
                setResult(RESULT_CANCELED);
                finish();
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void inicializarVistas() {
        txtMarca = findViewById(R.id.txtMarcaBici);
        txtPulgadas = findViewById(R.id.txtPulgadasBici);
    }
}