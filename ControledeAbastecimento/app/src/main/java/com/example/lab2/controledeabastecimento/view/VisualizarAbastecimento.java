package com.example.lab2.controledeabastecimento.view;

import android.content.ContentValues;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.lab2.controledeabastecimento.R;
import com.example.lab2.controledeabastecimento.control.AbastecimentoDAO;

import java.util.List;


public class VisualizarAbastecimento extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_abastecimento);

        List<ContentValues> abastecimentos = new AbastecimentoDAO(this).listar();

        if(abastecimentos != null){
            if(abastecimentos.size() > 0){
                TableLayout tl = (TableLayout) findViewById(R.id.tabelaResultado);
                //tl.removeAllViews();

                for (ContentValues cv : abastecimentos){
                    TableRow tr = new TableRow(this);

                    TextView col1 = new TextView(this);
                    col1.setText(cv.get("posto").toString());
                    tr.addView(col1);

                    TextView col2 = new TextView(this);
                    col2.setText(cv.get("data").toString());
                    tr.addView(col2);

                    TextView col3 = new TextView(this);
                    col3.setText(cv.get("tipoCombustivel").toString());
                    tr.addView(col3);

                    TextView col4 = new TextView(this);
                    col4.setText(cv.get("total").toString());
                    tr.addView(col4);

                    tl.addView(tr);
                }
            }
        }

    }
}
