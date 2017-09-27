package com.example.usuario.examenandroid;

/**
 * Created by Jonatan on 26/09/2017.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListarContacto extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    ArrayAdapter arrayAdapter;
    private List<Contacto> lista = new ArrayList<>();
    private Contacto contacto;
    private AlertDialog ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contacto);
        listView = (ListView) findViewById(R.id.lstView);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);
        ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("lista");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Click", "click en el evento" + i + "de mi ListView");
                mostrarDialogo();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (ventana == null) {
            ventana = showDialog();
        }
        ventana.show();
    }

    private void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres editar?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(ListarContacto.this, EditarDatos.class);
                        intent.putExtra("contacto", (Serializable)contacto);
                        startActivityForResult(intent, 0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public AlertDialog showDialog() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Quieres salir?");
        alerta.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                ListarContacto.this.finish();
            }
        });
        alerta.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {

            }
        });
        return alerta.create();
    }
}
