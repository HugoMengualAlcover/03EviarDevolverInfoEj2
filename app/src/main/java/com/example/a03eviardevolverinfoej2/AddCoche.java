package com.example.a03eviardevolverinfoej2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a03eviardevolverinfoej2.modelos.Bici;
import com.example.a03eviardevolverinfoej2.modelos.Coche;

public class AddCoche extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coche);
        inicializaVistas();
    }

    public void onClick(View boton){
        if(boton.getId() == R.id.btnCrearCOCHE){

            String marca = txtMarca.toString();
            String modelo = txtModelo.toString();
            String color = txtColor.toString();

            if(!marca.isEmpty() && !modelo.isEmpty() && color.isEmpty()) {

                Coche coche = new Coche(marca, modelo, color);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("COCHE", coche);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }

        }else if(boton.getId() == R.id.btnCancelarCoche){
            setResult(RESULT_CANCELED);
            finish();
        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    private void inicializaVistas(){
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);

    }

}