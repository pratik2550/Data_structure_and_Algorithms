package Hashing;
/*
    Program to count the number of sub array with given XOR
    XOR operation
     0000  1111  1100
    ^0000 ^1111 ^1010
     ----  ----  ----
     0000  0000  0110

     XOR operation give 0 for same bit and 1 for opposite bit.
 */

import java.io.*;
import java.util.HashMap;

public class SubarrayWithGivenXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        int target = Integer.parseInt(br.readLine());

        System.out.println(countGivenXOR1(arr, target));
        System.out.println(countSun2(arr, target));
    }

    private static int countGivenXOR1(int[] arr, int target) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            int xor = 0;
            for (int j=i; j<arr.length; j++) {
                xor = arr[j]^xor;
                if (xor==target) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countSun2(int[] arr, int target) {
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            xor = xor^arr[i];
            if (map.get(xor^target)!=null) {
                count += map.get(xor^target);
            }
            if (xor==target) {
                count++;
            }
            if (map.get(xor)!=null) {
                map.put(xor, map.get(xor)+1);
            } else {
                map.put(xor, 1);
            }
        }
        return count;
    }
}
