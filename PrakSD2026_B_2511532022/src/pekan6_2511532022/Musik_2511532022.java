package pekan6_2511532022;
import java.util.Scanner;

public class Musik_2511532022 {
    static Lagu_2511532022 head_2022 = null;
    static Lagu_2511532022 tail_2022 = null;

    // 1. Tambah lagu di AKHIR
    public static void tambahLagu_2022(String judul, String penyanyi) {
        Lagu_2511532022 baru_2022 = new Lagu_2511532022(judul, penyanyi);
        if (head_2022 == null) {
            head_2022 = tail_2022 = baru_2022;
        } else {
            tail_2022.next_2022 = baru_2022;
            baru_2022.prev_2022 = tail_2022;
            tail_2022 = baru_2022;
        }
        System.out.println("Lagu berhasil ditambahkan!");
    }

    // 2. Hapus lagu PERTAMA
    public static void hapusLaguAwal_2022() {
        if (head_2022 == null) {
            System.out.println("Playlist kosong, tidak ada yang dihapus.");
            return;
        }
        if (head_2022 == tail_2022) {
            head_2022 = tail_2022 = null;
        } else {
            head_2022 = head_2022.next_2022;
            head_2022.prev_2022 = null;
        }
        System.out.println("Lagu pertama berhasil dihapus!");
    }

    // 3. Tampil MAJU
    public static void tampilMaju_2022() {
        if (head_2022 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532022 curr_2022 = head_2022;
        while (curr_2022 != null) {
            System.out.println(curr_2022.getJudul_2022() + " - " + curr_2022.getPenyanyi_2022());
            curr_2022 = curr_2022.next_2022;
        }
    }

    // 4. Tampil MUNDUR
    public static void tampilMundur_2022() {
        if (tail_2022 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532022 curr_2022 = tail_2022;
        while (curr_2022 != null) {
            System.out.println(curr_2022.getJudul_2022() + " - " + curr_2022.getPenyanyi_2022());
            curr_2022 = curr_2022.prev_2022;
        }
    }

    // 5. Cari lagu (tidak case-sensitive)
    public static void cariLagu_2022(String judulCari) {
        Lagu_2511532022 curr_2022 = head_2022;
        boolean ketemu = false;
        while (curr_2022 != null) {
            if (curr_2022.getJudul_2022().equalsIgnoreCase(judulCari)) {
                System.out.println("Lagu ditemukan: " + curr_2022.getJudul_2022() + " [" + curr_2022.getPenyanyi_2022() + "]");
                ketemu = true;
                break;
            }
            curr_2022 = curr_2022.next_2022;
        }
        if (!ketemu) System.out.println("Lagu '" + judulCari + "' tidak ada di playlist.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih = 0;
        while (pilih != 6) {
            System.out.println("\n=== Playlist Musik NIM: 2511532022 ===");
            System.out.println("1. Tambah Lagu\n2. Hapus Lagu Pertama\n3. Lihat Playlist (Maju)\n4. Lihat Playlist (Mundur)\n5. Cari Lagu\n6. Keluar");
            System.out.print("Pilihan: ");
            pilih = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (pilih == 1) {
                System.out.print("Judul: "); String jdl = sc.nextLine();
                System.out.print("Penyanyi: "); String pny = sc.nextLine();
                tambahLagu_2022(jdl, pny);
            } else if (pilih == 2) {
                hapusLaguAwal_2022();
            } else if (pilih == 3) {
                tampilMaju_2022();
            } else if (pilih == 4) {
                tampilMundur_2022();
            } else if (pilih == 5) {
                System.out.print("Masukkan judul yang dicari: ");
                String cari = sc.nextLine();
                cariLagu_2022(cari);
            }
        }
    }
}