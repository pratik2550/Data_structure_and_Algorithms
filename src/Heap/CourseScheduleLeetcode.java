package Heap;

import java.util.*;

public class CourseScheduleLeetcode {
    public static void main(String[] args) {
        int arr[][] = {{100,200}, {200,1300},{1000,1250}, {2000,3200}};
//        int arr[][] = {{1,2}, {2,3}};
        System.out.println(scheduleCourse(arr));
    }

    static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1,c2)->Integer.compare(c1[1], c2[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((d1, d2)->Integer.compare(d2, d1));
        int time = 0;
        for (int[] course: courses) {
            int duration = course[0];
            int lastDate = course[1];
            time += duration;
            pq.add(duration);
            if(time>lastDate) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}
