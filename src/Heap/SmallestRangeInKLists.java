package Heap;

import java.util.*;

public class SmallestRangeInKLists {
    public static void main(String[] args) {
        int arr[][] = { { 4, 7, 9, 12, 15 },
                { 0, 8, 10, 14, 20 },
                { 6, 12, 16, 30, 50 } };

        int k = arr.length;

        smallestRange(arr, k);
    }

    private static void smallestRange(int[][] arr, int k) {
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1, end = -1;

        int n = arr[0].length;

        Nod[] arr1 = new Nod[k];
        for (int i = 0; i < k; i++) {
            Nod nod = new Nod(arr[i][0], i, 1);
            arr1[i] = nod;

            max = Math.max(max, nod.ele);
        }

        PriorityQueue<Nod> mh = new PriorityQueue<>(new NodComparator());
        for(Nod i: arr1) {
            mh.add(i);
        }
        while (true) {
            Nod root = mh.peek();

            // update min
            min = root.ele;

            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            if (root.j < n) {
                root.ele = arr[root.i][root.j];
                root.j++;

                if (root.ele > max)
                    max = root.ele;
            }
            else
                break;

            mh.remove();
            mh.add(root);
        }
        System.out.print( start + " " + end);

    }
}
class Nod {
    int ele;

    int i;

    int j;

    Nod(int a, int b, int c)
    {
        this.ele = a;
        this.i = b;
        this.j = c;
    }
}
class NodComparator implements Comparator<Nod> {

    public int compare(Nod k1, Nod k2)
    {
        if (k1.ele > k2.ele)
            return 1;
        else if (k1.ele < k2.ele)
            return -1;
        return 0;
    }
}