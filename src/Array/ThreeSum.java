package Array;
/*
    Program to find sum of three number equals to given number;
 */

import java.io.*;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        int k = Integer.parseInt(br.readLine());
        System.out.print(zeroThreeSum(arr, k));
    }

    private static List<List<Integer>> zeroThreeSum(int[] arr, int k) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || (i > 0 & arr[i] != arr[i - 1])) {
                int left = i + 1, right = arr.length - 1;
                int sum = k - arr[i];
                while (left < right) {
                    if (arr[left] + arr[right] == sum) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(arr[i]); ans.add(arr[left]); ans.add(arr[right]);
                        res.add(ans);
                        while (left < right && arr[left + 1] == arr[left]) left++;
                        while (left < right && arr[right - 1] == arr[right]) right--;
                        left++;
                        right--;
                    } else if (arr[left] + arr[right] < sum) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}
