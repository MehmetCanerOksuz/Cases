package com.caneroksuz;

public abstract class Kitap {

    private String ISBN;
    private String baslik;
    private String yazar;
    private Durum durum;

    public Kitap(String ISBN, String baslik, String yazar, Durum durum) {
        this.ISBN = ISBN;
        this.baslik = baslik;
        this.yazar = yazar;
        this.durum = durum;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public Durum getDurum() {
        return durum;
    }

    public void setDurum(Durum durum) {
        this.durum = durum;
    }

    public abstract String tur();

    @Override
    public String toString() {
        return "Kitap{" +
                "ISBN='" + ISBN + '\'' +
                ", baslik='" + baslik + '\'' +
                ", yazar='" + yazar + '\'' +
                ", durum=" + durum +
                '}';
    }
}
