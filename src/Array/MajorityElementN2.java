package Array;
/*
    Program to find majority element N/2 in an array.
 */

import java.io.*;

public class MajorityElementN2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i=0; i<inputLine.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println(majorityElement1(arr));
        System.out.println(majorityElement2(arr));
    }

    private static int majorityElement1(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            int count = 1;
            for (int j=i+1; j< arr.length; j++) {
                if (arr[i]==arr[j]) {
                    count++;
                }
            }
            if (count>arr.length/2) {
                return arr[i];
            }
        }
        return 0;
    }

    //Boyer-Moore Voting Algorithm
    private static int majorityElement2(int[] arr) {
        int cand = findCandidate(arr);
        if (checkMajority(arr, cand)) {
            return cand;
        }
        return -1;
    }

    private static boolean checkMajority(int[] arr, int cand) {
        int count=0;
        for (int i: arr) {
            if (i==cand) {
                count++;
            }
        }
        if (count>arr.length/2) {
            return true;
        }
        return false;
    }

    private static int findCandidate(int[] arr) {
        int ind = 0, count = 1, i;
        for (i=1; i<arr.length; i++) {
            if (arr[ind] == arr[i]) {
                count++;
            }
            else {
                count--;
            }
            if (count==0) {
                ind = i;
                count=1;
            }
        }
        return arr[ind];
    }
}
