package Heap;

import java.io.*;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }
        mergeKSortedArrays(arr, n);

    }

    private static void mergeKSortedArrays(int[][] arr, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans[] = new int[n*n];
        Pair pair[] = new Pair[n];
        for(int i=0; i<n; i++) {
            queue.add(arr[i][0]);
            pair[i] = new Pair(0, arr[i][0]);
        }
        int x=0;
        while (x<n*n) {
            if(!queue.isEmpty()) {
                ans[x] = queue.poll();
            }
            for(int i=0; i<n; i++) {
                int temp = pair[i].ind+1;
                if(ans[x]==pair[i].val && temp<n) {
                    pair[i] = new Pair(temp, arr[i][temp]);
                    queue.add(arr[i][temp]);
                }
            }
            x++;
        }
        for(int a : ans) {
            System.out.print(a + " ");
        }
    }
}

class Pair{
        int ind;
        int val;
        Pair(int i, int v) {
            ind = i;
            val = v;
        }
}
