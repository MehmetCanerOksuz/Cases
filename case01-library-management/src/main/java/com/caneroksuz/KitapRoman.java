package com.caneroksuz;

public class KitapRoman extends Kitap{
    public KitapRoman(String ISBN, String baslik, String yazar, Durum durum) {
        super(ISBN, baslik, yazar, durum);
    }

    @Override
    public String tur() {
        return "Roman";
    }
}
