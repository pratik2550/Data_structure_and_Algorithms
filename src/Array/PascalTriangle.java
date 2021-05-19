package Array;

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
            for (int i=0; i<n; i++) {
                for (int j=0; j<=i; j++) {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();
            }
        }
    }

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

}
