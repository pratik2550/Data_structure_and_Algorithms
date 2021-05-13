package Array;
/*
    Program to sort array of 0's, 1's and 2's with constant extra space and O(n) time complexity using:-
    Two pointer Approach
 */

import java.io.*;

public class SortArrayOf012 {

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

            sort012(arr, n);
        }
    }

    //method to sort array of 0, 1, & 2
    private static void sort012(int[] arr, int n) {
        int left = 0, mid = 0, right = n - 1;
        while (mid <= right) {
            int temp;
            switch (arr[mid]) {
                case 0:
                    temp = arr[mid];
                    arr[mid] = arr[left];
                    arr[left] = temp;
                    left++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = arr[right];
                    arr[right] = arr[mid];
                    arr[mid] = temp;
                    right--;
                    break;
            }
        }
        printArray(arr);
    }

    //print array
    private static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
