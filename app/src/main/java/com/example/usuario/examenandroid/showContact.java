package com.example.usuario.examenandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class showContact extends AppCompatActivity implements View.OnClickListener{

    private Button atras;
    private Button cerrar;
    private ListView list;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);

        atras=(Button)findViewById(R.id.atras);
        atras.setOnClickListener(this);
        cerrar=(Button)findViewById(R.id.cerrar);
        cerrar.setOnClickListener(this);
        list = (ListView) findViewById(R.id.listView);
        ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("lista");
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        list.setAdapter(adaptador);

    }



    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.atras){

            Intent intent=new Intent(this, MainActivity.class);
            startActivityForResult(intent, 0);

        }else if(view.getId()==R.id.cerrar){

            finish();
        }
    }
}
