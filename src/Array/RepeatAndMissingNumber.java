package Array;
/*
    Program to Find Missing And Repeating number in an array using:-
    Two swap sort Approach
 */

import java.io.*;

public class RepeatAndMissingNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans[] = missingNumber(arr);
            System.out.println(ans[0]+" "+ans[1]);
        }
    }

    public static int[] missingNumber(int[] nums) {
        int temp, i=0;
        while(i<nums.length) {
            if(nums[i]-1 != i && nums[i] != nums[nums[i]-1]) {
                temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
            else {
                i++;
            }
        }
        for(i=0; i<nums.length; i++) {
            if(nums[i]-1 != i) {
                break;
            }
        }
        int res[] = {nums[i], i+1};
        return res;
    }
}
