package Array;
/*
    Program to set matrix zero using:-
 */

import java.io.*;

public class SetMatrixZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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
            SetZeroes1(arr);
            SetZeroes2(arr);
        }
    }

    //This method required extra space of O(m+n) and time complexity is O(m*n).
    private static void SetZeroes1(int[][] arr) {
        int rowArr[] = new int[arr.length];
        int colArr[] = new int[arr[0].length];
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if (arr[i][j]==0) {
                    rowArr[i]=1;
                    colArr[j]=1;
                }
            }
        }
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if (rowArr[i]==1 || colArr[j]==1) {
                    arr[i][j]=0;
                }
            }
        }
        printMatrix(arr);
    }

    //This method required extra space of O(1) and time complexity is O(m*n).
    private static void SetZeroes2(int[][] arr) {
        int col0 = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0)
                col0 = 0;
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 1; j--) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
            if (col0 == 0)
                arr[i][0] = 0;
        }
        printMatrix(arr);
    }

    //method to print matrix
    private static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
