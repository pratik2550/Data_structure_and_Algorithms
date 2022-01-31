package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
//        int arr[][] = {{1,5,9}, {10,11,13},{12,13,15}};
        int arr[][] = {{-5}};
        int k = 1;

        System.out.println(kthSmallestElement(arr, k));
    }

    private static int kthSmallestElement(int[][] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] i:arr) {
            for(int ele: i) {
                if(pq.size()<k) {
                    pq.add(ele);
                } else if (ele<pq.peek()) {
                    pq.poll();
                    pq.add(ele);
                }
            }
        }
        return pq.peek();
    }
}
