package Array;
/*
    Program to Find largest contiguous sub array sum:-
 */

import java.io.*;

public class KadanesAlgorithem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            String inputLine[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            maxSubArray1(arr);
            maxSubArray2(arr);

        }
    }

    private static void maxSubArray2(int[] arr) {
        int max = arr[0], curr_max = arr[0];
        for (int i=0; i<arr.length; i++) {
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            max = Math.max(max, curr_max);
        }
        System.out.println(max);
    }

    private static void maxSubArray1(int[] arr) {
        int max=Integer.MIN_VALUE, max_curr = 0;
        for (int i=0; i<arr.length; i++) {
            max_curr += arr[i];
            if (max_curr>max) {
                max = max_curr;
            }
            if (max_curr<0) {
                max_curr=0;
            }
        }
        System.out.println(max);
    }
}
