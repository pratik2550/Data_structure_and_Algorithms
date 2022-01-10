package Heap;

import java.io.*;

import static jdk.nashorn.internal.objects.Global.print;

public class ImplementHeapUsingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.valueOf(br.readLine());
//        int arr[] = new int[n];
//        for (int i=0; i<arr.length; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int n = arr.length;
        buildHeap(arr, n);
        printHeap(arr, n);
    }

    private static void printHeap(int[] arr, int n) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        int start = n/2-1;
        for (int i=start; i>=0; i--) {
            heapiyf(arr, n, i);
        }
    }

    private static void heapiyf(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(n>left && arr[left]>arr[largest]) {
            largest = left;
        }
        if(n>right && arr[right]>arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;

            heapiyf(arr, n, largest);

        }
    }
}
