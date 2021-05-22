package Array;

import java.io.*;
/*
    Program to calculates x raised to the power n (i.e., xn).
*/

public class ImplementPowFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        double x = Double.parseDouble(inputLine[0]);
        int n = Integer.parseInt(inputLine[1]);
        System.out.println(calculatePow(x, n));
        System.out.println(myPow(x, n));
    }

    //throws stack overflow error for very large number.
    private static double calculatePow(double x, int n) {
        if (n == 1) {
            return x;
        } else if (n > 1) {
            return x * calculatePow(x, --n);
        } else if (n == -1) {
            return 1 / x;
        } else if (n < -1) {
            return (1 / x * calculatePow(x, ++n));
        } else {
            return 0;
        }
    }

    //handle all case(best solution)
    public static double myPow(double x, int n) {
        double res = myPowHelper(x, Math.abs(n));
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    public static double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double halfRes = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return halfRes * halfRes;
        } else {
            return halfRes * halfRes * x;
        }
    }
}
