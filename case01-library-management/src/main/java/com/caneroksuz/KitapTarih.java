package com.caneroksuz;

public class KitapTarih extends Kitap{
    public KitapTarih(String ISBN, String baslik, String yazar, Durum durum) {
        super(ISBN, baslik, yazar, durum);
    }

    @Override
    public String tur() {
        return "Tarih";
    }
}
