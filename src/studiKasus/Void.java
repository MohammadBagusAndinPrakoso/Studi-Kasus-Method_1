/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studiKasus;

/**
 *
 * @author MOKLET1
 */
import java.util.Scanner;
public class Void {
    Scanner input = new Scanner(System.in); //Menambahkan Scanner
    
    //Deklarasi variabel
    boolean running = true;
    String headset[] = {"x","dbE GM100", "dbE GM150", "dbE GM180", "dbE GM190", "dbE GM200", "dbE GM250", "dbE GM300", "dbE GM500"};
    String jawaban;
    int harga[] = {0, 150000, 130000, 180000, 195000, 280000, 230000, 430000, 450000};
    int pilihan, jumlah, uang, total, kembali, kurang;
    
    void user(){
        //Menggunakan perulangan for untuk menampilkan isi data Array
        for(int i=1; i < headset.length; i++){
            System.out.println(i + ". " +headset[i] + " --> Harga = Rp. " + harga[i]);
        }
        
        //Menginputkan barang yang ada di data Array beserta jumlah yang akan dibeli
        System.out.println("-------------------------------------------");
        System.out.print("Silahkan pilih barang yang akan Anda beli : ");
        pilihan = input.nextInt();
        System.out.print("Jumlah barang yang di beli : ");
        jumlah = input.nextInt();
        System.out.println("-------------------------------------------");
        System.out.println("Barang yang di pilih    : " +headset[pilihan]);
        System.out.println("Jumlah barang           : " +jumlah);
        System.out.println("Total Harga : Rp. " + (total = harga[pilihan] * jumlah));
        System.out.println("-------------------------------------------");
    }
    
    void hitung(){
        //Menginputkan uang pembayaran dari user
        System.out.print("Masukkan uang pembayaran Anda : ");
        uang = input.nextInt();
        
        System.out.println("Uang Pembayaran Anda : Rp. " +uang);
        System.out.println("-------------------------------------------");
        
        /*Menentukan user untuk menerima kembalian, tidak menerima kembalian, 
        ataupun menambah uang pembayaran yang kurang dengan menggunakan percabangan
        if, if else if, dan perulangan while*/
        
        /*Jika uang>total harga, maka user menerima kembalian. Jika uang=total harga, maka 
        user tidak menerima kembalian. Jika uang<total harga, maka user dapat memilih ingin
        menambahkan uang pembayaran atau tidak. Jika iya maka user menambahkan uang pembayaran,
        jika tidak maka pembayaran dibatalkan*/
        if(uang>total){
            kembali = uang - total;
            System.out.println("Pembayaran Berhasil, kembalian Anda Rp. " +kembali+ ", terima kasih!");
        } else if (uang==total){
            System.out.println("Pembayaran berhasil, terima kasih!");
        } else {
            System.out.println("Maaf, uang pembayaran Anda kurang sebesar Rp. " + (kurang = total - uang));
            System.out.println("-----------------------------------------------");
            
            while (running){
                System.out.println("Apakah anda ingin menambah uang pembayaran?");
                System.out.print("Jawab [ya/tidak] --> ");
                jawaban = input.nextLine();
                System.out.println("---------------------------------------------");

                if(jawaban.equalsIgnoreCase("ya")){
                    System.out.print("Masukkan uang pembayaran yang kurang : Rp. ");
                    uang = input.nextInt();
                    
                    if (uang>kurang){
                        System.out.println("Pembayaran berhasil, kembalian Anda Rp. " +(kembali = uang-kurang)+ ", terima kasih!");
                        running = false;
                    } else if (uang==kurang) {
                        System.out.println("Pembayaran berhasil, terima kasih!");
                        running = false;
                    } else{
                        System.out.println("Pembayaran tidak berhasil, silahkan mengulangi program...");
                        running = false;
                    }
                }
                if( jawaban.equalsIgnoreCase("tidak") ){
                    System.out.println("Maaf, pembayaran Anda tidak berhasil...");
                    running = false;
                }
            }
        }
    }
}
