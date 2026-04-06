package pekan2_2511532022;

public class DaftarKataDriver_2511532022 {
public static void main(String[] args) {    
    DaftarKata_2511532022 al = new DaftarKata_2511532022();
    al.tambah("Kami");
    al.tambah("Informatika");

    al.tambahPada(1,"Mahasiswa");

    System.out.println("Awal       : " + al);

    al.ubahElemen(1, "Departemen");
    System.out.println("Setelah ubah : " + al);

    String terhapus = al.hapusElemen(0);
    System.out.println("Terhapus    : " + terhapus);
    System.out.println("Setelah hapus : " + al);

    System.out.println("Iterasi: ");
    al.iterasiCetak();
    System.out.println();
}
}
