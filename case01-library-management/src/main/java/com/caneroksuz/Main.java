package com.caneroksuz;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kütüphane Otomasyon Sistemi");

        Kutuphane kutuphane = new Kutuphane();

        Kitap kitap1 = new KitapTarih("ASD12312312","Tarih Kitabı","Yazar2",Durum.MEVCUT);
        Kitap kitap2 = new KitapBilim("ASD54363423","Bilim Kitabı","Yazar2",Durum.MEVCUT);
        Kitap kitap3 = new KitapRoman("ASD85635432","Roman Kitabı","Yazar2",Durum.MEVCUT);

        Uye uye1 = new Uye("Caner Öksüz");
        Uye uye2 = new Uye("Mehmet Öksüz");

        kutuphane.kitapEkle(kitap1);
        kutuphane.kitapEkle(kitap2);
        kutuphane.kitapEkle(kitap3);

        kutuphane.uyeEkle(uye1);
        kutuphane.uyeEkle(uye2);

        uye1.oduncAlinanKitaplariGoruntule();
        uye2.oduncAlinanKitaplariGoruntule();

        kutuphane.uyeleriGoruntule();
        kutuphane.katalogGoruntule();

        uye1.kitapOduncAl(kitap1);
        uye2.kitapOduncAl(kitap1);
        uye2.kitapOduncAl(kitap2);
        uye1.kitapIadeEt(kitap1);
        uye2.kitapOduncAl(kitap1);

        uye1.oduncAlinanKitaplariGoruntule();
        uye2.oduncAlinanKitaplariGoruntule();
    }
}