package Codechef_06_21;
/*
    Bella ciao:- https://www.codechef.com/JUNE21C/problems/CHFHEIST
 */

import java.util.Scanner;

public class BankHeist {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-->0) {
                int D = sc.nextInt();
                int d = sc.nextInt();
                int P = sc.nextInt();
                int Q = sc.nextInt();

                int sum = 0;
                int x = D/d;
                int r = D%d;
                sum = (x*P*d)+d*Q*(x*(x-1)/2)+(P*r+(r*Q*x));

                System.out.println(sum);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
