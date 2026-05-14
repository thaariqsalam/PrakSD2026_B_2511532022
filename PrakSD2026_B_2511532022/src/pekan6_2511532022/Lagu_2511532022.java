package pekan6_2511532022;

public class Lagu_2511532022 {
    private String judul_2022;
    private String penyanyi_2022;
    Lagu_2511532022 next_2022;
    Lagu_2511532022 prev_2022;

    // constructor
    public Lagu_2511532022(String judul_2022, String penyanyi_2022) {
        this.judul_2022 = judul_2022;
        this.penyanyi_2022 = penyanyi_2022;
        this.next_2022 = null;
        this.prev_2022 = null;
    }

    // getter dan setter
    public String getJudul_2022() { return judul_2022; }
    public void setJudul_2022(String judul_2022) { this.judul_2022 = judul_2022; }
    public String getPenyanyi_2022() { return penyanyi_2022; }
    public void setPenyanyi_2022(String penyanyi_2022) { this.penyanyi_2022 = penyanyi_2022; }
}