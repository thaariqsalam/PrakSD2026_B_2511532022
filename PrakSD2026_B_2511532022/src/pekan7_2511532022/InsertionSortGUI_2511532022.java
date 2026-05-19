package pekan7_2511532022;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class InsertionSortGUI_2511532022 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_2022;
	private JLabel[] labelArray_2022;
	private JButton stepButton_2022, resetButton_2022, setButton_2022;
	private JTextField inputField_2022;
	private JPanel panelArray_2022;
	private JTextArea stepArea_2022;
	
	private int i_2022 = 1, j_2022;
	private boolean sorting_2022 = false;
	private int stepCount_2022 = 1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InsertionSortGUI_2511532022() {
		setTitle("Insertion Sort Langkah per Langkah");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Panel input
		JPanel inputPanel = new JPanel(new FlowLayout());
		inputField_2022 = new JTextField(30);
		setButton_2022 = new JButton("Set Array");
		inputPanel.add(new JLabel("Masukkan angka (pisahkan dengan koma): "));
		inputPanel.add(inputField_2022);
		inputPanel.add(setButton_2022);
		
		//Panel array_2022 visual
		panelArray_2022 = new JPanel();
		panelArray_2022.setLayout(new FlowLayout());
		
		//Panel kontrol
		JPanel controlPanel = new JPanel();
		stepButton_2022 = new JButton ("Langkah Selanjutnya");
		resetButton_2022 = new JButton ("Reset");
		stepButton_2022.setEnabled(false);
		controlPanel.add(stepButton_2022);
		controlPanel.add(resetButton_2022);
	
		//Area teks untuk log langkah langkah
		stepArea_2022 = new JTextArea(8, 60);
		stepArea_2022.setEditable(false);
		stepArea_2022.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane (stepArea_2022);
		
		//Tambahkan panel ke frame
		add(inputPanel, BorderLayout.NORTH);
		add(panelArray_2022, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		add(scrollPane, BorderLayout.EAST);
		
		//Event Set Array
		setButton_2022.addActionListener(e -> setArrayFromInput());
		
		//Event Set Array
		stepButton_2022.addActionListener(e -> performStep());
		
		//Event Set Array
		resetButton_2022.addActionListener(e -> reset());
	}
	
	public void setArrayFromInput() {
		String text = inputField_2022.getText().trim();
		if (text.isEmpty()) return;
		String[] parts = text.split(",");
		array_2022 = new int[parts.length];
		try {
			for (int k = 0; k < parts.length; k++) {
				array_2022[k] = Integer.parseInt(parts[k].trim()); }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan " 
					+ "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return; }
		i_2022 = 1;
		stepCount_2022 = 1;
		sorting_2022 = true;
		stepButton_2022.setEnabled(true);
		stepArea_2022.setText("");
		panelArray_2022.removeAll();
		labelArray_2022 = new JLabel[array_2022.length];
		for (int k = 0; k < array_2022.length; k++) {
				labelArray_2022[k] = new JLabel (String.valueOf(array_2022[k]));
				labelArray_2022[k].setFont (new Font("Arial", Font.BOLD, 24));
				labelArray_2022[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				labelArray_2022[k].setPreferredSize(new Dimension(50, 50));
				labelArray_2022[k].setHorizontalAlignment(SwingConstants.CENTER);
				panelArray_2022.add(labelArray_2022[k]);
		}
		panelArray_2022.revalidate();
		panelArray_2022.repaint();
	}
	
	private void performStep() {
		if (i_2022 < array_2022.length && sorting_2022) {
			int key = array_2022[i_2022];
			j_2022 = i_2022 - 1;
			
			StringBuilder stepLog = new StringBuilder();
			stepLog.append("Langkah ").append(stepCount_2022).
			append(": Memasukkan ").append(key).append("\n");
			
			while(j_2022 >= 0 && array_2022[j_2022] > key) {
				array_2022[j_2022+1] = array_2022[j_2022];
				j_2022--;
			}
			array_2022[j_2022+1] = key;
			
			updateLabels();
			stepLog.append("Hasil: ").append(arrayToString(array_2022)).append("\n\n");
			stepArea_2022.append(stepLog.toString());
			
			i_2022++;
			stepCount_2022++;
			
			if (i_2022== array_2022.length) {
				sorting_2022 = false;
				stepButton_2022.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Sorting selesai");
			}
		}
	}
	
	private void updateLabels() {
		for(int k = 0; k < array_2022.length; k++) {
			labelArray_2022[k].setText(String.valueOf(array_2022[k]));
		}
	}
	private void reset() {
		inputField_2022.setText("");
		panelArray_2022.removeAll();
		panelArray_2022.revalidate();
		panelArray_2022.repaint();
		stepArea_2022.setText("");
		stepButton_2022.setEnabled(false);
		sorting_2022 = false;
		i_2022 = 1;
		stepCount_2022 = 1;
	}
	private String arrayToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < array_2022.length; k++) {
			sb.append(arr[k]);
			if (k < array_2022.length - 1) sb.append(", ");
		}
		return sb.toString();
	}
	public static void main (String[]args) {
		SwingUtilities.invokeLater(() -> {
			InsertionSortGUI_2511532022 gui = new InsertionSortGUI_2511532022();
			gui.setVisible(true);
		});
	}
}