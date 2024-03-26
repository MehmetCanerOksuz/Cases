package com.caneroksuz;

public class Yonetici extends Personel{

    private double bonus;
    private ERole role;

    public Yonetici() {
    }

    public Yonetici(String ad, String soyad, double calismaSaati, double saatlikUcret, double bonus) {
        super(ad, soyad, calismaSaati, saatlikUcret);
        this.bonus = bonus;
        this.role = ERole.YONETICI;

    }

    @Override
    public double maasHesapla() {
        if (getSaatlikUcret()<500){
            setSaatlikUcret(500);
        }
        return getSaatlikUcret()*getCalismaSaati() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
