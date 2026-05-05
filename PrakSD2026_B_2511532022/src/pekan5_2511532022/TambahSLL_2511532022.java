package pekan5_2511532022;

public class TambahSLL_2511532022 {
	public static NodeSLL_2511532022 insertAtFront(NodeSLL_2511532022 head_2022, int value_2022) {
		NodeSLL_2511532022 new_node = new NodeSLL_2511532022(value_2022);
		new_node.next_2022= head_2022;
		return new_node;
	}
	//fungsi menambahakan node di akhir SLL
	public static NodeSLL_2511532022 insertAtEnd (NodeSLL_2511532022 head_2022, int value_2022) {
		//buat sebuah node dengan sebuah nilai
		NodeSLL_2511532022 newNode = new NodeSLL_2511532022(value_2022);
		//jika list kosong maka node jadi head
		if (head_2022 == null) {
			return newNode;
		}
		//simpan head ke variabel sementara
		NodeSLL_2511532022 last = head_2022;
		//telusuri ke node akhir
		while(last.next_2022 != null) {
			last = last.next_2022;
		}
		//ubah pointer
		last.next_2022 = newNode;
		return head_2022;
	}
	static NodeSLL_2511532022 GetNode (int data_2022) {
		return new NodeSLL_2511532022(data_2022);
	}
	static NodeSLL_2511532022 insertPos(NodeSLL_2511532022 headNode_2022, int position_2022, int value_2022) {
		NodeSLL_2511532022 head_2022 = headNode_2022;
		if(position_2022 <1 ) {
			System.out.print("invalid position");
		}
		if (position_2022 == 1) {
			NodeSLL_2511532022 new_node_2022 = new NodeSLL_2511532022 (value_2022);
			new_node_2022.next_2022 = head_2022;
			return new_node_2022;
		} else {
			while (position_2022 -- != 0) {
				if (position_2022 == 1) {
					NodeSLL_2511532022 newNode = GetNode(value_2022);
					newNode.next_2022 = headNode_2022.next_2022;
					headNode_2022.next_2022 = newNode ;
					break;
				}
				headNode_2022 = headNode_2022.next_2022;
			}
			if (position_2022 != 1) 
				System.out.print("posisi di luar jangkauan");
				}
			return head_2022;
			}
			
	public static void printList (NodeSLL_2511532022 head_2022) {
		NodeSLL_2511532022 curr = head_2022;
		while (curr.next_2022 != null) {
			System.out.print (curr.data_2022 + "-->");
			curr = curr.next_2022;
		}
		if (curr.next_2022== null) {
			System.out.print(curr.data_2022);
		}
		System.out.println();
	}
	
	public static void main (String[]args) {
		//
		NodeSLL_2511532022 head_2022 = new NodeSLL_2511532022(2);
		head_2022.next_2022 = new NodeSLL_2511532022(3);
		head_2022.next_2022 = new NodeSLL_2511532022 (5);
		head_2022.next_2022.next_2022 = new NodeSLL_2511532022 (6);
		//
		System.out.print("senarai berantai awal: ");
		printList(head_2022);
		//
		System.out.print("tambah 1 simpul didepan: ");
		int data_2022 = 1 ;
		head_2022 = insertAtFront(head_2022, data_2022);
		//
		printList (head_2022);
		//
		System.out.print("tambah 1 simpul dibelakang: ");
		int data2_2022 =7;
		head_2022 = insertAtEnd(head_2022, data2_2022);
		//
		printList(head_2022);
		System.out.print("tambah 1 simpul ke data 4: ");
		int data3_2022 = 4;
		int pos = 4;
		head_2022 = insertPos(head_2022, pos,data3_2022);
		//
		printList(head_2022);
	}
}
