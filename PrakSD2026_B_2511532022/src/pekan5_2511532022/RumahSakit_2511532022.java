package pekan5_2511532022;
import java.util.Scanner;

public class RumahSakit_2511532022 {
    private Pasien_2511532022 head_2022 = null;
    private int counterAntrian_2022 = 0; // Auto-increment nomor antrian

    // 1. Daftarkan Pasien (Insert at Tail) (ekor)
    public void daftarkan_2022(String nama, String keluhan) {
        counterAntrian_2022++;
        Pasien_2511532022 baru = new Pasien_2511532022(nama, keluhan, counterAntrian_2022);
        
        if (head_2022 == null) {
            head_2022 = baru; // Jika list kosong, simpul baru jadi head
        } else {
            Pasien_2511532022 temp = head_2022;
            while (temp.next_2022 != null) { // Iterasi sampai ekor (tail)
                temp = temp.next_2022;
            }
            temp.next_2022 = baru; // Menyambungkan di akhir
        }
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counterAntrian_2022);
    }

    // 2. Panggil Pasien (Delete Head)
    public void panggil_2022() {
        if (head_2022 == null) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Memanggil Pasien: " + head_2022.getNama_2022());
        System.out.println("Keluhan: " + head_2022.getKeluhan_2022());
        head_2022 = head_2022.next_2022; // Menggeser head ke simpul berikutnya
    }

    // 3. Tampilkan Antrian (Display)
    public void tampilkan_2022() {
        if (head_2022 == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        Pasien_2511532022 curr = head_2022;
        System.out.println("\n--- Daftar Antrian Saat Ini ---");
        while (curr != null) {
            System.out.println("[" + curr.getNomor_2022() + "] " + curr.getNama_2022() + " (" + curr.getKeluhan_2022() + ")");
            curr = curr.next_2022;
        }
    }

    // 4. Cari Pasien (Search - Case Insensitive)
    public void cari_2022(String cariNama) {
        Pasien_2511532022 temp = head_2022;
        boolean ditemukan = false;
        while (temp != null) {
            if (temp.getNama_2022().equalsIgnoreCase(cariNama)) {
                System.out.println("Data Ditemukan: " + temp.getNama_2022() + " berada di Antrian No: " + temp.getNomor_2022());
                ditemukan = true;
            }
            temp = temp.next_2022;
        }
        if (!ditemukan) System.out.println("Pasien dengan nama '" + cariNama + "' tidak ditemukan.");
    }

    // 5. Cek Status Antrian
    public void cekStatus_2022() {
        if (head_2022 == null) {
            System.out.println("Antrian saat ini masih kosong.");
            return;
        }
        int total = 0;
        Pasien_2511532022 temp = head_2022;
        while (temp != null) {
            total++;
            temp = temp.next_2022;
        }
        System.out.println("Total Pasien dalam antrian: " + total);
        System.out.println("Pasien terdepan: " + head_2022.getNama_2022());
    }

    public static void main(String[] args) {
        RumahSakit_2511532022 rs = new RumahSakit_2511532022();
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n=== Antrian Rumah Sakit NIM: 2511532022 ===");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilih = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String n = sc.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String k = sc.nextLine();
                    rs.daftarkan_2022(n, k);
                    break;
                case 2:
                    rs.panggil_2022();
                    break;
                case 3:
                    rs.tampilkan_2022();
                    break;
                case 4:
                    System.out.print("Cari Nama: ");
                    String cn = sc.nextLine();
                    rs.cari_2022(cn);
                    break;
                case 5:
                    rs.cekStatus_2022();
                    break;
            }
        } while (pilih != 6);
    }
}