package Hashing;
/*
    Program to find longest consecutive sequence in an unsorted array.
 */

import java.io.*;
import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println(longestSequence1(arr));
        System.out.println(longestSequence2(arr));
    }

    private static int longestSequence1(int[] arr) {
        if (arr.length==0) {
            return 0;
        }
        Arrays.sort(arr);
        int temp = 1;
        int max = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]!=arr[i-1]) {
                if (arr[i]==arr[i-1]+1) {
                    temp++;
                } else {
                    max = Math.max(temp, max);
                    temp = 1;
                }
            }
        }
        return max;
    }

    private static int longestSequence2(int[] arr) {
        int max=0;
        Set<Integer> set = new HashSet<>();
        for (int i: arr) {
            set.add(i);
        }
        for (int i: arr) {
            if (!set.contains(i-1)) {
                int temp = i;
                int count = 1;
                while (set.contains(temp+1)) {
                    ++count;
                    ++temp;
                }
                max = Math.max(max,count);
            }
        }

        return max;
    }
}
