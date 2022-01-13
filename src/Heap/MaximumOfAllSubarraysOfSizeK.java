package Heap;

import java.io.*;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaximumOfAllSubarraysOfSizeK {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        int k = Integer.parseInt(br.readLine());

        int arr[] = {1,5,2,7,8,4,7,2};
        int n = arr.length;
        int k = 3;

        slidingWindowMaximumHeap(arr, n, k);
        slidingWindowMaximumDeque(arr, n, k);
    }

    private static void slidingWindowMaximumDeque(int[] arr, int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int i;
        for(i=0; i<k; i++) {
            while(!deque.isEmpty() && arr[deque.peekLast()]<=arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for(; i<n; i++) {
            System.out.println(arr[deque.peek()]);

            while(!deque.isEmpty() && deque.peek()<=i-k) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()]<=arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.println(arr[deque.peek()]);
    }

    //    Using MaxHeap
    private static void slidingWindowMaximumHeap(int[] arr, int n, int k) {
        int i=0, j=0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int ans[] = new int[n-k+1];
        while (j<n) {
            maxHeap.add(arr[j]);
            if(!maxHeap.isEmpty() && j-i==k-1) {
                System.out.println(maxHeap.peek());
                maxHeap.remove(arr[i]);
                i++;
                j++;
            }
            if(j-i<k-1) {
                j++;
            }
        }
    }


}
