package pekan4_2511532022;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseData_2511532022 {
	public static void main (String[]args) {
		Queue<Integer> q_2022  = new LinkedList<Integer>();
		q_2022.add(1);
		q_2022.add(2);
		q_2022.add(3);	// (1, 2, 3)
		System.out.println("Sebelum everse" + q_2022 );
		Stack<Integer>  s_2022  = new Stack<Integer>();
		while (!q_2022 .isEmpty()) {
			s_2022 .push(q_2022.remove());			
		}
		while (!s_2022 .isEmpty()) {
			q_2022.add(s_2022 .pop());
		}
		System.out.println("sesudah reverse = " + q_2022 ); //[3, 2, 1]
	}			
}
