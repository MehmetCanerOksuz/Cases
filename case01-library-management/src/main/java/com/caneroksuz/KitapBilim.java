package com.caneroksuz;

public class KitapBilim extends Kitap{
    public KitapBilim(String ISBN, String baslik, String yazar, Durum durum) {
        super(ISBN, baslik, yazar, durum);
    }

    @Override
    public String tur() {
        return "Bilim";
    }
}
