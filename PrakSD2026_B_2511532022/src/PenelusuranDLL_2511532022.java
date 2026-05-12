package pekan6_2511532022;

public class PenelusuranDLL_2511532022 {
	//fungsi penelusuran maju
	static void forwardTraversal (NodeDLL_2511532022 head_2022) {
		//memulai penelusuran dari head_2022
		NodeDLL_2511532022 curr_2022 = head_2022;
		
		//lanjutkan sampai akhir
		while (curr_2022 != null) {
			//print data_2022
			System.out.print(curr_2022.data_2022 + " <-> ");
			
			//pindah ke node berikutnya
			curr_2022 = curr_2022.next_2022;
		}		
		//print spasi
		System.out.println();
	}
	
	//fungsi penelusuran mundur
	static void backwardTraversal(NodeDLL_2511532022 tail_2022) {
		//memulai penelusuran dari tail_2022
		NodeDLL_2511532022 curr_2022 = tail_2022;
		//lanjutkan sampai head_2022
		while (curr_2022 != null) {
			//print data_2022
			System.out.print(curr_2022.data_2022 + " <-> ");
			
			//pindah ke node sebelumnya
			curr_2022 = curr_2022.prev_2022;
		}
		//print spasi
		System.out.println();
	}
	
	// Tambahkan 'static' agar bisa dirun
	public static void main (String[]args) {
		//cetak DLL
		NodeDLL_2511532022 head_2022 = new NodeDLL_2511532022(1);
		NodeDLL_2511532022 second_2022 = new NodeDLL_2511532022(2);
		NodeDLL_2511532022 third_2022 = new NodeDLL_2511532022(3);
		
		head_2022.next_2022 = second_2022;
		second_2022.prev_2022 = head_2022;
		second_2022.next_2022 = third_2022;
		third_2022.prev_2022 = second_2022;
		
		System.out.println("Penelusuran maju: ");
		forwardTraversal (head_2022);
		
		System.out.println("Penelusuran mundur: ");
		backwardTraversal (third_2022);
	}
	
}