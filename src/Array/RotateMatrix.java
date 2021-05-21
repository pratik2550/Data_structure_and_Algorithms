package Array;
/*
    Program to rotate matrix by 90 deg.
 */

import java.io.*;

public class RotateMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().trim().split(" ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            String inputLine[] = br.readLine().trim().split(" ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(inputLine[j]);
            }
        }
        rotate(arr);
        rotate2(arr);
    }

    //First rotate diagonal then vertical
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
        printMatrix(matrix);
    }

    //swap elements to their rotated position
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
