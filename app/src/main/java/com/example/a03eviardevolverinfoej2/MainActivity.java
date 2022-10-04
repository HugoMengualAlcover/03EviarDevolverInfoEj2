package com.example.a03eviardevolverinfoej2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03eviardevolverinfoej2.modelos.Bici;
import com.example.a03eviardevolverinfoej2.modelos.Coche;
import com.example.a03eviardevolverinfoej2.modelos.Moto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtCoches;
    private TextView txtMotos;
    private TextView txtBicis;

    private ArrayList<Moto> motos;
    private ArrayList<Coche> coches;
    private ArrayList<Bici> bicis;

    private ActivityResultLauncher<Intent> launcherMoto;
    private ActivityResultLauncher<Intent> launcherCoche;
    private ActivityResultLauncher<Intent> launcherBici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();
        inicializaLaunchers();
    }


    public void onClickBotones(View boton){
        if(boton.getId() == R.id.btnAddCocheMain){
            Intent intent = new Intent(MainActivity.this, AddCoche.class);
            launcherCoche.launch(intent);
        }else if(boton.getId() == R.id.btnAddMotoMain){
            Intent intent = new Intent(MainActivity.this, AddMoto.class);
            launcherMoto.launch(intent);
        }else if(boton.getId() == R.id.btnAddBiciMain){
            Intent intent = new Intent(MainActivity.this, AddBici.class);
            launcherBici.launch(intent);
        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializaLaunchers(){
        launcherCoche = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if(result.getData() != null && result.getData().getExtras() != null){
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");
                                coches.add(coche);
                                txtCoches.setText("Coches: "+coches.size());

                            }
                        }else{
                            Toast.makeText(MainActivity.this,"ACCION CANCELADA", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        launcherBici = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if(result.getData() != null && result.getData().getExtras() != null){
                                Bici bici = (Bici) result.getData().getExtras().getSerializable("BICI");
                                bicis.add(bici);
                                txtBicis.setText("Bicis: "+bicis.size());
                            }
                        }else{
                            Toast.makeText(MainActivity.this,"ACCION CANCELADA", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        launcherMoto = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if(result.getData() != null && result.getData().getExtras() != null){
                                Moto moto = (Moto) result.getData().getExtras().getSerializable("MOTO");
                                motos.add(moto);
                                txtMotos.setText("MOtos: "+motos.size());
                            }
                        }else{
                            Toast.makeText(MainActivity.this,"ACCION CANCELADA", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void inicializaVistas() {
        txtBicis = findViewById(R.id.lblBicisMain);
        txtCoches = findViewById(R.id.lblCochesMain);
        txtMotos = findViewById(R.id.lblMotosMain);

        coches = new ArrayList<Coche>();
        motos = new ArrayList<Moto>();
        bicis = new ArrayList<Bici>();

    }
}