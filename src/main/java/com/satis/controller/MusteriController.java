package com.satis.controller;

import com.satis.service.MusteriService;

import java.util.Scanner;

public class MusteriController {

    private MusteriService musteriService = new MusteriService();
    int sayi = 5;

    public void basla(){

        int secim ;
        do{
            secim = secimYap();
            switch (secim) {
                case 1:
                    musteriEkle();
                    break;
                case 2:
                    musteriSil();
                    break;
                case 3:
                    musteriListele();
                    break;
                case 4:
                    musteriBul();
                    break;
                case 0:
                    System.out.println("CIKIS YAPILDI");
                    break;
                default:
                    System.out.println("Lutfen gecerli bir secim yapınız.");
            }

        } while (secim != 0); // end do/while loop

    } // end method basla

    private void musteriEkle(){
        System.out.println("""
                
                *****Müşteri Ekleme *****
                """);
        System.out.println("Musteri Adı Saoyadı : ");
        String adsoyad = new Scanner(System.in).nextLine();
        System.out.println("Musteri Adresi : ");
        String adres = new Scanner(System.in).nextLine();
        System.out.println("Musteri Telefon : ");
        String telefon = new Scanner(System.in).nextLine();
        System.out.println("Musteri Borc : ");
        double borc = new Scanner(System.in).nextDouble();
        musteriService.musteriEkle(adsoyad, adres, telefon, borc);
    } // end method musteriEkle

    private void musteriSil(){
        System.out.println("""
                
                *****Müşteri Silme *****
                """);
        System.out.println("Musteri sira no : ");
        int siraNo = new Scanner(System.in).nextInt();
        musteriService.musteriSil(siraNo);
    } // end method musteriSil

    private void musteriListele(){
        musteriService.musteriListeleAktif();
    } // end method musteriListele

    private void musteriBul(){
        System.out.println("Aranan Müşteri Bilgisi : ");
        String ad = new Scanner(System.in).nextLine();
        musteriService.musteriBul(ad);
    } // end method musteriBul

    private int secimYap(){
        System.out.println("""
                ********** Müşteri Takip Sistemi **********
                1- Müşteri Ekle
                2- Müşteri Silme
                3- Müşteri Listeleme
                4- Müşteri Arama
                0- CIKIS
                """);

        System.out.println("Lütfen Seçiniz : ");
        int secim = new Scanner(System.in).nextInt();
        return secim;
    } // end method secimYap

} // end class
