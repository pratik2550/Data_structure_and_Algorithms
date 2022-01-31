package Heap;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        int n = 2;
        char[] arr = {'A','A','A','A','B','B','B'};

        System.out.println(leastInterval1(arr, n));
        System.out.println(leastInterval2(arr, n));
    }

    private static int leastInterval2(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i:count) {
            if(i>0) {
                pq.add(i);
            }
        }
        int max = pq.poll();
        int cnt=1;
        while (!pq.isEmpty() && pq.peek()==max) {
            cnt++;
            pq.remove();
        }
        return Math.max(tasks.length, ((max-1)*(n+1)+cnt));
    }

    public static int leastInterval1(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25]-1;
        int idle = max * n;
        for(int i=24; i>=0; --i) {
            idle = idle-Math.min(max, count[i]);
        }
        return idle > 0 ?  idle + tasks.length : tasks.length;
    }
}
