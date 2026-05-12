package pekan6_2511532022;

public class HapusDLL_2511532022 {
	//fungsi menambah node di awal
	public static NodeDLL_2511532022 delHead (NodeDLL_2511532022 head_2022) {
		if (head_2022 == null) {
			return null;
		}
		NodeDLL_2511532022 temp = head_2022;
		head_2022 = head_2022.next_2022;
		if (head_2022 != null) {
			head_2022.prev_2022 = null;
		}
		return head_2022;
	}
	
	//fungsi menghapus di akhir
	public static NodeDLL_2511532022 delLast (NodeDLL_2511532022 head_2022) {
		if (head_2022 == null) {
			return null;
		}
		if (head_2022.next_2022 == null) {
			return null;
		}
		NodeDLL_2511532022 curr_2022 = head_2022;
		while (curr_2022.next_2022 != null) {
			curr_2022 = curr_2022.next_2022;
		}
		//update pointer previous node
		if (curr_2022.prev_2022 != null) {
			curr_2022.prev_2022.next_2022 = null;
		}
		return head_2022;
	}
	
	public static NodeDLL_2511532022 delPos (NodeDLL_2511532022 head_2022, int pos) {
		if (head_2022 == null) {
			return  head_2022;
		}
		NodeDLL_2511532022 curr_2022 = head_2022;
		for (int i = 1; curr_2022 != null && i < pos; ++i) {
			curr_2022 = curr_2022.next_2022;
		}
		if (curr_2022 == null) {
			return head_2022;
		}
		if (curr_2022.prev_2022 != null) {
			curr_2022.prev_2022.next_2022 = curr_2022.next_2022;
		}
		if (curr_2022.next_2022 != null) {
			curr_2022.next_2022.prev_2022 = curr_2022.prev_2022;
		}
		if (head_2022 == curr_2022) {
			head_2022 = curr_2022.next_2022;
		}
		return head_2022;
	}
	
	public static void printList(NodeDLL_2511532022 head_2022) {
		NodeDLL_2511532022 curr_2022 = head_2022;
		while ( curr_2022 != null) {
			System.out.print(curr_2022.data_2022 + " ");
			curr_2022 = curr_2022.next_2022;
		}
		System.out.println();
	}
	
	public static void main (String[]args) {
		//buat sebuah DLL
		NodeDLL_2511532022 head_2022 = new NodeDLL_2511532022(1);
		head_2022.next_2022 = new NodeDLL_2511532022(2);
		head_2022.next_2022.prev_2022 = head_2022;
		head_2022.next_2022.next_2022 = new NodeDLL_2511532022(3);
		head_2022.next_2022.next_2022.prev_2022 = head_2022.next_2022;
		head_2022.next_2022.next_2022.next_2022 = new NodeDLL_2511532022(4);
		head_2022.next_2022.next_2022.next_2022.prev_2022 = head_2022.next_2022.next_2022;
		head_2022.next_2022.next_2022.next_2022.next_2022 = new NodeDLL_2511532022(5);
		head_2022.next_2022.next_2022.next_2022.next_2022.prev_2022 = head_2022.next_2022.next_2022.next_2022;
		
		System.out.print("DLL Awal: ");
		printList(head_2022);
		
		System.out.print("Setelah head_2022 dihapus: ");
		head_2022 = delHead(head_2022);
		printList(head_2022);
		
		System.out.print("Setelah node terakhir dihapus: ");
		head_2022 = delLast(head_2022);
		printList(head_2022);
		
		System.out.print("menghapus node ke 2: ");
		head_2022 = delPos(head_2022, 2);
		printList(head_2022);
		
	}

}

















