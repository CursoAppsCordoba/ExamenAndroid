package com.example.usuario.examenandroid;

/**
 * Created by Jonatan on 26/09/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ListarContacto extends AppCompatActivity implements View.OnClickListener {
    private ListView listView;
    ArrayAdapter arrayAdapter;
    private List<Contacto> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contacto);
        listView = (ListView) findViewById(R.id.lstView);
        ArrayList<String> lista = (ArrayList<String>) getIntent().getSerializableExtra("lista");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view) {
    }
}
