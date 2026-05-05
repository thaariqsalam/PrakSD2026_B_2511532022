package pekan5_2511532022;

public class HapusSLL_2511532022 {
	public static NodeSLL_2511532022 deleteHead (NodeSLL_2511532022  head_2022) {
		if (head_2022 == null)
			return null;
		head_2022 = head_2022.next_2022;
		return head_2022;
	}
	public static NodeSLL_2511532022  removeLastNode (NodeSLL_2511532022  head_2022) {
		if (head_2022 == null) {
			return null;
		}
		if (head_2022.next_2022 == null) {
			return null;
		}
		NodeSLL_2511532022  secondLast = head_2022;
		while (secondLast.next_2022.next_2022 != null) {
			secondLast = secondLast.next_2022;
		}
		secondLast.next_2022 = null;
		return head_2022;
		}
	
	public static NodeSLL_2511532022  deleteNode( NodeSLL_2511532022  head_2022, int position_2022) {
		NodeSLL_2511532022  temp = head_2022;
		NodeSLL_2511532022  prev = null;
		//
		if (temp == null)
			return head_2022;
		//
		if (position_2022 == 1) {
			head_2022 = temp.next_2022;
			return head_2022;
		}
		//
		//
	for (int i=1; temp != null && i< position_2022; i++) {
		prev = temp;
		temp = temp.next_2022;
	}
	if (temp != null) {
		prev.next_2022 = temp.next_2022;
	} else {
		System.out.println("Data tidak ada");
		}
	return head_2022;
	}
	
	public static void printList (NodeSLL_2511532022  head_2022) {
		NodeSLL_2511532022  curr = head_2022;
		while (curr.next_2022 != null) {
			System.out.print(curr.data_2022 + "--->");
			curr = curr.next_2022;
		}
		if (curr.next_2022 == null) {
			System.out.print(curr.data_2022);
		}
		System.out.println();
	}
	
	public static void main (String []args) {
		//
		NodeSLL_2511532022  head_2022 = new NodeSLL_2511532022 (1);
		head_2022.next_2022 = new NodeSLL_2511532022  (2);
		head_2022.next_2022.next_2022 = new NodeSLL_2511532022  (3);
		head_2022.next_2022.next_2022.next_2022 = new NodeSLL_2511532022  (4);
		head_2022.next_2022.next_2022.next_2022.next_2022 = new NodeSLL_2511532022  (5);
		head_2022.next_2022.next_2022.next_2022.next_2022.next_2022 = new NodeSLL_2511532022  (6);
		//
		System.out.print("list awal: ");
		printList(head_2022);
		//
		head_2022 = deleteHead(head_2022);
		System.out.print("List setelah head dihapus: ");
		printList(head_2022);
		//
		head_2022= removeLastNode(head_2022);
		System.out.print("List setelah simpul terakhir: ");
		printList(head_2022);
		//
		int position = 2;
		head_2022 = deleteNode(head_2022, position);
		//
		System.out.print("List setelah posisi 2 dihapus: ");
		printList(head_2022);
	}
}



















