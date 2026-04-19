package pekan2_2511532022;

public class Musik_2511532022 {
	private String judul_2022;
	private String penyanyi_2022;
	private int durasi_2022;
	
	// Constructor
	public Musik_2511532022(String judul_2022, String penyanyi_2022, int durasi_2022) {
	    this.judul_2022 = judul_2022;
	    this.penyanyi_2022 = penyanyi_2022;
	    this.durasi_2022 = durasi_2022;
	}
	
	// Selektor (Getter)
	public String getJudul_2022() { return judul_2022; }
	public String getPenyanyi_2022() { return penyanyi_2022; }
	public int getDurasi_2022() { return durasi_2022; }
	
	// Mutator (Setter)
	public void setJudul_2022(String judul_2022) { this.judul_2022 = judul_2022; }
	public void setPenyanyi_2022(String penyanyi_2022) { this.penyanyi_2022 = penyanyi_2022; }
	public void setDurasi_2022(int durasi_2022) { this.durasi_2022 = durasi_2022; }
}