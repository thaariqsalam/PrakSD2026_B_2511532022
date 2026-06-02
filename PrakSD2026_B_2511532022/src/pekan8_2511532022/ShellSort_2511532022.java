package pekan8_2511532022;

public class ShellSort_2511532022 {
    
    public static void shellSort(int[] A_2022) {
        int n_2022 = A_2022.length;
        int gap_2022 = n_2022 / 2;
        
        while (gap_2022 > 0) {
            for (int i_2022 = gap_2022; i_2022 < n_2022; i_2022++) {
            	//Cetak.p (i_2022 + " " + n_2022);
                int temp_2022 = A_2022[i_2022];
                //System.out.println("temp = posisi indeks ==> " + temp_2022 + "\n");
                int j_2022 = i_2022;
                //System.out.println(j_2022);
                
                while (j_2022 >= gap_2022 && A_2022[j_2022 - gap_2022] > temp_2022) {
                    A_2022[j_2022] = A_2022[j_2022 - gap_2022];
                    j_2022 = j_2022 - gap_2022;
                }
                A_2022[j_2022] = temp_2022;
            }
            gap_2022 = gap_2022 / 2;
        }
    }

    public static void main(String[] args_2022) {
        int[] data_2022 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
        
        System.out.print("Sebelum: ");
        printArray(data_2022);
        
        shellSort(data_2022);
        
        System.out.print("Sesudah (shell sort): ");
        printArray(data_2022);
    }

    public static void printArray(int[] arr_2022) {
        for (int i_2022 : arr_2022) {
            System.out.print(i_2022 + " ");
        }
        System.out.println();
    }
}