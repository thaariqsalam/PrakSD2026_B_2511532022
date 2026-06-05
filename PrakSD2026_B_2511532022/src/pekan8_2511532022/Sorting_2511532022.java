package pekan8_2511532022;

import java.util.Scanner;

public class Sorting_2511532022 {

    // Array untuk menyimpan maksimal 20 lagu sesuai ketentuan tugas
    private Lagu_2511532022[] dataLagu_2022 = new Lagu_2511532022[20];
    private int jumlahLagu_2022 = 0;

    // Method untuk mengisi data awal (minimal 7 lagu)
    public void inputData_2022() {
        dataLagu_2022[0] = new Lagu_2511532022("Mio Cristo Piange Diamanti", "Musisi A", 270);
        dataLagu_2022[1] = new Lagu_2511532022("La Rumba Del Perdon", "Musisi B", 252);
        dataLagu_2022[2] = new Lagu_2511532022("La Perla", "Musisi C", 196);
        dataLagu_2022[3] = new Lagu_2511532022("Hati-Hati di Jalan", "Tulus", 242);
        dataLagu_2022[4] = new Lagu_2511532022("Gajah", "Tulus", 221);
        dataLagu_2022[5] = new Lagu_2511532022("Monokrom", "Tulus", 214);
        dataLagu_2022[6] = new Lagu_2511532022("Sial", "Mahalini", 243);
        jumlahLagu_2022 = 7;
    }

    // Fungsi pembantu tukar posisi elemen objek Lagu
    private void swap_2022(int i, int j) {
        Lagu_2511532022 temp_2022 = dataLagu_2022[i];
        dataLagu_2022[i] = dataLagu_2022[j];
        dataLagu_2022[j] = temp_2022;
    }

    // ==================== 1. IMPLEMENTASI SHELL SORT ====================
    // Shell Sort mengurutkan berdasarkan JUDUL secara alfabetis (A-Z)
    public void shellSort_2022() {
        int n_2022 = jumlahLagu_2022;
        int gap_2022 = n_2022 / 2;

        while (gap_2022 > 0) {
            for (int i_2022 = gap_2022; i_2022 < n_2022; i_2022++) {
                Lagu_2511532022 temp_2022 = dataLagu_2022[i_2022];
                int j_2022 = i_2022;
                
                // Bandingkan string judul menggunakan compareTo untuk urutan A-Z
                while (j_2022 >= gap_2022 && 
                       dataLagu_2022[j_2022 - gap_2022].getJudul_2022().compareTo(temp_2022.getJudul_2022()) > 0) {
                    dataLagu_2022[j_2022] = dataLagu_2022[j_2022 - gap_2022];
                    j_2022 = j_2022 - gap_2022;
                }
                dataLagu_2022[j_2022] = temp_2022;
            }
            gap_2022 = gap_2022 / 2;
        }
    }

    // ==================== 2. IMPLEMENTASI QUICK SORT ====================
    // Logika partisi Quick Sort berdasarkan Durasi (Ascending)
    private int partition_2022(int low_2022, int high_2022) {
        int pivot_2022 = dataLagu_2022[high_2022].getDurasi_2022();
        int i_2022 = (low_2022 - 1);

        for (int j_2022 = low_2022; j_2022 < high_2022; j_2022++) {
            if (dataLagu_2022[j_2022].getDurasi_2022() < pivot_2022) {
                i_2022++;
                swap_2022(i_2022, j_2022);
            }
        }
        swap_2022(i_2022 + 1, high_2022);
        return (i_2022 + 1);
    }

    // Method Utama Quick Sort Rekursif
    public void quickSort_2022(int low_2022, int high_2022) {
        if (low_2022 < high_2022) {
            int pi_2022 = partition_2022(low_2022, high_2022);
            quickSort_2022(low_2022, pi_2022 - 1);
            quickSort_2022(pi_2022 + 1, high_2022);
        }
    }

