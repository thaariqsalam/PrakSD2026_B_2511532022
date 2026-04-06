package pekan2_2511532022;
import java.util.ArrayList;
public class DaftarKata_2511532022 {
    private final ArrayList<String> data;
    public DaftarKata_2511532022() {
        this.data = new ArrayList<>();
    }
    public void tambah(String elemen){
        data.add(elemen);
    }
    public void tambahPada (int index, String elemen){
        data.add(index, elemen);
    }
    public void ubahElemen (int index, String nilaiBaru) {
        data.set(index, nilaiBaru);
    }
    public String hapusElemen (int index) {
        return data.remove(index);
    }
    public void iterasiCetak() {
        for (int i=0; i<data.size(); i++) {
            System.out.println(data.get(i)+ " ");
        }
    }
    public String get(int index) {
        return data.get(index);
    }
    @Override
    public String toString() {   
        return data.toString();
    }   
}