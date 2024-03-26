package com.caneroksuz;

import java.util.ArrayList;
import java.util.List;

public class Uye implements IUye{

    private String isimSoyisim;
    private List<Kitap> oduncAlinanKitaplar;

    public Uye(String isimSoyisim){
        this.isimSoyisim = isimSoyisim;
        this.oduncAlinanKitaplar = new ArrayList<>();
    }

    public String getIsimSoyisim() {
        return isimSoyisim;
    }

    public void setIsimSoyisim(String isimSoyisim) {
        this.isimSoyisim = isimSoyisim;
    }

    public List<Kitap> getOduncAlinanKitaplar() {
        return oduncAlinanKitaplar;
    }

    public void setOduncAlinanKitaplar(List<Kitap> oduncAlinanKitaplar) {
        this.oduncAlinanKitaplar = oduncAlinanKitaplar;
    }

    @Override
    public void kitapOduncAl(Kitap kitap) {
        if (kitap.getDurum() == Durum.MEVCUT){
            kitap.setDurum(Durum.ODUNC_ALINMIS);
            oduncAlinanKitaplar.add(kitap);
            System.out.println(kitap.getBaslik() + " isimli kitabı ödünç aldınız.");
        } else if (kitap.getDurum() == Durum.MEVCUT_DEGIL) {
            System.out.println("Kitap mevcut değil.");
        }else {
            System.out.println("Kitap başka üye tarafından ödünç alınmış.");
        }
    }

    @Override
    public void kitapIadeEt(Kitap kitap) {
        if (oduncAlinanKitaplar.contains(kitap)){
            kitap.setDurum(Durum.MEVCUT);
            oduncAlinanKitaplar.remove(kitap);
            System.out.println(kitap.getBaslik() + " adlı kitabı iade ettiniz.");
        }else {
            System.out.println("Ödünç aldığınız kitaplar listesinde böyle bir kitap bulunmamaktadır.");
        }

    }

    @Override
    public void oduncAlinanKitaplariGoruntule() {
        if (oduncAlinanKitaplar.isEmpty()){
            System.out.println(isimSoyisim + "'nın ödünç kitabı bulunmamaktadır.");
        }else {
            System.out.println(isimSoyisim + "'nın ödünç aldığı kitaplar : ");
            for (Kitap kitap : oduncAlinanKitaplar){
                System.out.println(kitap);
            }
        }

    }
}
