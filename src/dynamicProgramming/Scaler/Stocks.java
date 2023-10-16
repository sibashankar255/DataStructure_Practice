package dynamicProgramming.Scaler;

public class Stocks {
    //Best Time to Buy and Sell Stock
    public int maxProfit1(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int buy_price =prices[0];
        int max_profit =0;
        for (int i=1; i<prices.length;i++){
            if (buy_price<prices[i]){
                int profit = prices[i]-buy_price;
                max_profit = Math.max(max_profit,profit);
            }else {
                buy_price=prices[i];
            }
        }
        return max_profit;
    }

    //Best Time to Buy and Sell Stock II
    public int maxProfit2(final int[] A) {
        int profit=0;
        for (int i=1; i<A.length; i++){
            if (A[i]>A[i-1]){
                profit += A[i]-A[i-1];
            }
        }
        return profit;
    }


    //Best Time to Buy and Sell Stock III


    //Best Time to Buy and Sell Stock IV

}
