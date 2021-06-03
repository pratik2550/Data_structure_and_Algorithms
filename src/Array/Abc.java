package Array;

import java.util.Arrays;

public class Abc {
    public static void main(String[] args) {
//        int arr[] = {1, 5, 2, 3, 8};
//        findSum(arr, 5);
        int a[] = {33, 67, 23, 64, 18, 68, 96, 40, 40, 53
        };
        findSum(a, 10);
    }

    private static void ass(int[] a, int n) {
        int r = 0;
        int l[] = new int[n];
        for (int i=0; i<n; i++) {
            l[i] = 1;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i]>a[j] && l[i]<l[j]+1)
                    l[i] = l[i]+1;
            }
        }
        for (int i=0; i<n; i++) {
            if (r<l[i])
                r = l[i];
        }
        System.out.print(n-r);
    }

    private static void findSum(int[] arr, int n) {
        int sort[] = new int[n];
        for (int x=0; x<n; x++) {
            sort[x] = arr[x];
        }
        Arrays.sort(sort);
        for (int i=0; i<n; i++) {
            int j=0;
            for (j=0; j<n; j++) {
                if (arr[i]==sort[j]) {
                    break;
                }
            }
            int sum = j==0?0:sort[j-1];
            sum += j==n-1?0:sort[j+1];
            System.out.print(sum+" ");
        }
    }
}
