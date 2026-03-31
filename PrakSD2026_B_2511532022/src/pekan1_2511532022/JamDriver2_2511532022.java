package pekan1_2511532022;

import java.util.Scanner;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class JamDriver2_2511532022 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Program Driver objek jam ===");

        // 1. input jam pertama
        System.out.println("\n --- input jam 1 ----");
        Jam_2511532022 j1 = buatJamDariInput(input);

        // 2. input jam kedua
        System.out.println("\n --- input jam 2 ----"); // Perbaikan teks dari jam 1 ke jam 2
        Jam_2511532022 j2 = buatJamDariInput(input);

        // 3. menampilkan data
        System.out.println("\n --- hasil operasi ----");
        System.out.println("jam 1 (String)           : " + j1.toString());
        System.out.println("jam 2 (String)           : " + j2.toString());
        
        // Perbaikan: toSecond() menjadi toSeconds() sesuai class utama
        System.out.println("jam 1 dalam detik        : " + j1.toSeconds());
        System.out.println("jam 2 dalam detik        : " + j2.toSeconds());

        // 4. Operasi Relasional (Perbandingan)
        int perbandingan = j1.compareTo(j2);
        if (perbandingan > 0) {
            System.out.println("Status                   : Jam 1 lebih lambat (setelah) Jam 2");
        } else if (perbandingan < 0) {
            System.out.println("Status                   : Jam 1 lebih awal (sebelum) Jam 2");
        } else {
            System.out.println("Status                   : Jam 1 dan Jam 2 sama persis");
        }

        // 5. Operasi Aritmatika
        System.out.println("Durasi (J1 ke J2)        : " + Jam_2511532022.durasiDetik(j1, j2) + " detik");

        Jam_2511532022 jNext = j1.nextSecond();
        System.out.println("Jam 1 Detik Berikutnya   : " + jNext);

        Jam_2511532022 jPrev = j1.prevSecond();
        System.out.println("Jam 1 Detik Sebelumnya   : " + jPrev);

        // 6. Operasi Penjumlahan Jam
        Jam_2511532022 jHasilPlus = j1.plus(j2);
        System.out.println("Hasil J1 + J2            : " + jHasilPlus);

        input.close();
        System.out.println("\nProgram Selesai.");
    } 
    
    /**
     * Prosedur pembantu untuk melakukan input dan validasi secara berulang
     * sampai user memasukkan angka yang benar (0..23, 0..59).
     */
    private static Jam_2511532022 buatJamDariInput(Scanner sc) {
        int h, m, s;
        while (true) {
            System.out.print("Masukkan Jam (0-23)   : ");
            h = sc.nextInt();
            System.out.print("Masukkan Menit (0-59) : ");
            m = sc.nextInt();
            System.out.print("Masukkan Detik (0-59) : ");
            s = sc.nextInt();

            // Memanggil method static isValid dari kelas Jam_2511532022
            if (Jam_2511532022.isValid(h, m, s)) {
                return new Jam_2511532022(h, m, s);
            } else {
                System.out.println("[Error] Input tidak valid! Silakan ulangi.\n");
            }
        }
    }
}