package pekan7_2511532022;
public class Mahasiswa_2511532022 {
	private String nama_2022;
	private String nim_2022;
	private String prodi_2022;

	public Mahasiswa_2511532022(String nama, String nim, String prodi) {
		this.nama_2022 = nama;
		this.nim_2022 = nim;
		this.prodi_2022 = prodi;
	}

	public String getNama_2022() {
		return nama_2022;
	}

	public void setNama_2022(String nama) {
		this.nama_2022 = nama;
	}

	public String getNim_2022() {
		return nim_2022;
	}

	public void setNim_2022(String nim) {
		this.nim_2022 = nim;
	}

	public String getProdi_2022() {
		return prodi_2022;
	}

	public void setProdi_2022(String prodi) {
		this.prodi_2022 = prodi;
	}

	@Override
	public String toString() {
		return nama_2022 + " (" + nim_2022 + ")";
	}
}