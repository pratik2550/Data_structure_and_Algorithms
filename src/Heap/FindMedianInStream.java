package Heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInStream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            insertHeap(arr[i]);
        }
    }

    static PriorityQueue<Integer> pqMin = new PriorityQueue<>();
    static PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

    public static void insertHeap(int x)
    {
        // add your code here
        if(pqMax.isEmpty() && pqMax.size()==0) {
            pqMax.add(x);
            return;
        }
        balanceHeaps(x);

    }

    //Function to balance heaps.
    public static void balanceHeaps(int x)
    {
        // add your code here
        if(pqMax.size()>pqMin.size()) {
            if(pqMax.peek()>x) {
                pqMin.add(pqMax.poll());
                pqMax.add(x);
            } else {
                pqMin.add(x);
            }
        } else {
            if(pqMax.peek()>x) {
                pqMax.add(x);
            } else {
                pqMin.add(x);
                pqMax.add(pqMin.poll());
            }
        }
    }

    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(pqMax.size()==pqMin.size()) {
            return (pqMax.peek()+pqMin.peek())/2;
        } else
            return pqMax.peek();
    }
}
