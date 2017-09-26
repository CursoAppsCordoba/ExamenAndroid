package com.example.usuario.examenandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button guardar;
    private Button mostrar;
    private Button cerrar;
    private Button borrar;


    public static final int Alta=100;
    public static final int Baja=200;
    public static final int Listar=300;


    ArrayList<Contacto> contactos=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guardar=(Button)findViewById(R.id.save);
        guardar.setOnClickListener(this);
        mostrar=(Button)findViewById(R.id.Show);
        mostrar.setOnClickListener(this);
        cerrar=(Button)findViewById(R.id.close);
        cerrar.setOnClickListener(this);
        borrar=(Button)findViewById(R.id.delete);
        borrar.setOnClickListener(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(Alta==requestCode){
            if(resultCode== Activity.RESULT_OK){
                if(data.hasExtra("contacto")){
                    Contacto contacto=data.getParcelableExtra("contacto");
                    contactos.add((Contacto)data.getParcelableExtra("contacto"));
                    Toast.makeText(this, "El contacto " + contacto.getNombre() + " se ha guardado", Toast.LENGTH_SHORT).show();
                }

            }

        }else if(Baja==requestCode){
            if(resultCode== Activity.RESULT_OK){
                if(data.hasExtra("contacto")){
                    Contacto contacto=data.getParcelableExtra("contacto");
                    if(  contactos.remove(data.getParcelableExtra("contacto")))
                    {
                        Toast.makeText(this, "El contacto " + contacto.getNombre() + " se ha borrado", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "El contacto " + contacto.getNombre() + " no existe y no puede eliminarse", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.save){

            Intent intent=new Intent(this, Alta.class);
            startActivityForResult(intent, Alta);

        }else if(view.getId()==R.id.Show) {

            Intent intent = new Intent(this, showContact.class);
            intent.putExtra("lista", contactos);
            startActivityForResult(intent, Listar);

        }else if(view.getId()==R.id.delete){
            Intent intent=new Intent(this, Borrar.class);
            startActivityForResult(intent, Baja);


        }else if(view.getId()==R.id.close){

            finish();
        }

    }
}
