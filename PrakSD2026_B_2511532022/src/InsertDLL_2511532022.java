package pekan6_2511532022;

public class InsertDLL_2511532022 {
	static NodeDLL_2511532022 insertBegin (NodeDLL_2511532022 head_2022, int data_2022) {
		//buat node baru
		NodeDLL_2511532022 new_node_2022 = new NodeDLL_2511532022(data_2022);
		//jadikan pointer next_2022-nya head_2022
		new_node_2022.next_2022 = head_2022;
		//jadikan pointer prev_2022-nya head_2022 ke new_node
		if (head_2022 != null) {
			head_2022 .prev_2022  = new_node_2022 ;
		}
		return new_node_2022 ;	
	}
	
	//fungsi menambahkan node diakhir
	public static NodeDLL_2511532022  insertEnd(NodeDLL_2511532022 head_2022 , int newData_2022 ) {
		//buat node baru
		NodeDLL_2511532022  newNode_2022  = new NodeDLL_2511532022 (newData_2022 );
		//jika dll null jadikan head_2022
		if (head_2022  == null) {
			head_2022  = newNode_2022 ;
		}
		else {
			NodeDLL_2511532022  curr_2022  = head_2022 ;
			while (curr_2022 .next_2022  != null) {
				curr_2022  = curr_2022 .next_2022 ;
			}
			curr_2022 .next_2022  = newNode_2022 ;
			newNode_2022 .prev_2022  = curr_2022 ;
		}
		return head_2022 ;
	}
	
	//fungsi menambahkan node diposisi tertentu
	public static NodeDLL_2511532022 insertAtPosition(NodeDLL_2511532022 head_2022, int pos, int new_data) {
		//buat node baru
		NodeDLL_2511532022 new_node = new NodeDLL_2511532022(new_data);
		if (pos == 1) {
			new_node.next_2022 = head_2022;
			if(head_2022 != null) {
				head_2022.prev_2022 = new_node;
			}
			head_2022 = new_node;
			return head_2022;
		}
		NodeDLL_2511532022 curr_2022 = head_2022;
		for (int i = 1; i < pos - 1 && curr_2022 != null; ++i) {
			curr_2022 = curr_2022.next_2022;}
			if(curr_2022 == null) {
				System.out.println("posisi tidak ada");
				return head_2022;
			}
			new_node.prev_2022 = curr_2022;
			new_node.next_2022 = curr_2022.next_2022;
			curr_2022.next_2022 = new_node;
			if (new_node.next_2022 != null) {
				new_node.next_2022.prev_2022 = new_node;
			}
			return head_2022;
	}
	public static void printList(NodeDLL_2511532022 head_2022) {
		NodeDLL_2511532022 curr_2022 = head_2022;
		while (curr_2022 != null) {
			System.out.print(curr_2022.data_2022 + "<-> ");
			curr_2022 = curr_2022.next_2022;
		}
		System.out.println();
	}
	
	public static void main(String[]args) {
		//membuat dll 2 <-> 3 <-> 5
		NodeDLL_2511532022 head_2022 = new NodeDLL_2511532022(2);
		head_2022.next_2022 = new NodeDLL_2511532022(3);
		head_2022.next_2022.prev_2022 = head_2022;
		head_2022.next_2022.next_2022 = new NodeDLL_2511532022(5);
		head_2022.next_2022.next_2022.prev_2022 = head_2022.next_2022;
		//cetak DLL awal
		System.out.print("DLL awal: ");
		printList(head_2022);
		//tambah 1 di awal
		head_2022 = insertBegin(head_2022,1);
		System.out.print("simpul 1 ditambah di awal: ");
		printList(head_2022);
		//tambah 6 di akhir
		System.out.print("simpul 6 ditambah di akhir: ");
		int data = 6;
		head_2022 = insertEnd (head_2022,data);
		printList(head_2022);
		//menambah node 4 di posisi 4
		System.out.print("tambah node 4 di posisi 4: ");
		int data2 = 4;
		int pos = 4;
		head_2022 = insertAtPosition(head_2022, pos, data2);
		printList(head_2022);
		
	}
}
