package Array;
/*
    Program to remove duplicate from sorted array.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println(removeDuplicate(arr));
    }

    private static int removeDuplicate(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                j++;
                arr[j] = arr[i + 1];
            }
        }
        return ++j;
    }
}
