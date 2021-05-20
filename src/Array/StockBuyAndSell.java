package Array;

import java.io.*;

public class StockBuyAndSell {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int arr[] = new int[inputLine.length];
        for (int i = 0; i < inputLine.length; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }
        System.out.println(bestTime(arr));
    }

    //3 2 6 5 0 3  1 4 3
    private static int bestTime(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
