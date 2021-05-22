package Array;
/*
    Program to search a number in a sorted matrix.
 */

import java.io.*;

public class SearchInMatrix {
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
        int target = Integer.parseInt(br.readLine().trim());
        System.out.println(search(arr, target));
        System.out.println(search2(arr, target));
    }

    private static boolean search(int[][] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i][arr[0].length-1]+" arr[i]");
            if (arr[i][arr[0].length-1]>= target) {
                for (int j=0; j<arr[0].length; j++) {
                    System.out.println(arr[i][j]+" arr[i][j]");
                    if (arr[i][j]==target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean search2(int[][] arr, int target) {
        int n = arr.length;

        int m = arr[0].length;

        int i = 0, j = m - 1;

        while(i < n && j >= 0) {

            if(arr[i][j] == target) {

                return true;
            }
            else if(arr[i][j] < target) {

                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
}
