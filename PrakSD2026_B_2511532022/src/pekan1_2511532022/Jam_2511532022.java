package pekan1_2511532022;

public class Jam_2511532022 {
    private int hh; // 0..23
    private int mm; // 0..59
    private int ss; // 0..59

    // ---validator---
    public static boolean isValid(int h, int m, int s) {
        return (0 <= h && h <= 23) && (0 <= m && m <= 59) && (0 <= s && s <= 59);
    }

    // ---konstruktor---
    public Jam_2511532022(int h, int m, int s) {
        // Sebaiknya tambahkan validasi di sini juga
        this.hh = h;
        this.mm = m;
        this.ss = s;
    }

    // ---selektor---
    public int getHour() { return hh; }
    public int getMinute() { return mm; } // Perbaikan typo: geMinute -> getMinute
    public int getSecond() { return ss; }

    // ---mutator---
    public void setHour(int h) { this.hh = h; }
    public void setMinute(int m) { this.mm = m; } // Perbaikan typo: setHMinute -> setMinute
    public void setSecond(int s) { this.ss = s; }

    // ---konversi---
    public int toSeconds() {
        return hh * 3600 + mm * 60 + ss;
    }

    public static Jam_2511532022 fromSeconds(int total) {
        // Gunakan floorMod supaya jika total detik negatif (saat pengurangan), 
        // jamnya tetap valid (putar balik ke 23:59:xx)
        int secondsInDay = 24 * 3600;
        int positiveTotal = Math.floorMod(total, secondsInDay);
        
        int h = positiveTotal / 3600;
        int m = (positiveTotal % 3600) / 60; // Perbaikan logika: m harus sisa dari jam
        int s = positiveTotal % 60;          // Perbaikan logika: s harus sisa dari menit
        return new Jam_2511532022(h, m, s);
    }

    // ---relational---
    public int compareTo(Jam_2511532022 other) {
        return Integer.compare(this.toSeconds(), other.toSeconds());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jam_2511532022)) return false;
        Jam_2511532022 j = (Jam_2511532022) o; // Harus di-cast dulu
        return hh == j.hh && mm == j.mm && ss == j.ss;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(hh, mm, ss);
    }

    // ---aritmatika---
    public Jam_2511532022 plus(Jam_2511532022 other) {
        return fromSeconds(this.toSeconds() + other.toSeconds());
    }

    public Jam_2511532022 minus(Jam_2511532022 other) {
        return fromSeconds(this.toSeconds() - other.toSeconds());
    }

    public Jam_2511532022 nextSecond() {
        return fromSeconds(this.toSeconds() + 1);
    }

    // Menambahkan parameter 'n' yang tadi kurang di kode kamu
    public Jam_2511532022 nextNSeconds(int n) { 
        return fromSeconds(this.toSeconds() + Math.max(0, n));
    }

    public Jam_2511532022 prevSecond() {
        return fromSeconds(this.toSeconds() - 1);
    }

    public Jam_2511532022 prevNSeconds(int n) { 
        return fromSeconds(this.toSeconds() - Math.max(0, n));
    }

    // --- durasi ---
    public static int durasiDetik(Jam_2511532022 jaw, Jam_2511532022 jakh) {
        return jakh.toSeconds() - jaw.toSeconds();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
}