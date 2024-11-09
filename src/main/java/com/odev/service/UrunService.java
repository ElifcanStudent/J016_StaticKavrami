package com.odev.service;

import com.odev.entity.Urun;
import com.odev.repository.UrunDeposu;

public class UrunService {
    /**
     * * Ürün Ekleme
     *          * Ürün Listeleme
     *          * Ürün Arama
     *          * Stoğu Azalan Ürünler
     *          * Ürün Satış(ürün seçilir satılan adet girilir ve stoktan düşülür.)
     *          * Ürün Giriş(ürün  adedi girilerek stokta artış yapmak.)
     */

    public void urunEkleme(String ad, String marka, String model, int stok){
        Urun urun = new Urun();
        urun.ad = ad;
        urun.siraNo = UrunDeposu.sayac + 1;
        urun.marka = marka;
        urun.model = model;
        urun.stok = stok;
        UrunDeposu.urunListesi[UrunDeposu.sayac++] = urun;

    } // end method urunEkleme

    public void urunListele(){
        System.out.println("""
                
                ********* Urun Listesi *********
                """);
        for (int i = 0; i < UrunDeposu.sayac; i++) {
            Urun urn = UrunDeposu.urunListesi[i];
            System.out.println("Urun Sıra No : " + urn.siraNo);
            System.out.println("Urun Ad : " + urn.ad);
            System.out.println("Urun markası : " + urn.marka);
            System.out.println("Urun model : " + urn.model);
            System.out.println("Urun stok : " + urn.stok);

        }
     } // end method urunListele

    public void urunBul(String ad) {
        for (int i = 0; i < UrunDeposu.sayac; i++) {
            Urun urn = UrunDeposu.urunListesi[i];
            if (urn.ad.toLowerCase().contains(ad.toLowerCase())) {
                System.out.println("Urun Sıra No : " + urn.siraNo);
                System.out.println("Urun Ad : " + urn.ad);
                System.out.println("Urun markası : " + urn.marka);
                System.out.println("Urun model : " + urn.model);
                System.out.println("Urun stok : " + urn.stok);
            }
            else{
                System.out.println("Aradağınız kelime bulunamadı.");
            }
        }
    } // end method urunBul

    public void urunSatis(int siraNo, int adet){
        UrunDeposu.urunListesi[siraNo-1].stok -= adet;
    }
    public void urunGiris(int siraNo, int adet){
        UrunDeposu.urunListesi[siraNo-1].stok += adet;
    }
    public void stokAzalan (){
        for (int i = 0; i < UrunDeposu.sayac; i++) {
            if (UrunDeposu.urunListesi[i].stok <= 5) {
                System.out.println(UrunDeposu.urunListesi[i].ad + "ürünü azaldı.");
                System.out.println("Stok sayısı : " + UrunDeposu.urunListesi[i].stok);
            }
        }
    } // end method stokAzalan


}
