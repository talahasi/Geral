package com.csgamer.han.geral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private Spinner spinner;
    private SeekBar seekBar;
    private CheckBox cbHomem;
    private CheckBox cbMulher;
    private RadioGroup radios;
    private RadioButton rbZe;
    private RadioButton rbAnao;
    private RadioButton rbFunk;
    private RadioButton rbPobre;
    private Button btnExibir;
    private Button btnList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("App Avaliativo");

        edtNome = (EditText)findViewById(R.id.edtNome);
        spinner = (Spinner)findViewById(R.id.spinner);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        cbHomem = (CheckBox)findViewById(R.id.cbHomem);
        cbMulher = (CheckBox)findViewById(R.id.cbMulher);
        radios = (RadioGroup)findViewById(R.id.radios);
        rbZe = (RadioButton)findViewById(R.id.rbZe);
        rbFunk = (RadioButton)findViewById(R.id.rbFunk);
        rbAnao = (RadioButton)findViewById(R.id.rbAnao);
        rbPobre = (RadioButton)findViewById(R.id.rbPobre);
        btnExibir = (Button)findViewById(R.id.btnExibir);
        btnList = (Button)findViewById(R.id.btnList);

        carregaSpinner();
        carregaSeekbar();

        btnExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString();


                if (nome.equals("")) {

                    edtNome.setError("Digite o nome ");
                    return;
                } else {

                    String result = "Nome: " + nome;
                    result += "\nvocê sonha em ser o : " + spinner.getSelectedItem().toString();
                    result += "\nNível de homosexualidade: " + seekBar.getProgress();

                   //CONDIÇÃO PARA HOMEM OU MULHER UTILIZANDO CHECKBOX
                    if (cbHomem.isChecked()){
                        result += "\nVocê Homem ? Para de zueira !";
                    } else{
                        result += "\nMulher ? Com esse bigodão e essa voz de homem ? ";
                    }


                    switch (radios.getCheckedRadioButtonId()) {
                        case R.id.rbZe:
                            result += "\nPertence à familia: Zé droguinha(Catador de novinhas)";
                            break;
                        case R.id.rbPobre:
                            result += "\nPertence à familia: Pobre fudido(Forever fudido)";
                            break;
                        case R.id.rbAnao:
                            result += "Pertence à familia: Anão(Forever zuado)";
                            break;
                        case R.id.rbFunk:
                            result += "Pertence à familia: Funkeiro(Odiado por todos)";
                            break;

                    }
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
    //O USUARIO IRÁ ESCOLHER UM NUMERO E SERÁ EXIBIDO UMA MENSAGEM REFERENTE À ESCOLHA EFETUADA
    private void carregaSeekbar(){
        seekBar.setMax(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "Valor salvo: " + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    //O USUÁRIO IRÁ ESCOLHER UM PERSONAGEM ALEATORIO PARA ESTA ESCOLHA SER CONCATENADA ÀS OUTRAS ESCOLHAS
    private void carregaSpinner() {
        List<String> lista = new ArrayList<>();
        lista.add("Naruto");
        lista.add("Politico Brasileiro");
        lista.add("Rick (Rick & Morty)");
        lista.add("Batman(Morcego chapado)");
        lista.add("Carteiro(O odiado)");
        lista.add("Hackerman");
        lista.add("Moço da T.I");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item
                , lista);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }


}
