package pekan4_2511532022;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class IterasiQueue_251153022 {
	public static void main (String[]args) {
		Queue<String> q_2022 = new LinkedList<>();
		
		q_2022.add("Pratikum");
		q_2022.add("Struktur");
		q_2022.add("Data");
		q_2022.add("Dan");
		q_2022.add("Algoritma");
		Iterator<String> iterator = q_2022 .iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
	}

}
