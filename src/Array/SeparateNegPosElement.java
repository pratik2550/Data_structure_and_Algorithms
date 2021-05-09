package Array;
/*
    Program to Move all negative numbers to beginning and positive to end with constant extra space using:-
    1.Using Iteration
    2.Using two pointer Approach
 */

import java.io.*;

public class SeparateNegPosElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            separateUsingIteration(arr, n);
            separateUsingTwoPointer(arr, n);
        }
    }

    //separation using Iteration method
    private static void separateUsingIteration(int[] arr, int n) {
        int j = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        printArray(arr);
    }

    //separation using two pointer method
    private static void separateUsingTwoPointer(int[] arr, int n) {
        int neg = 0; //left pointer
        int pos = n - 1; //right pointer
        while (neg <= pos) {
            //if both left and right pointer elements are -ve then increase left pointer
            if (arr[neg] < 0 && arr[pos] < 0) {
                neg++;
            }
            //if left pointer element is +ve and right pointer element is -ve then swap both pointer element
            else if (arr[neg] > 0 && arr[pos] < 0) {
                int temp = arr[pos];
                arr[pos] = arr[neg];
                arr[neg] = temp;
                neg++;
                pos--;
            }
            //if both pointer elements are +ve then decrease right pointer
            else if (arr[neg] > 0 && arr[pos] > 0) {
                pos--;
            }
            else {
                neg++;
                pos--;
            }
        }
    }

    //print array
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
