package Heap;

import java.io.*;

public class HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int n = arr.length;
        heapSort(arr, n);
        printHeap(arr, n);
    }

    private static void printHeap(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void heapSort(int[] arr, int n) {
        ImplementHeapUsingArray obj = new ImplementHeapUsingArray();
        obj.buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            int swap = arr[i];
            arr[i] = arr[0];
            arr[0] = swap;

            obj.heapiyf(arr, i, 0);
        }
    }
}
