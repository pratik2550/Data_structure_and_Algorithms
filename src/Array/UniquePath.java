package Array;
/*
    Program to find unique path from source to destination in a given matrix using only right and down direction.
 */

import java.io.*;

public class UniquePath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int m = Integer.parseInt(inputLine[0]);
        int n = Integer.parseInt(inputLine[1]);

        System.out.println(countPath1(m, n, 0, 0));
        System.out.println(countPath2(m, n));
        System.out.println(countPath3(m, n));
    }

    //Using recursion
    private static int countPath1(int m, int n, int r, int c) {
        if (r > m)
            return 0;
        if (c > n)
            return 0;
        if (r == m - 1 && c == n - 1)
            return 1;
        return countPath1(m, n, r, c + 1) + countPath1(m, n, r + 1, c);
    }

    //Using Dynamic programming
    private static int countPath2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int arr[][] = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
        return paths(m, n, 0, 0, arr);
    }

    private static int paths(int m, int n, int r, int c, int[][] arr) {
        if (r == m - 1 && c == n - 1)
            return 1;
        if (r >= m || c >= n)
            return 0;
        if (arr[r][c] != -1) {
            return arr[r][c];
        }
        return arr[r][c] = paths(m, n, r, c + 1, arr) + paths(m, n, r + 1, c, arr);
    }

    //Using combination
    /*
        If number of column is n then their is total n-1 step in rightwards direction and if number of row is m then their is total
        m-1 step in downwards direction.
        Therefore total number of step is (m-1)+(n-1)=m+n-2.
        Hence, Selecting m-1 from n+n-2 (n+m-2Cm-1) or selecting n-1 from n+m-2 (n+m-2Cn-1) is equal to total number of path.
     */
    private static int countPath3(int m, int n) {
        int N = m + n - 2;
        int r = n - 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }
}
