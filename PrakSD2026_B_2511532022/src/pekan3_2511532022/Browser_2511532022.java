package pekan3_2511532022;

import java.util.Stack;
import java.util.Scanner;

public class Browser_2511532022 {
    public static void main(String[] args) {
        // Inisialisasi stack buat simpan history
        Stack<Website_2511532022> history = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=== Browser History NIM: 2511532022 ===");
            System.out.println("1. Kunjungi Website (Push)");
            System.out.println("2. Tombol Back (Pop)");
            System.out.println("3. Lihat Halaman Aktif (Peek)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt();
            sc.nextLine(); // bersihin sisa enter biar ngga skip input string

            if (menu == 1) {
                System.out.print("Judul web: ");
                String jdl = sc.nextLine();
                System.out.print("URL: ");
                String link = sc.nextLine();
                
                // Masukin data baru ke tumpukan paling atas
                history.push(new Website_2511532022(jdl, link));
                System.out.println("-> Berhasil buka halaman baru.");
                
            } else if (menu == 2) {
                // Cek dulu jangan sampai pop pas stack kosong (biar ga error)
                if (history.isEmpty()) {
                    System.out.println("-> History kosong, ga bisa mundur.");
                } else {
                    Website_2511532022 hapus = history.pop();
                    System.out.println("-> Back! Keluar dari: " + hapus.getJudul_2022());
                }
                
            } else if (menu == 3) {
                if (history.isEmpty()) {
                    System.out.println("-> Ga ada halaman yang aktif.");
                } else {
                    System.out.print("-> Kamu lagi buka: ");
                    // Ngintip data paling atas tanpa hapus
                    history.peek().infoWeb();
                }
                
            } else if (menu == 4) {
                System.out.println("-> Bye! Browser ditutup.");
            } else {
                System.out.println("-> Menu itu ga ada, pilih yang bener ya.");
            }
            
        } while (menu != 4);
        
        sc.close();
    }
}