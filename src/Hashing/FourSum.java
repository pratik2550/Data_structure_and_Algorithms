package Hashing;
/*
    Program to find sum of four element in an array equals to given target.
 */

import java.io.*;
import java.util.*;

public class FourSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        int target = Integer.parseInt(br.readLine());

        System.out.println(countSun1(arr, target));
//        System.out.println(countSun2(arr, target));
    }

    private static HashSet<List<Integer>> countSun1(int[] arr, int target) {
        Arrays.sort(arr);
        HashSet<List<Integer>> pair = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int tar = target - arr[i] - arr[j] - arr[k];
                    int l = k + 1, r = arr.length-1;
                    int mid = binarySearch(arr, l, r, tar);
                    if (mid == Integer.MIN_VALUE) {
                        break;
                    }
                     List<Integer> quad = new ArrayList<>();
                    quad.add(arr[i]);
                    quad.add(arr[j]);
                    quad.add(arr[k]);
                    quad.add(arr[mid]);
                    pair.add(quad);
//                    while (k+1<arr.length && arr[k+1]==quad.get(2)) ++k;
                }
//                while (j+1<arr.length && arr[j+1] == arr[j]) ++j;
            }
//            while (i+1<arr.length && arr[i+1] == arr[i]) ++i;
        }
        return pair;
    }

    private static int binarySearch(int[] arr, int l, int r, int tar) {
        if (l <= r) {
            int mid = l+(r - l) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] > tar) {
                return binarySearch(arr, l, mid - 1, tar);
            } else {
                return binarySearch(arr, mid + 1, r, tar);
            }
        }
        return Integer.MIN_VALUE;
    }

    private static List<List<Integer>> countSun2(int[] arr, int target) {
        List<List<Integer>> pair = new ArrayList<>();
        if (arr==null || arr.length==0) {
            return pair;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int l = j + 1, r = arr.length - 1;
                int tar = target - arr[i] - arr[j];
                while (l < r) {
                    if (arr[l] + arr[r] < tar) {
                        l++;
                    } else if (arr[l] + arr[r] > tar) {
                        r--;
                    } else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[l]);
                        quad.add(arr[r]);
                        pair.add(quad);
                        while (l<r && arr[l]==quad.get(2)) ++l;
                        while (l<r && arr[r]==quad.get(3)) --r;
                    }
                }
                while (j+1<arr.length && arr[j+1] == arr[j]) ++j;
            }
            while (i+1<arr.length && arr[i+1] == arr[i]) ++i;
        }
        return pair;
    }
}
