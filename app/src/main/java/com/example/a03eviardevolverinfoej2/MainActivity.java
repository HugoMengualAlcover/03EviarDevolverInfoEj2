package com.example.a03eviardevolverinfoej2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherCoche;
    private ActivityResultLauncher<Intent> launcherBici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBotones(View boton){
        if(boton.getId() == R.id.btnAddCocheMain){

        }else if(boton.getId() == R.id.btnAddMotoMain){

        }else if(boton.getId() == R.id.btnAddBiciMain){

        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}