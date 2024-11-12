package com.odev.controller;

import com.odev.repository.UrunDeposu;
import com.odev.service.UrunService;

import java.util.Scanner;

public class UrunController {

    private UrunService urunService = new UrunService();

    public int secim (){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ********** Ürün Takip Sistemi **********            
                *************  ANA SAYFA  *****************            
                1- Ürün Ekle            
                2- Ürün Listeleme            
                3- Ürün Arama            
                4- Stoğu Azalan Ürünler            
                5- Ürün Satış            
                6- Ürün Giriş            
                0- ÇIKIŞ
                """);
        System.out.print("Lütfen seçiniz : ");
        int secim = sc.nextInt();
        return secim;
    } // end method secim

    public void init(){
        int secim ;
        do{
            secim = secim();
            switch(secim){
                case 1: urunEkle(); break;
                case 2: urunListele(); break;
                case 3: urunArama(); break;
                case 4: stokAzalanUrunler(); break;
                case 5: urunSatis(); break;
                case 6: urunGiris(); break;
                case 0:
                    System.out.println("Sistemden çıkış yapıldı.");
                    break;
                default:
                    System.out.println("Lütfen geçerli bir giriş yapınız.");
                    break;
            }

        }while(secim != 0);

    } // end method init

    private void urunEkle (){
        System.out.println("""
                
                *****Urun Ekleme *****
                """);
        System.out.println("Ürün Adı : ");
        String urunadi = new Scanner(System.in).nextLine();
        System.out.println("Ürün Markası : ");
        String urunmarkasi = new Scanner(System.in).nextLine();
        System.out.println("Ürün Modeli : ");
        String urunmodeli = new Scanner(System.in).nextLine();
        System.out.println("Ürün Stok : ");
        int urunstok = new Scanner(System.in).nextInt();
        urunService.urunEkleme(urunadi,urunmarkasi, urunmodeli,urunstok);
    } // end method UrunEkle

    private void urunListele (){
        urunService.varMi();
        for (int i = 0; i < UrunDeposu.sayac; i++){
            System.out.println("""
                    ***** Urun Listele *****
                    """);
            System.out.println("Urun Adı : " + UrunDeposu.urunListesi[i].ad);
            System.out.println("Urun Marka : " + UrunDeposu.urunListesi[i].marka);
            System.out.println("Urun Model : " + UrunDeposu.urunListesi[i].model);
            System.out.println("Urun Stok : " + UrunDeposu.urunListesi[i].stok);
            System.out.println("Urun Sıra No : " + UrunDeposu.urunListesi[i].siraNo);
        }
    } // end method UrunListele

    private void urunArama (){
        if (urunService.varMi()){
            System.out.println("Aramak istediğiniz ürünü giriniz : ");
            String arananUrunAdi = new Scanner(System.in).nextLine();
            urunService.urunBul(arananUrunAdi);
        }

    } // end method urunArama

    private void stokAzalanUrunler(){
        urunService.varMi();
        urunService.stokAzalan();
    } // end method stokAzalanUrunler

    private void urunSatis(){
        urunService.varMi();
        System.out.println("Lütfen satılacak ürünün sıra nosunu giriniz : ");
        int siraNo = new Scanner(System.in).nextInt();
        System.out.println("Lütfen satılacak miktarı giriniz : ");
        int adet = new Scanner(System.in).nextInt();
        if (UrunDeposu.urunListesi[siraNo-1] == null){
            System.out.println("Bu sıra numarsına ait ürün bulunmamaktadır.");
        }
        else
            urunService.urunSatis(siraNo,adet);
    } // end method urunSatis

    private void urunGiris(){
        urunService.varMi();
        System.out.println("Lütfen girilecek ürünün sıra nosunu giriniz : ");
        int siraNo = new Scanner(System.in).nextInt();
        System.out.println("Lütfen girilecek miktarı giriniz : ");
        int adet = new Scanner(System.in).nextInt();
        if (UrunDeposu.urunListesi[siraNo-1] == null){
            System.out.println("Bu sıra numarsına ait ürün bulunmamaktadır.");
        }
        else
            urunService.urunGiris(siraNo,adet);
    } // end method urunGiris

}
