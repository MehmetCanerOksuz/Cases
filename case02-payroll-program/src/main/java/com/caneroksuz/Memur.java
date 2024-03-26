package com.caneroksuz;

public class Memur extends Personel{

    private EDerece derece;
    private ERole role;

    public Memur() {
    }

    public Memur(String ad, String soyad, double calismaSaati, double saatlikUcret, EDerece derece) {
        super(ad, soyad, calismaSaati, saatlikUcret);
        this.derece = derece;
        this.role = ERole.MEMUR;
    }



    @Override
    public double maasHesapla() {
        double maas = 0;
        if (derece==EDerece.JUNIOR) {
            if (getCalismaSaati()> 180){
                return 180*getSaatlikUcret() +((getCalismaSaati()-180) * getSaatlikUcret()*1.5 );
            }else {
                return getCalismaSaati()*getSaatlikUcret();
            }
        } else if (derece==EDerece.MID) {
            setSaatlikUcret(getSaatlikUcret()+200);
            if (getCalismaSaati()> 180){
                return 180*getSaatlikUcret() +((getCalismaSaati()-180) * getSaatlikUcret()*1.5 );
            }else {
                return getCalismaSaati()*getSaatlikUcret();
            }
        }else {
            setSaatlikUcret(getSaatlikUcret()+400);
            if (getCalismaSaati()> 180){
                return 180*getSaatlikUcret() +((getCalismaSaati()-180) * getSaatlikUcret()*1.5 );
            }else {
                return getCalismaSaati()*getSaatlikUcret();
            }
        }
    }

    public EDerece getDerece() {
        return derece;
    }

    public void setDerece(EDerece derece) {
        this.derece = derece;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
