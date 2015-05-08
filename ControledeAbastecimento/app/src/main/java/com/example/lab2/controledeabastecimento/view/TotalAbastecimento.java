package com.example.lab2.controledeabastecimento.view;

import android.content.ContentValues;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.lab2.controledeabastecimento.R;
import com.example.lab2.controledeabastecimento.control.AbastecimentoDAO;

import java.util.List;


public class TotalAbastecimento extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_abastecimento);

        montarTabela();

    }

    private void montarTabela(){
        List<ContentValues> totais = new AbastecimentoDAO(this).total();

        if(totais != null){
            if(totais.size() > 0){
                TableLayout tl = (TableLayout) findViewById(R.id.tabelaResultado);


                for (ContentValues cv : totais){
                    TableRow tr = new TableRow(this);

                    TextView col1 = new TextView(this);
                    col1.setText(cv.get("tipoCombustivel").toString());
                    tr.addView(col1);

                    TextView col2 = new TextView(this);
                    col2.setText(cv.get("total").toString());
                    tr.addView(col2);

                    tl.addView(tr);
                }
            }
        }
    }


}
