package pekan4_2511532022;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList_2511532022 {
	public static void main (String[]args) {
		Queue<Integer> q_2022  = new LinkedList<>();
		// tambah elemen (0,1,2,3,4,5) ke antrian
		for (int i = 0; i < 6; i++)
			q_2022.add(i);
		//menampilkan isi antrian
		System.out.println(" Elemen antrian " + q_2022 );
		//menghapus kepala antrian
		int hapus = q_2022.remove();
		System.out.println(" Hapus elemen = " + hapus);
		System.out.println(q_2022);
		//untuk melihat antrian terdepann
		int depan = q_2022.peek();
		System.out.println("kepala antrian = " + depan);
		int banyak = q_2022.size();
		System.out.println("size antrian = " + banyak);
	}
}
