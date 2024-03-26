package com.caneroksuz;

public abstract class Personel {

    private String ad;
    private String soyad;
    private double calismaSaati;

    private double saatlikUcret =500;

    public Personel() {
    }

    public Personel(String ad, String soyad, double calismaSaati, double saatlikUcret) {
        this.ad = ad;
        this.soyad = soyad;
        this.calismaSaati = calismaSaati;
        this.saatlikUcret = saatlikUcret;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public double getCalismaSaati() {
        return calismaSaati;
    }

    public void setCalismaSaati(double calismaSaati) {
        this.calismaSaati = calismaSaati;
    }

    public double getSaatlikUcret() {
        return saatlikUcret;
    }

    public void setSaatlikUcret(double saatlikUcret) {
        this.saatlikUcret = saatlikUcret;
    }

    public abstract double maasHesapla();


    @Override
    public String toString() {
        return "Personel{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", calismaSaati=" + calismaSaati +
                ", saatlikUcret=" + saatlikUcret +
                '}';
    }
}
