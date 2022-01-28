package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    static class IntTrio {
        int x;
        int y;
        double val;

        IntTrio(int x, int y, double val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        int arr[][] = {{1, 3}, {-2, 2}};
//        int arr[][] = {{3,3},{5,-1},{-2,4}};
//        int arr[][] = {{-5,4},{-6,-5},{4,6}};
        int arr[][] = {{2,10},{-9,-9},{0,8},{-2,-2},{8,9},{-10,-7},{-5,2},{-4,-9}};
        int k = 7;

        int ans[][] = kClosest(arr, k);
        for (int i = 0; i < k; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<IntTrio> heap = new PriorityQueue<>(new TrioKeyComparable());
        for (int i = 0; i < points.length; i++) {
            double eu = Math.sqrt((Math.pow(points[i][0],2)) + Math.pow(points[i][1], 2) );
            IntTrio trio = new IntTrio(points[i][0], points[i][1], eu);
            heap.add(trio);
        }
        int ans[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = heap.peek().x;
            ans[i][1] = heap.poll().y;
        }
        return ans;
    }
}

class TrioKeyComparable implements Comparator<KClosestPointsToOrigin.IntTrio> {
    @Override
    public int compare(KClosestPointsToOrigin.IntTrio o1, KClosestPointsToOrigin.IntTrio o2) {
        if (o1.val > o2.val) {
            return 1;
        }
        if (o1.val < o2.val) {
            return -1;
        }
        return 0;
    }
}