package com.example.lab2.controledeabastecimento.model;

public class Abastecimento {

    private String data;
    private int tipoCombustivel;
    private float litro;
    private double precoLitro;
    private String posto;
    private double total;

    public Abastecimento() {
    }

    public Abastecimento(String data, int tipoCombustivel, float litro, double precoLitro, String posto, double total) {
        this.data = data;
        this.tipoCombustivel = tipoCombustivel;
        this.litro = litro;
        this.precoLitro = precoLitro;
        this.posto = posto;
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(int tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getLitro() {
        return litro;
    }

    public void setLitro(float litro) {
        this.litro = litro;
    }

    public double getPrecoLitro() {
        return precoLitro;
    }

    public void setPrecoLitro(double precoLitro) {
        this.precoLitro = precoLitro;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
