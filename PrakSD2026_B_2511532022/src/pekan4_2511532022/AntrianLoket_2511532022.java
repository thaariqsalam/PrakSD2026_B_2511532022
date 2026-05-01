package pekan4_2511532022;

import java.util.Stack;

public class AntrianLoket_2511532022 {
    public int front_2022, rear_2022, size_2022;
    public int max_2022;
    public String[] queue_2022;

    public AntrianLoket_2511532022(int capacity_2022) {
        this.max_2022 = capacity_2022;
        this.front_2022 = this.size_2022 = 0;
        this.rear_2022 = capacity_2022 - 1;
        this.queue_2022 = new String[this.max_2022];
    }

    boolean isFull_2022(AntrianLoket_2511532022 q) {
        return (q.size_2022 == q.max_2022);
    }

    boolean isEmpty_2022(AntrianLoket_2511532022 q) {
        return (q.size_2022 == 0);
    }

    void enqueue_2022(String item_2022) {
        if (isFull_2022(this)) {
            System.out.println("Antrian penuh!");
            return;
        }
        this.rear_2022 = (this.rear_2022 + 1) % this.max_2022;
        this.queue_2022[this.rear_2022] = item_2022;
        this.size_2022 = this.size_2022 + 1;
        System.out.println(item_2022 + " berhasil ditambahkan ke antrian");
    }

    String dequeue_2022() {
        if (isEmpty_2022(this)) {
            return "Antrian kosong!";
        }
        String item_2022 = this.queue_2022[this.front_2022];
        this.front_2022 = (this.front_2022 + 1) % this.max_2022;
        this.size_2022 = this.size_2022 - 1;
        return item_2022;
    }

    void display_2022() {
        if (isEmpty_2022(this)) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Isi antrian saat ini:");
        int count = 0;
        int i = this.front_2022;
        while (count < this.size_2022) {
            System.out.println((count + 1) + ". " + queue_2022[i]);
            i = (i + 1) % this.max_2022;
            count++;
        }
    }

    void reverse_2022() {
        if (isEmpty_2022(this)) return;
        
        Stack<String> s_2022 = new Stack<>();
        int count = 0;
        int i = this.front_2022;
        
        // Pindahkan elemen ke stack untuk membalikkan urutan
        while (count < this.size_2022) {
            s_2022.push(queue_2022[i]);
            i = (i + 1) % this.max_2022;
            count++;
        }
        
        // Kembalikan elemen ke queue (urutan otomatis terbalik karena LIFO)
        int j = this.front_2022;
        while (!s_2022.isEmpty()) {
            queue_2022[j] = s_2022.pop();
            j = (j + 1) % this.max_2022;
        }
        System.out.println("Antrian berhasil dibalik (Reverse).");
    }
}