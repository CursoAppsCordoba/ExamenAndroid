package com.example.usuario.examenandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Borrar extends AppCompatActivity implements View.OnClickListener {


    private Button borrar;
    private Button cancelar;
    private EditText name;
    private EditText mail;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        name = (EditText) findViewById(R.id.name2);
        mail = (EditText) findViewById(R.id.Email2);
        age = (EditText) findViewById(R.id.age2);
        borrar = (Button) findViewById(R.id.Borrar);
        borrar.setOnClickListener(this);
        cancelar = (Button) findViewById(R.id.cancelar2);
        cancelar.setOnClickListener(this);


    }

    public void salir() {


        AlertDialog.Builder texto = new AlertDialog.Builder(this);
        texto.setMessage("Estas a punto de salir. ¿Deseas continuar?");
        texto.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Borrar.this.finish();
            }
        });

        texto.setNegativeButton(android.R.string.no, null);
        texto.show();

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Borrar) {
            if (!name.getText().toString().equals("") && !mail.getText().toString().equals("") && !age.getText().toString().equals("")) {

                Intent intent = new Intent();
                Contacto contacto = new Contacto(name.getText().toString(), mail.getText().toString(), Integer.parseInt(age.getText().toString()));

                intent.putExtra("contacto", contacto);




                setResult(Activity.RESULT_OK, intent);
                finish();

            } else {

                Toast.makeText(this, "Rellene los campos", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId() == R.id.cancelar2) {

            salir();

        }
    }
}