    // ==================== 3. IMPLEMENTASI MERGE SORT ====================
    // Fungsi penggabungan untuk Merge Sort (Berdasarkan JUDUL A-Z)
    private void merge_2022(int l_2022, int m_2022, int r_2022) {
        int n1_2022 = m_2022 - l_2022 + 1;
        int n2_2022 = r_2022 - m_2022;

        Lagu_2511532022[] L_2022 = new Lagu_2511532022[n1_2022];
        Lagu_2511532022[] R_2022 = new Lagu_2511532022[n2_2022];

        for (int i = 0; i < n1_2022; ++i) {
            L_2022[i] = dataLagu_2022[l_2022 + i];
        }
        for (int j = 0; j < n2_2022; ++j) {
            R_2022[j] = dataLagu_2022[m_2022 + 1 + j];
        }

        int i_2022 = 0, j_2022 = 0;
        int k_2022 = l_2022;

        while (i_2022 < n1_2022 && j_2022 < n2_2022) {
            // Membandingkan judul alfabetis (A-Z)
            if (L_2022[i_2022].getJudul_2022().compareTo(R_2022[j_2022].getJudul_2022()) <= 0) {
                dataLagu_2022[k_2022] = L_2022[i_2022];
                i_2022++;
            } else {
                dataLagu_2022[k_2022] = R_2022[j_2022];
                j_2022++;
            }
            k_2022++;
        }

        while (i_2022 < n1_2022) {
            dataLagu_2022[k_2022] = L_2022[i_2022];
            i_2022++;
            k_2022++;
        }

        while (j_2022 < n2_2022) {
            dataLagu_2022[k_2022] = R_2022[j_2022];
            j_2022++;
            k_2022++;
        }
    }

    // Method Utama Merge Sort Rekursif
    public void mergeSort_2022(int l_2022, int r_2022) {
        if (l_2022 < r_2022) {
            int m_2022 = (l_2022 + r_2022) / 2;

            mergeSort_2022(l_2022, m_2022);
            mergeSort_2022(m_2022 + 1, r_2022);

            merge_2022(l_2022, m_2022, r_2022);
        }
    }

    // Method untuk menampilkan isi data playlist lagu
    public void tampilData_2022() {
        for (int k_2022 = 0; k_2022 < jumlahLagu_2022; k_2022++) {
            System.out.println((k_2022 + 1) + ". " + dataLagu_2022[k_2022].getJudul_2022() + 
                               " (" + dataLagu_2022[k_2022].getPenyanyi_2022() + ") - " + 
                               dataLagu_2022[k_2022].getDurasi_2022() + " detik");
        }
    }

    public static void main(String[] args_2022) {
        Scanner scanner_2022 = new Scanner(System.in);
        Sorting_2511532022 manager_2022 = new Sorting_2511532022();
        
        // Memuat data awal lagu
        manager_2022.inputData_2022();

        System.out.println("Sorting Playlist NIM: 2511532022");
        System.out.print("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): ");
        int pilihan_2022 = scanner_2022.nextInt();

        System.out.println("\nData Sebelum Sorting:");
        manager_2022.tampilData_2022();

        switch (pilihan_2022) {
            case 1:
                manager_2022.shellSort_2022();
                System.out.println("\nData Setelah Shell Sort (Judul A-Z):");
                manager_2022.tampilData_2022();
                break;
            case 2:
                manager_2022.quickSort_2022(0, manager_2022.jumlahLagu_2022 - 1);
                System.out.println("\nData Setelah Quick Sort (Durasi Asc):");
                manager_2022.tampilData_2022();
                break;
            case 3:
                manager_2022.mergeSort_2022(0, manager_2022.jumlahLagu_2022 - 1);
                System.out.println("\nData Setelah Merge Sort (Judul A-Z):");
                manager_2022.tampilData_2022();
                break;
            default:
                System.out.println("\nPilihan tidak valid!");
                break;
        }
        
        scanner_2022.close();
    }
}