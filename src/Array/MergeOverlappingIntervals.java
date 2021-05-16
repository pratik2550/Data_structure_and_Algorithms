package Array;
/*
    Program to Merge overlapping Interval:-
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[n][2];
            for (int i=0; i<n; i++) {
                String inputLine[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(inputLine[0]);
                arr[i][1] = Integer.parseInt(inputLine[1]);
            }

            mergeIntervals1(arr);
        }
    }

    private static void mergeIntervals1(int[][] arr) {
        if (arr.length<=1) {
            return;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0] ;
            }
        });

        int index = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[index][1]>=arr[i][0] && arr[index][0]<=arr[i][0]) {
                arr[index][1] = Math.max(arr[index][1], arr[i][1]);
                arr[index][0] = Math.min(arr[index][0], arr[i][0]);
            } else {
                index++;
                arr[index] = arr[i];
            }
        }
        int res[][] = new int[index+1][2];
        for (int i=0; i<=index; i++) {
            res[i][0] = arr[i][0];
            res[i][1] = arr[i][1];
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }

}