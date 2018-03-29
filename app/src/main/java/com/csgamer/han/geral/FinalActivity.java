package com.csgamer.han.geral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        setTitle("Aplicativo Avaliativo: Final");

        Bundle b = getIntent().getExtras();
        if (b != null) {
            Toast.makeText(FinalActivity.this, b.getString("exibir"), Toast.LENGTH_LONG).show();
        }
        }

    }
