package com.odev.controller;

import com.odev.service.UrunService;

import java.util.Scanner;

public class UrunController {

    private UrunService urunService =new UrunService();

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

    private void urunListele (){} // end method UrunListele
}
