package com.example.jaz_s28413_nbp.jaz_s28413_nbp;

import java.time.LocalDate;

public class GoldPrice {
    public LocalDate data;
    public Double cena;


    public GoldPrice() {

    }
    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
