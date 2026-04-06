package pekan2_2511532022;
import java.util.*;

public class MahasiswaDriver_2511532022 {
    public static void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Semua Mahasiswa");
        System.out.println("3. Hapus Mahasiswa Berdasarkan NIM");
        System.out.println("4. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("5. Keluar");
    }
    public static void tambahMahasiswa(ArrayList<Mahasiswa_2511532022>list, Scanner sc) {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Prodi: ");
        String prodi = sc.nextLine();
        list.add(new Mahasiswa_2511532022(nim, nama, prodi));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }
    public static void tampilkanSemuaMahasiswa(ArrayList<Mahasiswa_2511532022>list) {
        if (list.isEmpty()) {
            System.out.println("Daftar mahasiswa kosong.");
        } else {
            System.out.println("Data Mahasiswa:");
            for (Mahasiswa_2511532022 mhs : list) {
                System.out.println(mhs);
            }
        }
    }
    public static void hapusMahasiswa(ArrayList<Mahasiswa_2511532022>list, Scanner sc) {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String nimHapus = sc.nextLine();
        boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
        if (removed) {
            System.out.println("Data dengan NIM " + nimHapus + " berhasil dihapus.");
        } else {
            System.out.println("Data dengan NIM " + nimHapus + " tidak ditemukan.");
        }
    }
    public static void cariMahasiswa(ArrayList<Mahasiswa_2511532022>list, Scanner sc) {
        System.out.print("Masukkan NIM yang dicari: ");
        String nimCari = sc.nextLine();
        boolean ditemukan = false;

        for (Mahasiswa_2511532022 mhs : list) {
            if (mhs.nim.equals(nimCari)) {
                System.out.println("Data ditemukan: " + mhs);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("NIM tidak ada.");
        }
    }
    public static void main(String[] args) {
        ArrayList<Mahasiswa_2511532022> listMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    tambahMahasiswa(listMahasiswa, scanner);
                    break;
                case 2:
                    tampilkanSemuaMahasiswa(listMahasiswa);
                    break;
                case 3:
                    hapusMahasiswa(listMahasiswa, scanner);
                    break;
                case 4:
                    cariMahasiswa(listMahasiswa, scanner);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (choice != 5);
        scanner.close();
    }
}