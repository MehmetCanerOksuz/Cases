package com.caneroksuz;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DosyaOku {

    public static void dosyaOku (){
        try {

            InputStream inputStream = DosyaOku.class.getClassLoader().getResourceAsStream("personel.json");

            if (inputStream != null) {

                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder jsonBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
                String jsonString = jsonBuilder.toString();

                JSONParser parser = new JSONParser();
                JSONArray personelListesi = (JSONArray) parser.parse(jsonString);

                List<Personel> personeller = new ArrayList<>();

                Scanner scanner = new Scanner(System.in);

                for (Object obj : personelListesi) {
                    JSONObject personelJSON = (JSONObject) obj;
                    String ad = (String) personelJSON.get("name");
                    String soyad = (String) personelJSON.get("surname");
                    String role = (String) personelJSON.get("role");
                    String derece = (String) personelJSON.get("derece");
                    Personel personel;
                    if ("YONETICI".equals(role)){
                        System.out.println(role);
                        Yonetici yonetici = new Yonetici();
                        yonetici.setAd(ad);
                        yonetici.setSoyad(soyad);
                        yonetici.setRole(ERole.valueOf(role));
                        personel = yonetici;
                    } else {
                        System.out.println(role);
                        Memur memur = new Memur();
                        memur.setAd(ad);
                        memur.setSoyad(soyad);
                        memur.setRole(ERole.valueOf(role));
                        memur.setDerece(EDerece.valueOf(derece));
                        personel = memur;
                    }

                    System.out.println("Lütfen " + ad + " " + soyad + " için çalışma saati giriniz:");
                    int calismaSaati = scanner.nextInt();

                    personel.setCalismaSaati(calismaSaati);
                    double toplamOdeme = personel.maasHesapla();

                    double anaOdeme;
                    double mesaiUcreti;
                    if (calismaSaati>180){
                        anaOdeme = personel.getSaatlikUcret()*180;
                        mesaiUcreti = toplamOdeme-anaOdeme;
                    }else {
                        anaOdeme = personel.getSaatlikUcret()*personel.getCalismaSaati();
                        mesaiUcreti =0;
                    }

                    JSONObject bordro = new JSONObject();
                    bordro.put("bordro", LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM yyyy")));

                    JSONObject personelDetay = new JSONObject();
                    personelDetay.put("ismi", ad);
                    personelDetay.put("calismaSaati", calismaSaati);

                    JSONObject odemeDetaylari = new JSONObject();

                    odemeDetaylari.put("anaOdeme", "TL" + String.format("%.1f", anaOdeme));
                    odemeDetaylari.put("mesai", "TL" + String.format("%.1f", mesaiUcreti));
                    odemeDetaylari.put("toplamOdeme", "TL" + String.format("%.1f", toplamOdeme));
                    personelDetay.put("odemeDetaylari", odemeDetaylari);

                    bordro.put("personel", personelDetay);

                    String klasorAdi = ad + "_" + soyad + "_bordrolar";
                    File klasor = new File(klasorAdi);
                    klasor.mkdirs();

                    try (FileWriter file = new FileWriter(klasorAdi + "/" + ad + "_" + soyad + "_bordro.json")) {
                        file.write(bordro.toJSONString());
                        System.out.println("JSON dosyası başarıyla oluşturuldu: " + ad + "_" + soyad + "_bordro.json");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    personeller.add(personel);
                }
                MaasBordro maasBordro = new MaasBordro(personeller);
                maasBordro.maaslariHesapla();

            } else {
                System.err.println("Dosya bulunamadı!");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
