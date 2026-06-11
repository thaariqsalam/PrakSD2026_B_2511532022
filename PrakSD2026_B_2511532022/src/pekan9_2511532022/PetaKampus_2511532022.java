package pekan9_2511532022;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PetaKampus_2511532022 extends JFrame {
    private Map<String, List<String>> graph_2022 = new HashMap<>();
    private Map<String, Point> positions_2022 = new HashMap<>();
    private List<String> path_2022 = new ArrayList<>();
    private List<String> visitedOrder_2022 = new ArrayList<>();
    
    private JComboBox<String> startCombo_2022;
    private JComboBox<String> goalCombo_2022;
    private JTextArea resultArea_2022;
    private JPanel canvas_2022;

    public PetaKampus_2511532022() {
        setTitle("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS - 2511532022");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initGraphData_2022();
        initComponents_2022();
    }

    private void initGraphData_2022() {
        // Pemetaan posisi node koordinat (X, Y) disesuaikan agar menyebar membentuk peta
        positions_2022.put("Gerbang", new Point(60, 240));
        positions_2022.put("Rektorat", new Point(220, 140));
        positions_2022.put("Auditorium", new Point(220, 340));
        positions_2022.put("Masjid", new Point(380, 240));
        positions_2022.put("Perpus", new Point(380, 80));
        positions_2022.put("FTI", new Point(540, 140));
        positions_2022.put("Dekanat", new Point(540, 340));
        positions_2022.put("GedungA", new Point(700, 80));
        positions_2022.put("GedungB", new Point(700, 240));
        positions_2022.put("LaborAl", new Point(800, 340));

        for (String node : positions_2022.keySet()) {
            graph_2022.put(node, new ArrayList<>());
        }

        // Relasi 16 Sisi (Edge) Tak Berarah
        addEdge_2022("Gerbang", "Rektorat");
        addEdge_2022("Gerbang", "Auditorium");
        addEdge_2022("Rektorat", "Perpus");
        addEdge_2022("Rektorat", "Masjid");
        addEdge_2022("Auditorium", "Masjid");
        addEdge_2022("Auditorium", "Dekanat");
        addEdge_2022("Perpus", "FTI");
        addEdge_2022("Perpus", "GedungA");
        addEdge_2022("Masjid", "FTI");
        addEdge_2022("Masjid", "Dekanat");
        addEdge_2022("FTI", "GedungA");
        addEdge_2022("FTI", "GedungB");
        addEdge_2022("Dekanat", "GedungB");
        addEdge_2022("Dekanat", "LaborAl");
        addEdge_2022("GedungA", "GedungB");
        addEdge_2022("GedungB", "LaborAl");
        
        // Pengurutan alfabetis tetangga simpul
        for (String node : graph_2022.keySet()) {
            Collections.sort(graph_2022.get(node));
        }
    }

    private void addEdge_2022(String u, String v) {
        graph_2022.get(u).add(v);
        graph_2022.get(v).add(u);
    }

    private void initComponents_2022() {
        setLayout(new BorderLayout(10, 10));

        // 1. PANEL ATAS (Header Judul & Input Kontrol)
        JPanel topPanel_2022 = new JPanel(new GridBagLayout());
        topPanel_2022.setBackground(new Color(240, 244, 248));
        GridBagConstraints gbc_2022 = new GridBagConstraints();
        gbc_2022.insets = new Insets(5, 10, 5, 10);
        gbc_2022.gridx = 0;
        gbc_2022.gridy = 0;
        gbc_2022.gridwidth = GridBagConstraints.REMAINDER;
        
        // Label Judul Utama Besar
        JLabel titleLabel_2022 = new JLabel("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        titleLabel_2022.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel_2022.setForeground(new Color(44, 62, 80));
        topPanel_2022.add(titleLabel_2022, gbc_2022);

        // Baris Input Kontrol
        gbc_2022.gridwidth = 1;
        gbc_2022.gridy = 1;
        
        String[] nodes_2022 = positions_2022.keySet().toArray(new String[0]);
        Arrays.sort(nodes_2022);
        startCombo_2022 = new JComboBox<>(nodes_2022);
        goalCombo_2022 = new JComboBox<>(nodes_2022);
        
        JButton btnBFS_2022 = new JButton("BFS");
        JButton btnDFS_2022 = new JButton("DFS");
        JButton btnReset_2022 = new JButton("RESET");

        gbc_2022.gridx = 0; topPanel_2022.add(new JLabel("Lokasi Awal:"), gbc_2022);
        gbc_2022.gridx = 1; topPanel_2022.add(startCombo_2022, gbc_2022);
        gbc_2022.gridx = 2; topPanel_2022.add(new JLabel("Lokasi Tujuan:"), gbc_2022);
        gbc_2022.gridx = 3; topPanel_2022.add(goalCombo_2022, gbc_2022);
        gbc_2022.gridx = 4; topPanel_2022.add(btnBFS_2022, gbc_2022);
        gbc_2022.gridx = 5; topPanel_2022.add(btnDFS_2022, gbc_2022);
        gbc_2022.gridx = 6; topPanel_2022.add(btnReset_2022, gbc_2022);

        add(topPanel_2022, BorderLayout.NORTH);

        // 2. PANEL TENGAH (Visualisasi Graph dengan TitledBorder)
        canvas_2022 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Menggambar Sisi (Edge)
                g2.setColor(Color.LIGHT_GRAY);
                g2.setStroke(new BasicStroke(2));
                Set<String> drawn_2022 = new HashSet<>();
                for (String node : graph_2022.keySet()) {
                    Point p1 = positions_2022.get(node);
                    for (String neighbor : graph_2022.get(node)) {
                        if (!drawn_2022.contains(neighbor + "-" + node)) {
                            Point p2 = positions_2022.get(neighbor);
                            if (isEdgeInPath_2022(node, neighbor)) {
                                g2.setColor(new Color(231, 76, 60)); // Merah tebal untuk jalur hasil rute
                                g2.setStroke(new BasicStroke(4));
                                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                                g2.setColor(Color.LIGHT_GRAY);
                                g2.setStroke(new BasicStroke(2));
                            } else {
                                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                            }
                            drawn_2022.add(node + "-" + neighbor);
                        }
                    }
                }

                // Menggambar Simpul (Node) berbentuk lingkaran
                for (String node : positions_2022.keySet()) {
                    Point p = positions_2022.get(node);
                    if (path_2022.contains(node)) {
                        g2.setColor(new Color(46, 204, 113)); // Hijau: Node bagian jalur akhir
                    } else if (visitedOrder_2022.contains(node)) {
                        g2.setColor(new Color(241, 196, 15)); // Kuning: Sempat dieksplorasi
                    } else {
                        g2.setColor(new Color(52, 73, 94));  // Biru gelap default
                    }
                    
                    g2.fillOval(p.x - 20, p.y - 20, 40, 40);
                    g2.setColor(Color.BLACK);
                    g2.drawOval(p.x - 20, p.y - 20, 40, 40);
                    
                    // Label Teks Nama Node Lokasi
                    g2.setFont(new Font("Arial", Font.BOLD, 12));
                    g2.drawString(node, p.x - 22, p.y - 25);
                }
            }
        };
        canvas_2022.setBackground(Color.WHITE);
        
        // Pembuatan Border Kotak bertuliskan "VISUALISASI GRAPH" sesuai petunjuk tugas
        TitledBorder border_2022 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2), "VISUALISASI GRAPH");
        border_2022.setTitleFont(new Font("Arial", Font.BOLD, 14));
        canvas_2022.setBorder(border_2022);
        
        add(canvas_2022, BorderLayout.CENTER);

        // 3. PANEL BAWAH (Hasil Pencarian Jalur)
        resultArea_2022 = new JTextArea(5, 50);
        resultArea_2022.setEditable(false);
        resultArea_2022.setFont(new Font("Monospaced", Font.BOLD, 13));
        resultArea_2022.setBackground(new Color(245, 245, 245));
        
        TitledBorder resultBorder_2022 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1), "HASIL PENCARIAN JALUR");
        resultArea_2022.setBorder(resultBorder_2022);
        
        add(new JScrollPane(resultArea_2022), BorderLayout.SOUTH);

        // Hubungkan fungsi klik tombol ke fungsi utama
        btnBFS_2022.addActionListener(e -> BFS_2022());
        btnDFS_2022.addActionListener(e -> DFS_2022());
        btnReset_2022.addActionListener(e -> resetGraph_2022());
    }

    private boolean isEdgeInPath_2022(String u, String v) {
        for (int i = 0; i < path_2022.size() - 1; i++) {
            if ((path_2022.get(i).equals(u) && path_2022.get(i+1).equals(v)) ||
                (path_2022.get(i).equals(v) && path_2022.get(i+1).equals(u))) {
                return true;
            }
        }
        return false;
    }

    public void BFS_2022() {
        resetData_2022();
        String start = (String) startCombo_2022.getSelectedItem();
        String goal = (String) goalCombo_2022.getSelectedItem();

        Queue<String> queue_2022 = new LinkedList<>();
        Map<String, String> parent_2022 = new HashMap<>();
        Set<String> visited_2022 = new HashSet<>();

        queue_2022.add(start);
        visited_2022.add(start);
        boolean found_2022 = false;

        while (!queue_2022.isEmpty()) {
            String current = queue_2022.poll();
            visitedOrder_2022.add(current);

            if (current.equals(goal)) {
                found_2022 = true;
                break;
            }

            for (String neighbor : graph_2022.get(current)) {
                if (!visited_2022.contains(neighbor)) {
                    visited_2022.add(neighbor);
                    parent_2022.put(neighbor, current);
                    queue_2022.add(neighbor);
                }
            }
        }
        if (found_2022) reconstructPath_2022(start, goal, parent_2022);
        displayPath_2022("Breadth First Search (BFS)", found_2022);
    }

    public void DFS_2022() {
        resetData_2022();
        String start = (String) startCombo_2022.getSelectedItem();
        String goal = (String) goalCombo_2022.getSelectedItem();

        Map<String, String> parent_2022 = new HashMap<>();
        Set<String> visited_2022 = new HashSet<>();

        dfsHelper_2022(start, visited_2022, parent_2022);
        
        boolean found_2022 = visitedOrder_2022.contains(goal);
        if (found_2022) reconstructPath_2022(start, goal, parent_2022);
        displayPath_2022("Depth First Search (DFS)", found_2022);
    }

    private void dfsHelper_2022(String current, Set<String> visited, Map<String, String> parent) {
        visited.add(current);
        visitedOrder_2022.add(current);

        for (String neighbor : graph_2022.get(current)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, current);
                dfsHelper_2022(neighbor, visited, parent);
            }
        }
    }

    private void reconstructPath_2022(String start, String goal, Map<String, String> parent) {
        String curr = goal;
        while (curr != null) {
            path_2022.add(0, curr);
            curr = parent.get(curr);
        }
    }

    public void displayPath_2022(String algorithm, boolean found) {
        StringBuilder sb_2022 = new StringBuilder();
        sb_2022.append(" Algoritma Pencarian    : ").append(algorithm).append("\n");
        sb_2022.append(" Urutan Node Dikunjungi : ").append(String.join(" -> ", visitedOrder_2022)).append("\n");
        sb_2022.append(" Jumlah Node Dieksplorasi: ").append(visitedOrder_2022.size()).append(" Node\n");
        if (found) {
            sb_2022.append(" Jalur Solusi Utama     : ").append(String.join(" -> ", path_2022));
        } else {
            sb_2022.append(" Jalur Solusi Utama     : Rute tidak ditemukan.");
        }
        resultArea_2022.setText(sb_2022.toString());
        canvas_2022.repaint();
    }

    public void resetGraph_2022() {
        resetData_2022();
        resultArea_2022.setText(" [Info] State graf berhasil dibersihkan ke kondisi semula.");
        canvas_2022.repaint();
    }

    private void resetData_2022() {
        path_2022.clear();
        visitedOrder_2022.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetaKampus_2511532022().setVisible(true);
        });
    }
}