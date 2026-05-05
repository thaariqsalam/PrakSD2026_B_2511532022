package pekan5_2511532022;

public class PencariSLL_2511532022 {
	static boolean searchKey (NodeSLL head_2022, int key_2022) {
		NodeSLL curr = head_2022;
		while (curr != null) {
			if (curr.data_2022 == key_2022) 
				return true;
				curr = curr.next_2022;
		}
		return false;
	}
	public static void traversal(NodeSLL head_2022) {
		//mulai dari head
		NodeSLL curr = head_2022;
		//telusuri sampai pointer null
		while (curr != null) {
			System.out.print(" " + curr.data_2022);
			curr = curr.next_2022;
		}
		System.out.println();
	}
	public static void main (String[]args) {
		NodeSLL head = new NodeSLL (14);
		head.next_2022 = new NodeSLL (21);
		head.next_2022.next_2022 = new NodeSLL (13);
		head.next_2022.next_2022.next_2022 = new NodeSLL (30);
		head.next_2022.next_2022.next_2022.next_2022 = new NodeSLL (10);
		System.out.print(" penelusuran SLL : ");
		traversal (head);
		int key = 30;
		System.out.println(" cari data " + key + " = ");
		if (searchKey(head,key)) {
			System.out.println("ketemu");
		} else {
			System.out.println("tidak ada");
		}
	}
}
