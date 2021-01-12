package greedy;
/*122. 买卖股票的最佳时机 II
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。*/
public class MaxProfit {
    public static void main(String[] args) {
        /*也可以用DP动态规划，第i天只有两种状态，不持有或持有股票，
        当天不持有股票的状态可能来自昨天卖出或者昨天也不持有，
        同理，当天持有股票的状态可能来自昨天买入或者昨天也持有中，取最后一天的不持有股票状态就是问题的解*/
        int i = new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("i = " + i);
    }
    public int maxProfit(int[] prices) {//测试通过
        if(prices.length==0) return 0;
        int i=0;
        while(i+1<prices.length&&prices[i]>=prices[i+1]){
            i++;
        }
        int j=i+1;
        int res = 0;
        while(j<prices.length){
            if(prices[j-1]<=prices[j]){
                j++;
            }else{
                res = prices[j-1]-prices[i];
                i = j;
                j++;
            }
        }
        res+=Math.max(0,prices[j-1]-prices[i]);
        return res;
    }
}
