package Array;
/*
    Program to Find the Duplicate Number in an n+1 array:-
    Method 1- Place the array element to element value-1 index and check every element present in appropriate place,
              if not then it is a repeating number.
    Method 2- Traverse the array from start to end, take its absolute value and if the abs(array[i])‘th element is positive,
              the element has not encountered before, else if negative the element has been encountered.
    Method 3- Two pointer approach ( Floyd’s cycle finding algorithm to detect loop).
    Method 4- Traverse the array from start to end, increase the array[array[i]%n] by n in every occurrence, then again traverse
              array and divide by n, if it is greater then one then it is duplicate number (work in multiple occurrence of a number).
 */

import java.io.*;
import java.util.ArrayList;

public class DuplicateInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            String inputLine[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            findDuplicate1(arr);
            findDuplicate2(arr);
            findDuplicate3(arr);
            findDuplicate4(arr);
        }
    }

    private static void findDuplicate1(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != i+1 && arr[i] != arr[arr[i]-1]) {
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[arr[i]-1] = temp;
            }
        }
        for (int i=0; i<arr.length; i++) {
            if (i+1 != arr[i]) {
                System.out.println(i+" " +arr[i]);
            }
        }
    }

    private static void findDuplicate2(int[] arr) {
        int i;
        for (i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

    private static void findDuplicate3(int[] arr) {
        int fast = arr[0];
        int slow = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        while (slow != fast);

        fast = arr[0];
        while (fast != slow) {
            fast = arr[fast];
            slow = arr[slow];
        }
        System.out.println(fast);
    }

    private static void findDuplicate4(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }
        int flag = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+" "+(arr[i] / n)+" "+((arr[i] / n) > 1));
            if ((arr[i] / n) > 1) {
                ans.add(i);
                flag = 1;
            }
        }
        if (flag == 0) ans.add(-1);
        for (int i: ans) {
            System.out.print(i);
        }
    }
}
