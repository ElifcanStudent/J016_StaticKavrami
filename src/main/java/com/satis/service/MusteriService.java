package com.satis.service;

import com.satis.entity.Musteri;
import com.satis.repository.VeriDeposu;

public class MusteriService {
    /**
     * müsteri ekle
     * müsteri listele
     * müşteri sil
     * müsteri bul
     */

    public void musteriEkle ( String ad, String adres, String telefon, double borc){
        Musteri musteri = new Musteri();
        musteri.adSoyad = ad;
        musteri.adres = adres;
        musteri.telefon = telefon;
        musteri.borc = borc;
        musteri.siraNo = VeriDeposu.sayac + 1;
        musteri.isActive = true;
        VeriDeposu.musteriListesi[VeriDeposu.sayac++] = musteri;
    } // end meyhod musteriEkle

    public void musteriSil (int siraNo){
        /**
         * list = {1. müş, 2. müş, 3. müş , 4. müş}
         * list (yeni hali) = {1. müş, null, 3. müş, 4. müş}
         */
        VeriDeposu.musteriListesi[siraNo-1].isActive = false;
        /**
         * DİKKAT!!! Best Way
         * hiçbir zaman hiç bir VeriTabanından deposundan veri silinmez, sadece görünmez hale getirilir.
         */

    } // end method musteriSil

    private void musteriListele(boolean isActive){
        System.out.println("""
                
                ********* Müşteri Listesi *********
                """);

        for (int i = 0; i < VeriDeposu.sayac; i++) {
            Musteri mst = VeriDeposu.musteriListesi[i];
            if (mst.isActive) {
                System.out.println("Musteri Sıra No : " + mst.siraNo);
                System.out.println("Musteri Ad Soyad : " + mst.adSoyad);
                System.out.println("Musteri adres : " + mst.adres);
                System.out.println("Musteri telefon : " + mst.telefon);
                System.out.println("Musteri borc : " + mst.borc);
            }
        }

    } // end method musteriListesi

    public void musteriListeleAktif(){
        musteriListele(true);

    } // end method musteriListeleAktif

    public void musteriListelePasif(){
        musteriListele(false);

    } // end method musteriListelePasif

    public void musteriBul(String ad){
        for (int i = 0; i < VeriDeposu.sayac; i++) {
            Musteri mst = VeriDeposu.musteriListesi[i];
            if (mst.adSoyad.toLowerCase().equals(ad.toLowerCase()) && mst.isActive) {
                musteriYazdir(mst);
            }
        }

    } // end method musteriBul

    private void musteriYazdir (Musteri mst) {
        System.out.println("Musteri Sıra No : " + mst.siraNo);
        System.out.println("Musteri Ad Soyad : " + mst.adSoyad);
        System.out.println("Musteri adres : " + mst.adres);
        System.out.println("Musteri telefon : " + mst.telefon);
        System.out.println("Musteri borc : " + mst.borc);
    }

} // end class
