package Heap;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        int n = 4;
        long arr[] = {4, 3, 2, 6};

        System.out.println(minCostOfRopes(arr, n));
    }

    static long minCostOfRopes(long[] arr, int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pq.add(arr[i]);
        }
        long sum = 0;
        while (pq.size()!=1) {
            long x = pq.poll();
            long y = pq.poll();
            sum = x+y+sum;
            pq.add(x+y);
        }
        return sum;
    }
}
