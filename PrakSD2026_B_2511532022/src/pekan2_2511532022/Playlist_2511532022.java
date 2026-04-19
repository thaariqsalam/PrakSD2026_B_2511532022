package pekan2_2511532022;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511532022 {
    private static Scanner input = new Scanner(System.in);

    // Method pembantu untuk mengambil input angka dengan validasi agar tidak error
    private static int ambilInputAngka(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                int angka = input.nextInt();
                input.nextLine(); // Bersihkan buffer
                return angka;
            } catch (Exception e) {
                System.out.println("Error: Masukkan harus berupa angka!");
                input.nextLine(); // Buang input salah
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Musik_2511532022> listLagu = new ArrayList<>();
        int pilihan = 0;

        do {
            System.out.println("\n=== Playlist Musik NIM: 2511532022 ===");
            System.out.println("1. Tambah Lagu\n2. Lihat Playlist\n3. Hapus Lagu\n4. Keluar");
            pilihan = ambilInputAngka("Pilihan: ");

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan Penyanyi: ");
                    String penyanyi = input.nextLine();
                    int durasi = ambilInputAngka("Masukkan Durasi (detik): ");
                    
                    listLagu.add(new Musik_2511532022(judul, penyanyi, durasi));
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n***** Daftar Lagu *****");
                    if (listLagu.isEmpty()) {
                        System.out.println("Playlist masih kosong.");
                    } else {
                        for (int i = 0; i < listLagu.size(); i++) {
                            Musik_2511532022 m = listLagu.get(i);
                            System.out.printf("%d. Judul: %s\n   Penyanyi: %s\n   Durasi: %d detik\n", 
                                              (i + 1), m.getJudul_2022(), m.getPenyanyi_2022(), m.getDurasi_2022());
                            System.out.println("---------------------------");
                        }
                    }
                    break;

                case 3:
                    if (listLagu.isEmpty()) {
                        System.out.println("Tidak ada lagu yang bisa dihapus.");
                    } else {
                        int nomor = ambilInputAngka("Masukkan nomor urut lagu yang dihapus: ");
                        if (nomor >= 1 && nomor <= listLagu.size()) {
                            listLagu.remove(nomor - 1);
                            System.out.println("Lagu berhasil dihapus.");
                        } else {
                            System.out.println("Nomor tidak valid!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 4);
    }
}