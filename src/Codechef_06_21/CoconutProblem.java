package Codechef_06_21;
/*
    Summer Heat:- https://www.codechef.com/JUNE21C/problems/COCONUT
 */

import java.util.Scanner;

public class CoconutProblem {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-->0) {
                int aW = sc.nextInt();
                int bP = sc.nextInt();
                int tW = sc.nextInt();
                int tP = sc.nextInt();
                int total = (int) (Math.ceil((double)tW/(double)aW)+Math.ceil((double)tP/(double)bP));
                System.out.println(total);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//4
//100 400 1000 1200
//100 450 1000 1350
//150 400 1200 1200
//150 400 1210 1210