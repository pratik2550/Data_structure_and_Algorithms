package Array;
/*
    Program to find best time to buy and sell stock and total maximum profit on buying and selling stock multiple time
 */

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
        System.out.println(totalProfitOnMultipleSelling(arr));

    }

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

    private static int totalProfitOnMultipleSelling(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int minPriceIndex = 0;
        int totalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]-minPrice < maxProfit) {
                if (minPrice!=Integer.MAX_VALUE && minPriceIndex!=i-1) {
                    totalProfit += maxProfit;
                }
                minPrice = prices[i];
                minPriceIndex = i;
                maxProfit = 0;
            } else if (prices[i] - minPrice > maxProfit ) {
                maxProfit = prices[i]-minPrice;
            }
        }
        if (prices[prices.length-1] - minPrice >= maxProfit && minPriceIndex!= prices.length-1) {
            totalProfit += prices[prices.length-1]-prices[minPriceIndex];
        }
        return totalProfit;
        /*
        Alternative:-
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;

         */
    }
}
