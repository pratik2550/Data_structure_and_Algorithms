package Array;
/*
    Program to find the maximum consecutive occurrence of ones in binary array.
 */

import java.io.*;

public class MaxConsecutiveOnes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println(maxConsecutiveOnes(arr));
    }

    private static int maxConsecutiveOnes(int[] arr) {
        int max=0;
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
