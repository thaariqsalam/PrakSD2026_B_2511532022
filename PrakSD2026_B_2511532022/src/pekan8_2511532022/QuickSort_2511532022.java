package pekan8_2511532022;

public class QuickSort_2511532022 {
    
    static void swap(int[] arr_2022, int i_2022, int j_2022) {
        int temp_2022 = arr_2022[i_2022];
        arr_2022[i_2022] = arr_2022[j_2022];
        arr_2022[j_2022] = temp_2022;
    }
    
    // Metode tambahan untul mengatur pivot menggunakan Median of three
    static void medianOfThree(int[] arr_2022, int low_2022, int high_2022) {
        int mid_2022 = low_2022 + (high_2022 - low_2022) / 2;
        
        // Urutkan elemen low, mid, dan high
        if (arr_2022[low_2022] > arr_2022[mid_2022]) {
            swap(arr_2022, low_2022, mid_2022);
        }
        if (arr_2022[low_2022] > arr_2022[high_2022]) {
            swap(arr_2022, low_2022, high_2022);
        }
        if (arr_2022[mid_2022] > arr_2022[high_2022]) {
            swap(arr_2022, mid_2022, high_2022);
        }
        swap(arr_2022, mid_2022, high_2022);
    }
    
    static int partition(int[] arr_2022, int low_2022, int high_2022) {
        // Panggil fungsi medianOfThree sebelum menentukan pivot
        medianOfThree(arr_2022, low_2022, high_2022);
        
        int pivot_2022 = arr_2022[high_2022];
        int i_2022 = (low_2022 - 1);
        
        // Menggunakan j < high agar logika partisi berjalan tepat
        for (int j_2022 = low_2022; j_2022 < high_2022; j_2022++) {
            // Jika elemen saat ini lebih kecil dari atau sama dengan pivot
            if (arr_2022[j_2022] < pivot_2022) {
                // Increment indeks elemen yang lebih kecil
                i_2022++;
                swap(arr_2022, i_2022, j_2022);
            }
        }
        swap(arr_2022, i_2022 + 1, high_2022);
        return (i_2022 + 1);
    }
    
    static void quickSort(int[] arr_2022, int low_2022, int high_2022) {
        if (low_2022 < high_2022) {
            int pi_2022 = partition(arr_2022, low_2022, high_2022);
            quickSort(arr_2022, low_2022, pi_2022 - 1);
            quickSort(arr_2022, pi_2022 + 1, high_2022);
        }
    }

    public static void printArr(int[] arr_2022) {
        for (int i_2022 = 0; i_2022 < arr_2022.length; i_2022++) {
            System.out.print(arr_2022[i_2022] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args_2022) {
        int[] arr_2022 = { 10, 7, 8, 9, 1, 5 };
        int N_2022 = arr_2022.length;
        System.out.print("Data sebelum diurutkan: ");
        printArr(arr_2022);

        quickSort(arr_2022, 0, N_2022 - 1);

        System.out.print("Data Terurut quicksort: ");
        printArr(arr_2022);
    }
}