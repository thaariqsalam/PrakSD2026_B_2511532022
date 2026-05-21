package pekan7_2511532022;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SortingMahasiswaGUI_2511532022 extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Mahasiswa_2511532022> listMahasiswa_2022;
	private JTextField txtNama_2022, txtNim_2022, txtProdi_2022;
	private JComboBox<String> cmbAlgoritma_2022;
	private JTable tabelData_2022;
	private DefaultTableModel tableModel_2022;
	private JTextArea txtAreaLog_2022;
	private JButton btnTambah_2022, btnHapus_2022, btnSort_2022;

	public SortingMahasiswaGUI_2511532022() {
		listMahasiswa_2022 = new ArrayList<>();
		setTitle("Visualisasi Pengurutan Data Mahasiswa ");
		setSize(950, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		// Panel Input Form (Barat)
		JPanel panelInput = new JPanel(new GridBagLayout());
		panelInput.setBorder(BorderFactory.createTitledBorder("Form Input Mahasiswa"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0; gbc.gridy = 0; panelInput.add(new JLabel("Nama:"), gbc);
		gbc.gridx = 1; txtNama_2022 = new JTextField(15); panelInput.add(txtNama_2022, gbc);

		gbc.gridx = 0; gbc.gridy = 1; panelInput.add(new JLabel("NIM:"), gbc);
		gbc.gridx = 1; txtNim_2022 = new JTextField(15); panelInput.add(txtNim_2022, gbc);

		gbc.gridx = 0; gbc.gridy = 2; panelInput.add(new JLabel("Prodi:"), gbc);
		gbc.gridx = 1; txtProdi_2022 = new JTextField(15); panelInput.add(txtProdi_2022, gbc);

		JPanel panelTombolForm = new JPanel(new FlowLayout());
		btnTambah_2022 = new JButton("Tambah");
		btnHapus_2022 = new JButton("Hapus");
		panelTombolForm.add(btnTambah_2022);
		panelTombolForm.add(btnHapus_2022);
		gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; panelInput.add(panelTombolForm, gbc);

		// Panel Kontrol Atas (Utara)
		JPanel panelKontrol = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelKontrol.setBorder(BorderFactory.createEtchedBorder());
		cmbAlgoritma_2022 = new JComboBox<>(new String[]{"Insertion Sort", "Selection Sort", "Bubble Sort"});
		btnSort_2022 = new JButton("Mulai Sorting");
		panelKontrol.add(new JLabel("Pilih Algoritma: "));
		panelKontrol.add(cmbAlgoritma_2022);
		panelKontrol.add(btnSort_2022);

		// Panel Data Tengah (Pusat) - JTable & Log Visualisasi
		JPanel panelTengah = new JPanel(new GridLayout(2, 1, 5, 5));
		String[] kolom = {"Nama Mahasiswa", "NIM", "Program Studi"};
		tableModel_2022 = new DefaultTableModel(kolom, 0);
		tabelData_2022 = new JTable(tableModel_2022);
		JScrollPane scrollTabel = new JScrollPane(tabelData_2022);
		scrollTabel.setBorder(BorderFactory.createTitledBorder("Daftar Tabel Mahasiswa"));

		txtAreaLog_2022 = new JTextArea();
		txtAreaLog_2022.setEditable(false);
		txtAreaLog_2022.setFont(new Font("Monospaced", Font.PLAIN, 13));
		JScrollPane scrollLog = new JScrollPane(txtAreaLog_2022);
		scrollLog.setBorder(BorderFactory.createTitledBorder("Log Langkah-Langkah Visualisasi Sorting"));

		panelTengah.add(scrollTabel);
		panelTengah.add(scrollLog);

		// Satukan ke Frame
		add(panelInput, BorderLayout.WEST);
		add(panelKontrol, BorderLayout.NORTH);
		add(panelTengah, BorderLayout.CENTER);

		// Event Listener Tombol
		btnTambah_2022.addActionListener(e -> tambahData());
		btnHapus_2022.addActionListener(e -> hapusData());
		btnSort_2022.addActionListener(e -> eksekusiSorting());
	}

	private void tambahData() {
		String nama = txtNama_2022.getText().trim();
		String nim = txtNim_2022.getText().trim();
		String prodi = txtProdi_2022.getText().trim();

		if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Semua input form wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
			return;
		}

		Mahasiswa_2511532022 mhs = new Mahasiswa_2511532022(nama, nim, prodi);
		listMahasiswa_2022.add(mhs);
		tableModel_2022.addRow(new Object[]{mhs.getNama_2022(), mhs.getNim_2022(), mhs.getProdi_2022()});
		
		txtNama_2022.setText("");
		txtNim_2022.setText("");
		txtProdi_2022.setText("");
	}

	private void hapusData() {
		int barisTerpilih = tabelData_2022.getSelectedRow();
		if (barisTerpilih == -1) {
			JOptionPane.showMessageDialog(this, "Pilih salah satu baris tabel yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
			return;
		}
		listMahasiswa_2022.remove(barisTerpilih);
		tableModel_2022.removeRow(barisTerpilih);
	}

	private void updateTabelDariArrayList() {
		tableModel_2022.setRowCount(0);
		for (Mahasiswa_2511532022 mhs : listMahasiswa_2022) {
			tableModel_2022.addRow(new Object[]{mhs.getNama_2022(), mhs.getNim_2022(), mhs.getProdi_2022()});
		}
	}

	private void eksekusiSorting() {
		if (listMahasiswa_2022.size() < 2) {
			JOptionPane.showMessageDialog(this, "Data mahasiswa minimal harus berjumlah 2 untuk diurutkan!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		txtAreaLog_2022.setText("");
		String opsi = (String) cmbAlgoritma_2022.getSelectedItem();
		
		if (opsi.equals("Insertion Sort")) {
			insertionSort();
		} else if (opsi.equals("Selection Sort")) {
			selectionSort();
		} else if (opsi.equals("Bubble Sort")) {
			bubbleSort();
		}
		
		updateTabelDariArrayList();
	}

	private void insertionSort() {
		txtAreaLog_2022.append("=== INTI LOGIKA INSERTION SORT ===\n");
		txtAreaLog_2022.append("Data Awal: " + listMahasiswa_2022.toString() + "\n\n");
		int n = listMahasiswa_2022.size();
		int langkah = 1;
		
		for (int i_2022 = 1; i_2022 < n; i_2022++) {
			Mahasiswa_2511532022 key_2022 = listMahasiswa_2022.get(i_2022);
			int j_2022 = i_2022 - 1;
			
			while (j_2022 >= 0 && listMahasiswa_2022.get(j_2022).getNama_2022().compareToIgnoreCase(key_2022.getNama_2022()) > 0) {
				listMahasiswa_2022.set(j_2022 + 1, listMahasiswa_2022.get(j_2022));
				j_2022--;
			}
			listMahasiswa_2022.set(j_2022 + 1, key_2022);
			txtAreaLog_2022.append("Langkah " + (langkah++) + " : " + listMahasiswa_2022.toString() + "\n");
		}
		txtAreaLog_2022.append("\nHasil Akhir: " + listMahasiswa_2022.toString() + "\n");
	}

	private void selectionSort() {
		txtAreaLog_2022.append("=== INTI LOGIKA SELECTION SORT ===\n");
		txtAreaLog_2022.append("Data Awal: " + listMahasiswa_2022.toString() + "\n\n");
		int n = listMahasiswa_2022.size();
		int pass = 1;	
		for (int i_2022 = 0; i_2022 < n - 1; i_2022++) {
			int minIndex_2022 = i_2022;
			for (int j_2022 = i_2022 + 1; j_2022 < n; j_2022++) {
				if (listMahasiswa_2022.get(j_2022).getNama_2022().compareToIgnoreCase(listMahasiswa_2022.get(minIndex_2022).getNama_2022()) < 0) {
					minIndex_2022 = j_2022;
				}
			}
			Mahasiswa_2511532022 temp_2022 = listMahasiswa_2022.get(i_2022);
			listMahasiswa_2022.set(i_2022, listMahasiswa_2022.get(minIndex_2022));
			listMahasiswa_2022.set(minIndex_2022, temp_2022);
			txtAreaLog_2022.append("Pass " + (pass++) + " : " + listMahasiswa_2022.toString() + "\n");
		}
		txtAreaLog_2022.append("\nHasil Akhir: " + listMahasiswa_2022.toString() + "\n");
	}

	private void bubbleSort() {
		txtAreaLog_2022.append("=== INTI LOGIKA BUBBLE SORT ===\n");
		txtAreaLog_2022.append("Data Awal: " + listMahasiswa_2022.toString() + "\n\n");
		int n = listMahasiswa_2022.size();
		int pass = 1;
		
		for (int i_2022 = 0; i_2022 < n; i_2022++) {
			boolean adaPertukaran = false;
			for (int j_2022 = 0; j_2022 < n - i_2022 - 1; j_2022++) {
				if (listMahasiswa_2022.get(j_2022).getNama_2022().compareToIgnoreCase(listMahasiswa_2022.get(j_2022 + 1).getNama_2022()) > 0) {
					Mahasiswa_2511532022 temp_2022 = listMahasiswa_2022.get(j_2022);
					listMahasiswa_2022.set(j_2022, listMahasiswa_2022.get(j_2022 + 1));
					listMahasiswa_2022.set(j_2022 + 1, temp_2022);
					adaPertukaran = true;
				}
			}
			txtAreaLog_2022.append("Pass " + (pass++) + " : " + listMahasiswa_2022.toString() + "\n");
			if (!adaPertukaran) break;
		}
		txtAreaLog_2022.append("\nHasil Akhir: " + listMahasiswa_2022.toString() + "\n");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SortingMahasiswaGUI_2511532022().setVisible(true);
		});
	}
}