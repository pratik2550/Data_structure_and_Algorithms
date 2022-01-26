package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumSumOfTwoNumbersFormedByArray {
    public static void main(String[] args) {
//        int arr[] = {1, 1, 5, 2, 7, 6, 1, 4, 2, 3, 2, 2, 1, 6, 8, 5, 7, 6, 1, 8, 9, 2, 7, 9, 5, 4, 3, 1};
//        int arr[] = {6, 8, 4, 5, 2, 3};
        int arr[] = {1, 3, 8, 7, 4, 2, 7, 7, 9, 3, 1, 9, 8, 6, 5, 0, 2, 8, 6, 0, 2, 4};
//        int arr[] = {6, 5, 0, 9, 0, 0, 6, 1, 3, 8, 9, 3, 4, 4, 6, 0, 6, 6, 1, 8, 4, 9, 6, 3, 7, 8, 8, 2, 9};
        System.out.println(minimumSumOfTwoNumbersFormedByArray(arr, arr.length));
    }

    private static String minimumSumOfTwoNumbersFormedByArray(int[] arr, int length) {
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());
        int a = 0, b = 0, carry = 0;
        StringBuilder str = new StringBuilder();
        for (int i : arr) {
            mh.add(i);
        }
        while (!mh.isEmpty()) {
            a = mh.poll();
            if (!mh.isEmpty()) {
                b = mh.poll();
            } else {
                b = 0;
            }
            int ans = a + b + carry;
            if (ans <= 9) {
                str.append(ans);
                carry = 0;
            } else {
                str.append(ans % 10);
                carry = 1;
            }
        }
        if (carry != 0) {
            str.append(carry);
        }
        while (str.charAt(str.length() - 1) == '0') {
            str = str.deleteCharAt(str.length() - 1);
        }
        return String.valueOf(str.reverse());

    }
}
//22244580134578
//1367923347798