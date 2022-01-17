package Heap;

import java.io.*;
import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        int k = Integer.parseInt(br.readLine());

        int a[] = new int[]{10, -10, 20, -40};
        int n = a.length;
        int k = 6;

        System.out.println(kthLargestSum(a, n, k));
    }

    private static int kthLargestSum(int[] arr, int n, int k) {
        int sum[] = new int[n+1];
        sum[0] = 0;
        sum[1] = arr[0];
        for(int i=2; i<=n; i++) {
            sum[i] = sum[i-1]+arr[i-1];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=n; i++) {
            for(int j=i; j<=n; j++) {
                int x = sum[j]-sum[i-1];

                if(k > queue.size()) {
                    queue.add(x);
                } else if(queue.peek()<x){
                    queue.remove();
                    queue.add(x);
                }
            }
        }
        return queue.poll();
    }
}
