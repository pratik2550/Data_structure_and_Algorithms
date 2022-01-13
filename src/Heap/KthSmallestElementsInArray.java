package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KthSmallestElementsInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        int k = Integer.parseInt(br.readLine());
        int arr[] = {7, 10, 4, 3, 20, 15};
        int n = 6;
        int k = 4;

        kthSmallestElementPriorityQueue(arr, n, k);
        kthLargestElement(arr, n, k);
    }

    private static void kthSmallestElementPriorityQueue(int[] arr, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: arr) {
            queue.add(i);
        }
        for(int i=0; i<k-1; i++) {
            queue.remove();
        }
        System.out.println(queue.peek());
    }

    private static void kthLargestElement(int[] arr, int n, int k) {
        for(int i=n/2-1; i>=0; i--) {
            heapify(arr, n, i);
        }

        for(int i=1; i<k; i++) {
            arr[0] = arr[n-i];
            heapify(arr, n-i, 0);
        }
        System.out.println(arr[0]);
    }

    private static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && arr[left]<arr[smallest]) {
            smallest = left;
        }
        if(right<n && arr[right]<arr[smallest]) {
            smallest = right;
        }
        if(smallest != i) {
            int swap = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = swap;
            heapify(arr, n, smallest);
        }
    }
}
