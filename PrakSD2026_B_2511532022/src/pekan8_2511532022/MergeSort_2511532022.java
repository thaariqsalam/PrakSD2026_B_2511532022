package pekan8_2511532022;

public class MergeSort_2511532022 {
    
    void merge(int arr_2022[], int l_2022, int m_2022, int r_2022) {
        // Find sizes of two subarrays to be merged
        int n1_2022 = m_2022 - l_2022 + 1;
        int n2_2022 = r_2022 - m_2022;

        /* Create temp arrays */
        int L_2022[] = new int[n1_2022];
        int R_2022[] = new int[n2_2022];

        /* Copy data to temp arrays */
        for (int i_2022 = 0; i_2022 < n1_2022; ++i_2022) {
            L_2022[i_2022] = arr_2022[l_2022 + i_2022];
        }
        for (int j_2022 = 0; j_2022 < n2_2022; ++j_2022) {
            R_2022[j_2022] = arr_2022[m_2022 + 1 + j_2022];
        }

        int i_2022 = 0, j_2022 = 0;
        
        // Initial index of merged subarray array
        int k_2022 = l_2022;
        while (i_2022 < n1_2022 && j_2022 < n2_2022) {
            if (L_2022[i_2022] <= R_2022[j_2022]) {
                arr_2022[k_2022] = L_2022[i_2022];
                i_2022++;
            } else {
                arr_2022[k_2022] = R_2022[j_2022];
                j_2022++;
            }
            k_2022++;
        }
        
        /* Copy remaining elements of L[] if any */
        while (i_2022 < n1_2022) {
            arr_2022[k_2022] = L_2022[i_2022];
            i_2022++;
            k_2022++;
        }
        
        /* Copy remaining elements of R[] if any */
        while (j_2022 < n2_2022) {
            arr_2022[k_2022] = R_2022[j_2022];
            j_2022++;
            k_2022++;
        }
    }   
    
    void sort(int arr_2022[], int l_2022, int r_2022) {
        if (l_2022 < r_2022) {
            // Find the middle point
            int m_2022 = (l_2022 + r_2022) / 2;

            // Sort first and second halves
            sort(arr_2022, l_2022, m_2022);
            sort(arr_2022, m_2022 + 1, r_2022);

            // Merge the sorted halves
            merge(arr_2022, l_2022, m_2022, r_2022);
        }
    }
    /* A utility function to print array of size n */
    static void printArray(int arr_2022[]) {
        int n_2022 = arr_2022.length;
        for (int i_2022 = 0; i_2022 < n_2022; ++i_2022)
            System.out.print(arr_2022[i_2022] + " ");
        System.out.println();
    }
    public static void main(String args_2022[]) {
        int arr_2022[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Sebelum terurut");
        printArray(arr_2022);

        MergeSort_2511532022 ob_2022 = new MergeSort_2511532022();
        ob_2022.sort(arr_2022, 0, arr_2022.length - 1);

        System.out.println("\nSesudah Terurut menggunakan merge Sort");
        printArray(arr_2022);
    }
}