package Hashing;
/*
    Program to count the number of pairs with given sum in an array.
 */

import java.io.*;
import java.util.HashMap;

public class PairWithGivenSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        int target = Integer.parseInt(br.readLine());

        System.out.println(countSun1(arr, target));
        System.out.println(countSun2(arr, target));
    }

    private static int countSun1(int[] arr, int target) {
        int count =0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    count ++;
                }
            }
        }
        return count;
    }

    private static int countSun2(int[] arr, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            int rr = target-arr[i];
            if(mp.containsKey(rr))
            {
                count += mp.get(rr);
            }
            mp.put(arr[i],mp.get(arr[i])==null?1:mp.get(arr[i])+1);
        }
        return count;
    }
}
