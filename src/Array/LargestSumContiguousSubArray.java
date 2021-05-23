package Array;
/*
    Program to Find largest sum contiguous sub array of non-negative number:-
 */

import java.io.*;

public class LargestSumContiguousSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String inputLine[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int res[] = largestSubArray(arr);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

    private static int[] largestSubArray(int[] arr) {
        long max = Long.MIN_VALUE, max_curr = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                max_curr += arr[i];
                if (max_curr>=max) {
                    max = max_curr;
                    end = i;
                    start = s;
                }
            } else {
                max_curr = 0;
                s = i+1;
            }
        }
        int res[] = new int[end - start + 1];
        int j = 0;
        if (start==0 && end==0 & arr[0]<0) {
            res[0] = -1;
            return res;
        }
        for (int i = start; i <= end; i++, j++) {
            res[j] = arr[i];
        }
        return res;
    }
}
