package com.example.usuario.examenandroid;

/**
 * Created by Jonatan on 26/09/2017.
 */
/**
 * Updated on 27/09/2017
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class EditarDatos extends AppCompatActivity implements View.OnClickListener {
    private Contacto contacto;
    private AlertDialog ventana;
    private List<Contacto> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);
        EditText edtNombre = (EditText) findViewById(R.id.nombre);
        EditText edtEmail = (EditText) findViewById(R.id.email);
        EditText edtEdad = (EditText) findViewById(R.id.edad);
        ArrayList<Contacto> lista = (ArrayList<Contacto>) getIntent().getSerializableExtra("lista");
        Intent intent = getIntent();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnModificar:
                modificarContacto();
                if (contacto != null) {
                    Intent intent = new Intent();
                    intent.putExtra("contacto", contacto);
                    setResult(Activity.RESULT_OK, intent);
                }
                finish();
                break;
            case R.id.btnCancelar:
                if (ventana == null) {
                    ventana = mostrarDialogo();
                }
                ventana.show();
                break;
        }
    }

    public void modificarContacto() {

    }

    public AlertDialog mostrarDialogo() {

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Quieres salir?");
        alerta.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                EditarDatos.this.finish();
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
