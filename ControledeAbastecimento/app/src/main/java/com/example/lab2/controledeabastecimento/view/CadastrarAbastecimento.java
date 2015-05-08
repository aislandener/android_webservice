package com.example.lab2.controledeabastecimento.view;

import android.content.ContentValues;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab2.controledeabastecimento.R;
import com.example.lab2.controledeabastecimento.control.AbastecimentoDAO;

import java.util.Date;
import java.text.SimpleDateFormat;


public class CadastrarAbastecimento extends ActionBarActivity  implements View.OnClickListener,View.OnFocusChangeListener{
    private Button btnSalvar;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_abastecimento);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        EditText edtData = (EditText) findViewById(R.id.edtData);
        edtData.setText(pegaData());

        EditText edtPrecoLitro = (EditText) findViewById(R.id.edtPrecoLitro);
        edtPrecoLitro.setOnFocusChangeListener(this);

        btnSalvar.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);
    }



    protected void calcular(){
        EditText edtLitro = (EditText) findViewById(R.id.edtLitro);
        EditText edtPrecoLitro = (EditText) findViewById(R.id.edtPrecoLitro);
        EditText edtTotal = (EditText) findViewById(R.id.edtTotal);
        float litro;
        double preco,total;

        litro = Float.parseFloat(edtLitro.getText().toString());
        preco = Double.parseDouble(edtPrecoLitro.getText().toString());
        total = litro*preco;
        edtTotal.setText(Float.toString((float) total));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSalvar:
                EditText edtData = (EditText) findViewById(R.id.edtData);
                edtData.setText(pegaData());
                Spinner selectCombustivel = (Spinner) findViewById(R.id.selectCombustivel);
                EditText edtPosto = (EditText) findViewById(R.id.edtPosto);
                EditText edtLitro = (EditText) findViewById(R.id.edtLitro);
                EditText edtPrecoLitro = (EditText) findViewById(R.id.edtPrecoLitro);
                EditText edtTotal = (EditText) findViewById(R.id.edtTotal);

                ContentValues cv = new ContentValues();
                cv.put("data", edtData.getText().toString());
                cv.put("posto", edtPosto.getText().toString());
                cv.put("tipoCombustivel", selectCombustivel.getSelectedItemId());
                cv.put("precoLitro", edtPrecoLitro.getText().toString());
                cv.put("litro", edtLitro.getText().toString());
                cv.put("total", edtTotal.getText().toString());

                String msg = "";
                long id = new AbastecimentoDAO(this).inserir(cv);

                if (id > 0) {
                    msg = "Registro " + id + " inserido com sucesso.";
                    edtData.setText("");
                    edtPosto.setText("");
                    edtLitro.setText("");
                    edtPrecoLitro.setText("");
                    edtTotal.setText("");
                    selectCombustivel.setSelection(0);
                } else {
                    msg = "Ocorreu um erro durante a operação.";
                }

                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                break;

            case R.id.btnVoltar:
                super.onBackPressed();
                break;
        }
    }
    protected String pegaData(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        return formato.format(data);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus){
                calcular();
        }
    }
}
