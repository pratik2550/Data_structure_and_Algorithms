package Array;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InversionOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i=0; i<inputLine.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }

        inversionOfArray(arr);
        System.out.println(inversionOfArray2(arr, 0, arr.length-1));
    }

    private static void inversionOfArray(int[] arr) {
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i]> arr[j]) {
                    count++;
                }
            }
            res.add(count);
            count=0;
        }
        res.add(0);
        System.out.println(res);
    }

    private static int inversionOfArray2(int[] arr, int l, int r) {
        int count = 0;
        if (l<r) {
            int m = (l+r)/2;

            count += inversionOfArray2(arr, l, m);
            count += inversionOfArray2(arr, m+1, r);
            count += merge(arr, l, m, r);
        }
        return count;
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int left[] = Arrays.copyOfRange(arr, l, m+1);
        int right[] = Arrays.copyOfRange(arr, m+1, r+1);
        int i=0, j=0, k=l, swap=0;
        while (i<left.length && j<right.length) {
            if (left[i]<=right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swap += (m+1)-(l+i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swap;
    }

}
