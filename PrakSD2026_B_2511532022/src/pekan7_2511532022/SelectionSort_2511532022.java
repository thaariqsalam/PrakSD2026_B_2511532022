package pekan7_2511532022;

public class SelectionSort_2511532022 {
	public static void selectionSort(int[] arr) {
		int n_2022 = arr.length;
		for (int i_2022 = 0; i_2022 < n_2022; i_2022++) {
			int minIndex_2022 = i_2022;
			for (int j_2022 = i_2022 + 1; j_2022 < n_2022; j_2022++) {
				if (arr[j_2022] < arr[minIndex_2022]) {
					minIndex_2022 = j_2022;
				}
			}
			int temp_2022 = arr[i_2022];
			arr[i_2022] = arr[minIndex_2022];
			arr[minIndex_2022] = temp_2022;
		}
	}
	public static void main (String[]args) {
		int arr[] = {23, 78, 45, 8, 32, 56, 1};
		int n_2022= arr.length;
		System.out.printf("array yang belum terurut: \n");
		for (int i_2022 = 0; i_2022 < n_2022; i_2022++) {
			System.out.print(arr[i_2022] + " ");
			}
		System.out.println(" ");
		selectionSort(arr);
		System.out.printf("array yang terurut: \n");
		for (int i_2022=0; i_2022 < n_2022; i_2022++) {
			System.out.print(arr[i_2022] + " ");
		}
		System.out.println(" ");
	}
}
