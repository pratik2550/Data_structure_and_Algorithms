package Array;
/*
    Program to find the sum of three number closest to given number.
 */

import java.io.*;
import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        int k = Integer.parseInt(br.readLine());
        System.out.print(closestThreeSum(arr, k));
    }

    private static int closestThreeSum(int[] arr, int k) {
        Arrays.sort(arr);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2 && closest!=0; ++i) {
                int left = i + 1, right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[left] +arr[right];
                    if (Math.abs(k-sum)<Math.abs(closest)) {
                        closest = k-sum;
                    } if (Math.abs(k-sum)==Math.abs(closest)) {
                        closest = Math.min(closest, k-sum);
                    }
                    if (k > sum) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
        }
        return k-closest;
    }
}
