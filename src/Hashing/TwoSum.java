package Hashing;
/*
    Program to find the indices of two number in an array such that they add up to given a number.
 */

import java.io.*;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        int target = Integer.parseInt(br.readLine());

//        int res[] = sunIndex1(arr, target);
        int res[] = sunIndex2(arr, target);
        System.out.println(res[0]+" "+res[1]);
    }

    private static int[] sunIndex1(int[] arr, int target) {
        int res[] = new int[2];
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    private static int[] sunIndex2(int[] arr, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            if (map.containsKey(target- arr[i])) {
                res[1] = arr[i];
                res[0] = map.get(target-arr[i]);
                return res;
            }
            map.put(arr[i], i);
        }
        return res;
    }
}