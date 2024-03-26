package com.caneroksuz;

import java.util.ArrayList;
import java.util.List;

public class Kutuphane {

    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();
    }

    public List<Kitap> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(List<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }

    public List<Uye> getUyeler() {
        return uyeler;
    }

    public void setUyeler(List<Uye> uyeler) {
        this.uyeler = uyeler;
    }

    public void kitapEkle(Kitap kitap){
        kitaplar.add(kitap);
    }

    public void uyeEkle(Uye uye){
        uyeler.add(uye);
    }

    public void katalogGoruntule(){
        System.out.println("Kütüphane Kataloğu : ");
        for (Kitap kitap : kitaplar){
            System.out.println(kitap.getBaslik() + " : " + kitap.getYazar() + " : " +
                    kitap.tur() + " : " + "Durumu : " + kitap.getDurum());
        }
    }

    public void uyeleriGoruntule(){
        System.out.println("Kütüphane Üyeleri : ");
        for (Uye uye : uyeler){
            System.out.println(uye.getIsimSoyisim());
        }
    }
}
