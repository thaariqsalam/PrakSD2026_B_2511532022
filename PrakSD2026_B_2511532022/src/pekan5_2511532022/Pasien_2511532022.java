package pekan5_2511532022;

public class Pasien_2511532022 {
    // Atribut wajib dengan akhiran 4 digit NIM
    private String namaPasien_2022;
    private String keluhan_2022;
    private int nomorAntrian_2022;
    Pasien_2511532022 next_2022; // Pointer ke node berikutnya

    // Constructor untuk menginisialisasi atribut
    public Pasien_2511532022(String nama_2022, String sakit_2022, int antrian_2022) {
        this.namaPasien_2022 = nama_2022;
        this.keluhan_2022 = sakit_2022;
        this.nomorAntrian_2022 = antrian_2022;
        this.next_2022 = null;
    }

    // Selektor (Getter)
    public String getNama_2022() { return namaPasien_2022; }
    public String getKeluhan_2022() { return keluhan_2022; }
    public int getNomor_2022() { return nomorAntrian_2022; }
    public Pasien_2511532022 getNext_2022() { return next_2022; }

    // Mutator (Setter)
    public void setNama_2022(String n) { this.namaPasien_2022 = n; }
    public void setKeluhan_2022(String k) { this.keluhan_2022 = k; }
    public void setNext_2022(Pasien_2511532022 nxt) { this.next_2022 = nxt; }
}
