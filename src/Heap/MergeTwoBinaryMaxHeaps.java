package Heap;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeTwoBinaryMaxHeaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr1[] = new int[n];
        int arr2[] = new int[m];
        for(int i=0; i<n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }
        for(int j=0; j<m; j++) {
            arr2[j] = Integer.parseInt(br.readLine());
        }
        mergeBinaryHeaps(arr1, arr2, n, m);
    }

    private static void mergeBinaryHeaps(int[] arr1, int[] arr2, int n, int m) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int ans[] = new int[n+m];
        queue.add(arr1[0]);
        queue.add(arr2[0]);
        int i=1, j=1, k=0;
        while(i<n || j<m) {
            if(!queue.isEmpty()) {
                ans[k++]=queue.peek();
                int top = queue.poll();
                if (top == arr1[i-1] && i<n) {
                    queue.add(arr1[i++]);
                } else if (top == arr2[j-1] && j<m) {
                    queue.add(arr2[j++]);
                }
            }
        }
        while (!queue.isEmpty()) {
            ans[k++] = queue.poll();
        }
        for(int a: ans) {
            System.out.println(a);
        }
    }
}
//10 3
//        12 11 7 7 5 5 3 2 1 1
//        9 5 1
