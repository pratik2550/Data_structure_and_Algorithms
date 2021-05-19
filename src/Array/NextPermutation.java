package Array;

import java.io.*;

public class NextPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int nums[] = new int[inputLine.length];
            for (int i=0; i<inputLine.length; i++){
                nums[i] = Integer.parseInt(inputLine[i]);
            }
            nextPermutation(nums);
        }
    }

    private static void nextPermutation(int nums[]) {
        if (nums.length==1) {
            printNumber(nums);
            return;
        }
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if (i>=0) {
            int j=nums.length-1;
            while (nums[i]>=nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums,i+1, nums.length-1);
        printNumber(nums);
    }

    private static void printNumber(int[] nums) {
        for (int i: nums) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void reverse(int[] nums, int i, int length) {

        while (i<length) {
            swap(nums,i++, length--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
