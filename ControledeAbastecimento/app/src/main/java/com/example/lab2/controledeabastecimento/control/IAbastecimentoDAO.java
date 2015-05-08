package com.example.lab2.controledeabastecimento.control;

public interface IAbastecimentoDAO {
    public final String DATABASE_NAME="controleAbastecimento";
    public final int DATABASE_VERSION = 1;
    public final String CREATE_TABLE_ABASTECIMENTO =
            "CREATE TABLE abastecimento(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "data TEXT," +
                    "posto TEXT," +
                    "tipoCombustivel INTEGER," +
                    "litro REAL," +
                    "precoLitro REAL," +
                    "total REAL" +
            ")";
}
