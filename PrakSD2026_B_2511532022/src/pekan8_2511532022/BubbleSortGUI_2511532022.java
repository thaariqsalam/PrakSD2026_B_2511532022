package pekan8_2511532022;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BubbleSortGUI_2511532022 extends JFrame {

	private static final long serialVersionUID = 1L;
	private int[] array_2022;
	private JLabel[] labelArray_2022;
	private JButton stepButton_2022, resetButton_2022, setButton_2022;
	private JTextField inputField_2022;
	private JPanel panelArray_2022;
	private JTextArea stepArea_2022;

	private int i_2022 = 0, j_2022 = 0;
	private boolean sorting_2022 = false;
	private int stepCount_2022 = 1;

	public BubbleSortGUI_2511532022() {
		setTitle("Bubble Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// panel input
		JPanel inputPanel_2022 = new JPanel(new FlowLayout());
		inputField_2022 = new JTextField(30);
		setButton_2022 = new JButton("Set Array");
		inputPanel_2022.add(new JLabel("Masukan angka (pisahkan dengan koma)"));
		inputPanel_2022.add(inputField_2022);
		inputPanel_2022.add(setButton_2022);

		// panel array visual
		panelArray_2022 = new JPanel();
		panelArray_2022.setLayout(new FlowLayout());

		// panel kontrol
		JPanel controlPanel_2022 = new JPanel();
		stepButton_2022 = new JButton("Langkah selanjutnya");
		resetButton_2022 = new JButton("Reset");
		controlPanel_2022.add(stepButton_2022);
		controlPanel_2022.add(resetButton_2022);

		// area text untuk log langkah langkah
		stepArea_2022 = new JTextArea(8, 60);
		stepArea_2022.setEditable(false);
		stepArea_2022.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane_2022 = new JScrollPane(stepArea_2022);

		// tambahkan panel ke frame
		add(inputPanel_2022, BorderLayout.NORTH);
		add(panelArray_2022, BorderLayout.CENTER);
		add(controlPanel_2022, BorderLayout.SOUTH);
		add(scrollPane_2022, BorderLayout.EAST);

		// event set array
		setButton_2022.addActionListener(e -> setArrayFromInput_2022());

		// event selanjutnya
		stepButton_2022.addActionListener(e -> performStep_2022());

		// event reset
		resetButton_2022.addActionListener(e -> reset_2022());
	}

	private void setArrayFromInput_2022() {
		String text_2022 = inputField_2022.getText().trim();
		if (text_2022.isEmpty()) return;
		String[] parts_2022 = text_2022.split(",");
		array_2022 = new int[parts_2022.length];
		try {
			for (int k = 0; k < parts_2022.length; k++) {
				array_2022[k] = Integer.parseInt(parts_2022[k].trim());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukkan hanya angka "
					+ "yang dipisahkan koma!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		i_2022 = 0;
		j_2022 = 0;
		stepCount_2022 = 1;
		sorting_2022 = true;
		stepButton_2022.setEnabled(true);
		stepArea_2022.setText("");
		panelArray_2022.removeAll();
		labelArray_2022 = new JLabel[array_2022.length];
		for (int k = 0; k < array_2022.length; k++) {
			labelArray_2022[k] = new JLabel(String.valueOf(array_2022[k]));
			labelArray_2022[k].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_2022[k].setOpaque(true);
			labelArray_2022[k].setBackground(Color.WHITE);
			labelArray_2022[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_2022[k].setPreferredSize(new Dimension(50, 50));
			labelArray_2022[k].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_2022.add(labelArray_2022[k]);
		}

		panelArray_2022.revalidate();
		panelArray_2022.repaint();
	}

	private void performStep_2022() {
		if (!sorting_2022 || i_2022 >= array_2022.length - 1) {
			sorting_2022 = false;
			stepButton_2022.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
			return;
		}

		resetHighlights_2022();
		StringBuilder stepLog_2022 = new StringBuilder();

		labelArray_2022[j_2022].setBackground(Color.CYAN);
		labelArray_2022[j_2022 + 1].setBackground(Color.CYAN);

		if (array_2022[j_2022] > array_2022[j_2022 + 1]) {
			// Swap
			int temp_2022 = array_2022[j_2022];
			array_2022[j_2022] = array_2022[j_2022 + 1];
			array_2022[j_2022 + 1] = temp_2022;
			labelArray_2022[j_2022].setBackground(Color.RED);
			labelArray_2022[j_2022 + 1].setBackground(Color.RED);
			stepLog_2022.append("Langkah ").append(stepCount_2022).append(": Menukar elemen ke-")
					.append(j_2022).append(" (").append(array_2022[j_2022 + 1]).append(") dengan ke-")
					.append(j_2022 + 1).append(" (").append(array_2022[j_2022]).append(")\n");
		} else {
			stepLog_2022.append("Langkah ").append(stepCount_2022).append(": Tidak ada pertukaran antara ke-")
					.append(j_2022).append(" dan ke-").append(j_2022 + 1).append("\n");
		}

		stepLog_2022.append("Hasil: ").append(arrayToString_2022(array_2022)).append("\n\n");
		stepArea_2022.append(stepLog_2022.toString());
		updateLabels_2022();

		j_2022++;
		if (j_2022 >= array_2022.length - i_2022 - 1) {
			j_2022 = 0;
			i_2022++;
		}
		stepCount_2022++;

		if (i_2022 >= array_2022.length - 1) {
			sorting_2022 = false;
			stepButton_2022.setEnabled(false);
			JOptionPane.showMessageDialog(this, "Sorting selesai!");
		}
	}

	private void updateLabels_2022() {
		for (int k = 0; k < array_2022.length; k++) {
			labelArray_2022[k].setText(String.valueOf(array_2022[k]));
		}
	}

	private void resetHighlights_2022() {
		for (JLabel label : labelArray_2022) {
			label.setBackground(Color.WHITE);
		}
	}

	private void reset_2022() {
		inputField_2022.setText("");
		panelArray_2022.removeAll();
		panelArray_2022.revalidate();
		panelArray_2022.repaint();
		stepArea_2022.setText("");
		stepButton_2022.setEnabled(false);
		sorting_2022 = false;
		i_2022 = 0;
		j_2022 = 0;
		stepCount_2022 = 1;
	}

	private String arrayToString_2022(int[] arr) {
		StringBuilder sb_2022 = new StringBuilder();
		for (int k = 0; k < arr.length; k++) {
			sb_2022.append(arr[k]);
			if (k < arr.length - 1) sb_2022.append(", ");
		}
		return sb_2022.toString();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BubbleSortGUI_2511532022 gui = new BubbleSortGUI_2511532022();
			gui.setVisible(true);
		});
	}
}