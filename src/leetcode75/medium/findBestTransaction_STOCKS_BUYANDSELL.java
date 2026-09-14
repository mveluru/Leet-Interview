package leetcode75.medium;

public class findBestTransaction_STOCKS_BUYANDSELL {
    public static void findBestTransaction(int[] prices) {
        if (prices == null || prices.length < 2) {
            System.out.println("Not enough days to trade.");
            return;
        }

        int minPrice = prices[0]; // Dynamically track the lowest price seen so far
        int buyDay = 0;

        int maxProfit = 0;
        int sellDay = 0;
        int actualBuyDayForMaxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // 1. Update the lowest price seen so far and track its index
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                buyDay = i;
            }

            // 2. Calculate potential profit if we sold TODAY using the minPrice found BEFORE today
            int potentialProfit = prices[i] - minPrice;

            // 3. If today gives a better profit, lock it in
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
                sellDay = i;
                actualBuyDayForMaxProfit = buyDay; // This guarantees buyDay happened before or on sellDay
            }
        }

        if (maxProfit > 0) {
            System.out.println("Buy Stock on indexDay: " + actualBuyDayForMaxProfit + " (Price: " + prices[actualBuyDayForMaxProfit] + ")");
            System.out.println("Sell Stock on indexDay: " + sellDay + " (Price: " + prices[sellDay] + ")");
            System.out.println("Max Profit: " + maxProfit);
        } else {
            System.out.println("No profit possible with these prices.");
        }
    }

    public static void main(String[] args) {
        int[] prices = {2, 8, 1, 3};
        findBestTransaction(prices);

        /*
        Using your array {2, 8, 1, 3}:
        1.At index 0 (price 2): minPrice becomes
        2.At index 1 (price 8): Potential profit is \(8 - 2 = 6\). maxProfit becomes 6. sellDay is 1, buyDay is 0.
        3.At index 2 (price 1): minPrice drops to 1. But no profit is calculated yet because we haven't seen a future day.
        4.At index 3 (price 3): Potential profit is \(3 - 1 = 2\). Since 2 is less than our max profit (6), we ignore it.
        Correct Output: Buy on Day 0, Sell on Day 1 (Profit = 6).

         */
    }
}
