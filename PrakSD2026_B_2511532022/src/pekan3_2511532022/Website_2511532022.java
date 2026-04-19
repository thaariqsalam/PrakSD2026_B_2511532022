package pekan3_2511532022;

public class Website_2511532022 {
    // Variabel pake akhiran 4 digit NIM sesuai aturan
    private String judul_2022;
    private String url_2022;

    public Website_2511532022(String judul_2022, String url_2022) {
        this.judul_2022 = judul_2022;
        this.url_2022 = url_2022;
    }

    // Method buat update data sekaligus
    public void setDataWeb_2022(String judul, String url) {
        this.judul_2022 = judul;
        this.url_2022 = url;
    }

    // Getter tetap ada satu-satu buat ambil data
    public String getJudul_2022() { return judul_2022; }
    public String getUrl_2022() { return url_2022; }

    // Biar gampang pas mau nampilin info web
    public void infoWeb() {
        System.out.println(judul_2022 + " (" + url_2022 + ")");
    }
}