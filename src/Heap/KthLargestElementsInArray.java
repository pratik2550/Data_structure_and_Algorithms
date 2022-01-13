package Heap;

import java.io.*;
import java.util.*;

public class KthLargestElementsInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        int k = Integer.parseInt(br.readLine());
        int arr[] = {1, 23, 12, 9, 30, 2, 50};
        int n = 7;
        int k = 3;

        kthLargestElementPriorityQueue(arr, n, k);
        kthLargestElement(arr, n, k);
    }

    //    Using Priority Queue
    private static void kthLargestElementPriorityQueue(int[] arr, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: arr) {
            queue.add(i);
        }
        for(int i=0; i<k; i++) {
            System.out.println(queue.poll());
        }
    }

    //    Using Heapify
    private static void kthLargestElement(int[] arr, int n, int k) {
//        int ans[] = new int[k];
        for(int i=n/2-1; i>=0; i--) {
            heapify(arr, n, i);
        }
        System.out.println(arr[0]);

        for(int i=1; i<k; i++) {
//            ans[i-1] = arr[0];
            arr[0] = arr[n-i];
            heapify(arr, n-i, 0);
            System.out.println(arr[0]);
        }
//        ans[k-1] = arr[0];
//        for(int i: ans) {
//            System.out.println(i);
//        }

    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && arr[left]>arr[largest]) {
            largest = left;
        }
        if(right<n && arr[right]>arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            heapify(arr, n, largest);
        }
    }
}
