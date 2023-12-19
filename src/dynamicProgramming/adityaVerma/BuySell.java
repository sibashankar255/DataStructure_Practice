package dynamicProgramming.adityaVerma;

import java.util.HashMap;

public class BuySell {
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int buy_price =prices[0];
        int max_profit =0;
        for (int i=1; i<prices.length;i++){
            if (prices[i]>buy_price){
                int profit = prices[i]-buy_price;
                max_profit = Math.max(max_profit,profit);
            }else {
                buy_price=prices[i];
            }
        }
        return max_profit;
    }

    //122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {
        int profit=0;
        for (int i=1; i<prices.length; i++){
            if (prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
    }

    //123. Best Time to Buy and Sell Stock III
//    public int maxProfit3(int[] prices) {
//        HashMap<String, Integer> hm = new HashMap<>();
//        return maxProfit(0, 0, prices, 2, hm);
//    }
}
