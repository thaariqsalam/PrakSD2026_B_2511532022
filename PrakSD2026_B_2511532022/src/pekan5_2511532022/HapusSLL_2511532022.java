package pekan5_2511532022;

public class HapusSLL_2511532022 {
	public static NodeSLL deleteHead (NodeSLL head_2022) {
		if (head_2022 == null)
			return null;
		head_2022 = head_2022.next_2022;
		return head_2022;
	}
	public static NodeSLL removeLastNode (NodeSLL head_2022) {
		if (head_2022 == null) {
			return null;
		}
		if (head_2022.next_2022 == null) {
			return null;
		}
		NodeSLL secondLast = head_2022;
		while (secondLast.next_2022.next_2022 != null) {
			secondLast = secondLast.next_2022;
		}
		secondLast.next_2022 = null;
		return head_2022;
		}
	
	public static NodeSLL deleteNode( NodeSLL head_2022, int position_2022) {
		NodeSLL temp = head_2022;
		NodeSLL prev = null;
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
	
	public static void printList (NodeSLL head_2022) {
		NodeSLL curr = head_2022;
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
		NodeSLL head_2022 = new NodeSLL (1);
		head_2022.next_2022 = new NodeSLL (2);
		head_2022.next_2022.next_2022 = new NodeSLL (3);
		head_2022.next_2022.next_2022.next_2022 = new NodeSLL (4);
		head_2022.next_2022.next_2022.next_2022.next_2022 = new NodeSLL (5);
		head_2022.next_2022.next_2022.next_2022.next_2022.next_2022 = new NodeSLL (6);
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



















