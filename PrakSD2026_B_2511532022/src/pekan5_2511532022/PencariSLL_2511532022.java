package pekan5_2511532022;

public class PencariSLL_2511532022 {
	static boolean searchKey (NodeSLL_2511532022  head_2022, int key_2022) {
		NodeSLL_2511532022  curr = head_2022;
		while (curr != null) {
			if (curr.data_2022 == key_2022) 
				return true;
				curr = curr.next_2022;
		}
		return false;
	}
	public static void traversal(NodeSLL_2511532022  head_2022) {
		//mulai dari head
		NodeSLL_2511532022  curr = head_2022;
		//telusuri sampai pointer null
		while (curr != null) {
			System.out.print(" " + curr.data_2022);
			curr = curr.next_2022;
		}
		System.out.println();
	}
	public static void main (String[]args) {
		NodeSLL_2511532022  head_2022 = new NodeSLL_2511532022  (14);
		head_2022.next_2022 = new NodeSLL_2511532022  (21);
		head_2022.next_2022.next_2022 = new NodeSLL_2511532022  (13);
		head_2022.next_2022.next_2022.next_2022 = new NodeSLL_2511532022  (30);
		head_2022.next_2022.next_2022.next_2022.next_2022 = new NodeSLL_2511532022  (10);
		System.out.print(" penelusuran SLL : ");
		traversal (head_2022);
		int key_2022 = 30;
		System.out.println(" cari data " + key_2022 + " = ");
		if (searchKey(head_2022,key_2022)) {
			System.out.println("ketemu");
		} else {
			System.out.println("tidak ada");
		}
	}
}
