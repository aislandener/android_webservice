package com.example.lab2.controledeabastecimento.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lab2.controledeabastecimento.R;
import com.example.lab2.controledeabastecimento.model.Abastecimento;

import java.util.ArrayList;
import java.util.List;

public class AbastecimentoDAO extends SQLiteOpenHelper {

    Context context;

    public AbastecimentoDAO(Context context){
        super(context, IAbastecimentoDAO.DATABASE_NAME,null,IAbastecimentoDAO.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IAbastecimentoDAO.CREATE_TABLE_ABASTECIMENTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS abastecimento");
        onCreate(db);
    }

    public long inserir(ContentValues cv) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert("abastecimento", null, cv);
    }

    public List<ContentValues> listar() {
        List<ContentValues> resultado = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM abastecimento";
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            String[] tipoCombustivelString = context.getResources().getStringArray(R.array.tipo_combustivel_lista);
            do {
                ContentValues cv = new ContentValues();
                cv.put("data", c.getString(c.getColumnIndex("data")));
                cv.put("posto", c.getString(c.getColumnIndex("posto")));
                cv.put("tipoCombustivel", tipoCombustivelString[c.getInt(c.getColumnIndex("tipoCombustivel"))]);
                cv.put("total",c.getDouble(c.getColumnIndex("total")));
                resultado.add(cv);
            } while (c.moveToNext());
        }
        return resultado;
    }

    public List<ContentValues> total(){
        List<ContentValues> resultado = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT tipoCombustivel , SUM(total)  FROM abastecimento GROUP BY tipoCombustivel";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
                String[] tipoCombustivelString = context.getResources().getStringArray(R.array.tipo_combustivel_lista);
            do {
                ContentValues cv = new ContentValues();
                cv.put("total",c.getDouble(c.getColumnIndex("SUM(total)")));
                cv.put("tipoCombustivel",tipoCombustivelString[c.getInt(c.getColumnIndex("tipoCombustivel"))]);
                resultado.add(cv);
            }while (c.moveToNext());
        }
        return resultado;
    }


}
