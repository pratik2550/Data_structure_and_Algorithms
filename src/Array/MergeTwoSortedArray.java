package Array;
/*
    Program to merge two sorted array:-
    Method 1- Start comparing from first element of arrays
    Method 2- Start comparing from last element of arrays
    Method 3- Start comparing from first element of arrays and swap small element of array2 with last element of array1
    Method 4- Gap method
 */

import java.io.*;
import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String size[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(size[0]);
            int m = Integer.parseInt(size[1]);
            String lineInput1[] = br.readLine().trim().split(" ");
            String inputLine2[] = br.readLine().trim().split(" ");
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(lineInput1[i]);
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine2[i]);
            }

            merge1(arr1, arr2);
            merge2(arr1, arr2);
            merge3(arr1, arr2);
            merge4(arr1, arr2);

            for (int i = 0; i < n; i++) {
                System.out.print(arr1[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < m; i++) {
                System.out.print(arr2[i] + " ");
            }
        }
    }

    //Method 1
    //Start comparing from first element of arrays
    //if element of array2 is less with element of array1 then swap element and sort array2
    //increase pointer1 of array 1
    private static void merge1(int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0, temp;
        while (p1 < arr1.length) {
            if (arr1[p1] > arr2[p2]) {
                temp = arr1[p1];
                arr1[p1] = arr2[p2];
                arr2[p2] = temp;
                int p21 = p2;
                while (p21 + 1 < arr2.length) {
                    if (arr2[p21] > arr2[p21 + 1]) {
                        temp = arr2[p21];
                        arr2[p21] = arr2[p21 + 1];
                        arr2[p21 + 1] = temp;
                    }
                    p21++;
                }
            }
            p1++;
        }
        p2 = 0;
        while (p2 < arr2.length - 1) {
            if (arr2[p2] > arr2[p2 + 1]) {
                temp = arr2[p2 + 1];
                arr2[p2 + 1] = arr2[p2];
                arr2[p2] = temp;
            } else {
                p2++;
            }
        }
    }

    //Method 2
    //store the last element of array1
    //start comparing from last element of arrays2 and second last element of array1
    //if element of array1 is larger then element of array2 store the array2 element in last position of array1
    private static void merge2(int[] arr1, int[] arr2) {
        for (int i=arr2.length-1; i>=0; i--) {
            int j, last = arr1[arr1.length-1];
            for (j= arr1.length-2; j>=0 && arr1[j]>arr2[i]; j--) {
                arr1[j+1] = arr1[j];
            }

            if (j!= arr1.length-2 || last > arr2[i]) {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }

    //Method 3
    //start comparing from first element of arrays
    //if element of array2 is less then element of array1 then swap the element of array2 with last element of array1
    //sort the array1 and array2
    private static void merge3(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0, k = n - 1;
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    //Method 4
    //We start comparing elements that are far from each other rather than adjacent.
    //For every pass, we calculate the gap and compare the elements towards the right of the gap.
    // //Every pass, the gap reduces to the ceiling value of dividing by 2.
    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    private static void merge4(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap))
        {
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap])
                {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }

            for (j = gap > n ? gap - n : 0;
                 i < n && j < m;
                 i++, j++)
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }

            if (j < m)
            {
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap])
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }
}
