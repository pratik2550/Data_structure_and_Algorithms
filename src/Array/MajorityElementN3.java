package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MajorityElementN3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < inputLine.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }

        System.out.println(majorityElement(arr));
    }

    private static int majorityElement(int[] arr) {
        int count1 = 0, count2 = 0;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first) {
                count1++;
            } else if (arr[i] == second) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                first = arr[i];
            } else if (count2 == 0) {
                count2++;
                second = arr[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : arr) {
            if (i == first) {
                count1++;
            } else if (i == second) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > arr.length / 3) {
            res.add(first);
            return first;
        }
        if (count2 > arr.length / 3) {
            res.add(second);
            return second;
        }
        return -1;
    }
}
