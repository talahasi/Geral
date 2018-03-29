package com.csgamer.han.geral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setTitle("Lista");

        listView = (ListView)findViewById(R.id.listView);

        carregaListView();
    }

    private void carregaListView (){
        final String[] values = new String[]{
            "Goku",
                "Vegeta",
                "Beerus",
                "Jiren",
                "Toppo",
                "Freeza",
                "Gohan",
                "Daishinkan",
                "Eu"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_2,
                android.R.id.text2,values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String texto = listView.getItemAtPosition(position).toString();
                Intent intent = new Intent(ListActivity.this, FinalActivity.class);

                //UTILIZAR O PUT AQUI PARA EXIBIR O TEXTO NA PROXIMA ACTIVITY

                intent.putExtra("exibir", "Selecionado: " + texto);

                startActivity(intent);
            }
        });
    }
}
