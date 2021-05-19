package Array;
/*
    Program to generate Pascal's Triangle and generate nth row of Pascal Triangle
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> res = generatePascalTriangle(n);
            printTriangle(res);
            List<Long> getRow = getRow(n);
            printRow(getRow);
            List<Long> getRow2 = getRow2(n);
            printRow(getRow2);
        }
    }

    //generate Pascal triangle
    private static List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i=0; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre = row;
            res.add(row);
        }
        return res;
    }

    //print Pascal triangle
    private static void printTriangle(List<List<Integer>> res) {
        for (int i=0; i<res.size(); i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    //generate nth row of Pascal triangle
    private static List<Long> getRow(int n) {
        List<Long> res = new ArrayList<>();
        res.add(1L);
        long temp = 1;
        for(int i=1,up=n,down=1;i<=n;i++,up--, down++){
            temp=temp*up/down;
            res.add(temp);
        }
        return res;
    }

    //generate nth row of Pascal triangle(if n is very large)
    private static List<Long> getRow2(int n) {
            // code here
            if(n==1)
            {
                List<Long> v = new ArrayList<>();
                v.add(1l);
                return v;
            }
            final long MOD = 1000_000_007;

            List<Long> v = new ArrayList<>();
            List<Long> tans = getRow2(n-1);
            v.add(1l);
            long c = 1;
            for (int i = 1; i < n-1; i++) {
                v.add((tans.get(i)+tans.get(i-1))%MOD);
                //c = ((c % MOD * (n - i)) % MOD * mod.get(i)) % MOD;
            }
            v.add(1l);
            return v;
    }

    //print nth row of Pascal Triangle
    private static void printRow(List<Long> getRow) {
        for (int i=0; i<getRow.size(); i++) {
            System.out.print(getRow.get(i)+" ");
        }
        System.out.println();
    }

}
