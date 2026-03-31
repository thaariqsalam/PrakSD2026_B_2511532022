package pekan1_2511532022;

public class JamDriver_2511532022 {
    public static void main(String[] args) {
        // Deklarasi objek 'a' dan 'b' yang benar
        Jam_2511532022 a = new Jam_2511532022(23, 59, 50);
        Jam_2511532022 b = new Jam_2511532022(0, 0, 15);

        System.out.println("a              = " + a);
        System.out.println("b              = " + b);
        System.out.println("a+b            = " + a.plus(b));
        System.out.println("next 20s       = " + a.nextNSeconds(20));
        
        // Memanggil method static durasiDetik dari class Jam_2511532022
        System.out.println("durasi(a,b)    = " + Jam_2511532022.durasiDetik(a, b));
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
    }
}