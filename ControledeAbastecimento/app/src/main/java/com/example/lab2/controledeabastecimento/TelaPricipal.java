package com.example.lab2.controledeabastecimento;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab2.controledeabastecimento.view.CadastrarAbastecimento;
import com.example.lab2.controledeabastecimento.view.TotalAbastecimento;
import com.example.lab2.controledeabastecimento.view.VisualizarAbastecimento;


public class TelaPricipal extends ActionBarActivity implements View.OnClickListener{

    private Button btnCadastrar;
    private Button btnVisualizar;
    private Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pricipal);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnVisualizar = (Button) findViewById(R.id.btnVisualizar);
        btnTotal = (Button) findViewById(R.id.btnTotal);

        btnCadastrar.setOnClickListener(this);
        btnVisualizar.setOnClickListener(this);
        btnTotal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent it = null;

        if(v.getId() == R.id.btnCadastrar){

            it = new Intent(TelaPricipal.this, CadastrarAbastecimento.class);

        }else if(v.getId() == R.id.btnVisualizar){

            it = new Intent(TelaPricipal.this, VisualizarAbastecimento.class);

        }else if(v.getId() == R.id.btnTotal){

            it = new Intent(TelaPricipal.this, TotalAbastecimento.class);

        }
        startActivity(it);
    }

}
