package pekan4_2511532022;
import java.util.Scanner;

public class AntrianLoketDriver_2511532022 {
    public static void main(String[] args) {
        AntrianLoket_2511532022 loket_2022 = new AntrianLoket_2511532022(10);
        Scanner sc_2022 = new Scanner(System.in);
        int pilih_2022;
        System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Hapus Antrian");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Reverse");
        System.out.println("5. Keluar");
        
        do {

            System.out.print("\nPilih menu: ");
            pilih_2022 = sc_2022.nextInt();
            sc_2022.nextLine(); 

            switch (pilih_2022) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama_2022 = sc_2022.nextLine();
                    loket_2022.enqueue_2022(nama_2022);
                    break;
                case 2:
                    String hasil_2022 = loket_2022.dequeue_2022();
                    if (!hasil_2022.equals("Antrian kosong!")) {
                        System.out.println(hasil_2022 + " telah dilayani.");
                    } else {
                        System.out.println(hasil_2022);
                    }
                    break;
                case 4:
                    loket_2022.reverse_2022();
                    loket_2022.display_2022();
                    break;
                case 3:
                    loket_2022.display_2022();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilih_2022 != 5);
        sc_2022.close();
    }
}