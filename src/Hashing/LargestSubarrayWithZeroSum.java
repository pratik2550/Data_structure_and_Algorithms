package Hashing;
/*
    Program to find the length of largest subarray with 0 sum.
 */

import java.io.*;
import java.util.*;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println(zeroSum1(arr));
        System.out.println(zeroSum2(arr));
    }

    private static int zeroSum1(int[] arr) {
        int max_len = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < arr.length; j++) {
                curr_sum += arr[j];
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    private static int zeroSum2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
         int max_length = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (arr[i]==0 && max_length==0) {
                max_length = 1;
            }
            if (sum==0) {
                max_length = i+1;
            }
            Integer check = map.get(sum);
            if (check!= null) {
                max_length = Math.max(max_length, i-check);
            } else {
                map.put(sum, i);
            }
        }
        return max_length;
    }
}
