package Heap;

import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25]-1;
        int idle = max * n;
        for(int i=24; i>=0; --i) {
            System.out.println(max+" "+ count[i]);
            idle = idle-Math.min(max, count[i]);
            System.out.println(idle);
        }
        return idle > 0 ?  idle + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        int n = 2;
        char[] arr = {'A','A','A','B','B','B'};

        System.out.println(leastInterval(arr, n));
    }
}
