package Array;
/*
    Program to reverse an array using:-
    1.Using for loop (In this, we only print the array in reverse order not changing the array.)
    2.Using recursion (In this, we first reverse the array and then print the array)
    2.Using Iteration (In this, we first reverse the array and then print the array)
 */

import java.io.*;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            reverseArray(arr, n);
            reverseArrayUsingRecursion(arr, 0, n - 1);
            reverseArrayUsingIterative(arr, 0, n - 1);
        }
    }

    //reverse array using for loop
    private static void reverseArray(int arr[], int n) {
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //reverse array using recursion
    private static void reverseArrayUsingRecursion(int[] arr, int l, int r) {
        int temp;
        if (l >= r) {
            printArray(arr);
            return;
        }
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverseArrayUsingRecursion(arr, l + 1, r - 1);
    }

    //reverse array using Iterative method
    private static void reverseArrayUsingIterative(int[] arr, int l, int r) {
        int temp;
        while (r > l) {
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        printArray(arr);
    }

    //print array
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
