package com.example.a03eviardevolverinfoej2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a03eviardevolverinfoej2.modelos.Coche;
import com.example.a03eviardevolverinfoej2.modelos.Moto;

public class AddMoto extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_moto);
        inicializaVistas();
    }


    public void onClick(View boton){
        if(boton.getId() == R.id.btnCrearMoto) {

            String marca = txtMarca.toString();
            String modelo = txtModelo.toString();
            String cc = txtCC.toString();

            if (!marca.isEmpty() && !modelo.isEmpty() && cc.isEmpty()) {

                Moto moto = new Moto(marca, modelo, cc);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("MOTO", moto);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            } else if (boton.getId() == R.id.btnCrearMoto) {
                setResult(RESULT_CANCELED);
                finish();
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void inicializaVistas(){
        txtMarca = findViewById(R.id.txtMarcaMoto);
        txtModelo = findViewById(R.id.txtModelomoto);
        txtCC = findViewById(R.id.txtCc);

    }
}