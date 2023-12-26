/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectuas;
import java.util.Scanner;
/**
 *
 * @author USER
 */


    /**
     * @param args the command line arguments
     */
    
        

public class KasirEkspedisi {

    static final int ONGKIR_BIAYA = 20000;
    static final double DISKON_MEMBER = 0.1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Ryan Express");
        System.out.println("Metode pembayaran:");
        System.out.println("1. Member");
        System.out.println("2. Non-Member");

        System.out.print("Pilih metode pembayaran (1/2): ");
        int metodePembayaran = scanner.nextInt();

        boolean isMember = (metodePembayaran == 1);

        System.out.print("Masukkan wilayah tujuan: ");
        scanner.nextLine(); // Membersihkan newline dari input sebelumnya
        String wilayah = scanner.nextLine().toLowerCase();

        int ongkir = (isFreeOngkir(wilayah)) ? 0 : ONGKIR_BIAYA;

        System.out.print("Masukkan jumlah transaksi: ");
        int jumlahTransaksi = scanner.nextInt();

        double totalHarga = 0;

        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.println("\nTransaksi ke-" + (i + 1));

            System.out.print("Masukkan barang yang akan dikirim: ");
            scanner.nextLine(); // Membersihkan newline dari input sebelumnya
            String barang = scanner.nextLine();

            System.out.print("Masukkan berat barang (kg): ");
            double berat = scanner.nextDouble();

            double harga = hitungHarga(berat, isMember);
            totalHarga += harga;

            System.out.println("Harga yang harus dibayar: $" + harga);
        }

        System.out.println("\nTotal yang harus dibayar: $" + totalHarga);

        System.out.print("Masukkan jumlah uang: $");
        double jumlahUang = scanner.nextDouble();

        double kembalian = jumlahUang - totalHarga;

        System.out.println("\nKembalian: $" + kembalian);

        System.out.println("\nStruk Pembelian:");
        System.out.println("Metode Pembayaran: " + ((isMember) ? "Member" : "Non-Member"));
        System.out.println("Wilayah Tujuan: " + wilayah);
        System.out.println("Biaya Ongkir: $" + ongkir);
        System.out.println("Total Harga: $" + totalHarga);
        System.out.println("Jumlah Uang: $" + jumlahUang);
        System.out.println("Kembalian: $" + kembalian);

        scanner.close();
    }

    static boolean isFreeOngkir(String wilayah) {
        String[] gratisOngkir = {"surabaya", "nganjuk", "mojokerto", "kediri", "sidoarjo", "blitar", "madiun"};
        for (String kota : gratisOngkir) {
            if (wilayah.contains(kota)) {
                return true;
            }
        }
        return false;
    }

    static double hitungHarga(double berat, boolean isMember) {
        double hargaPerKg = 5000; // Harga per kilogram (contoh)
        double totalHarga = berat * hargaPerKg;

        if (isMember) {
            totalHarga -= totalHarga * DISKON_MEMBER;
        }

        return totalHarga;
    }
}

        // TODO code application logic here
    
    

