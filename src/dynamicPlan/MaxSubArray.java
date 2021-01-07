package dynamicPlan;

/*
* 53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
* */
public class MaxSubArray {//TODO 测试通过，dp[n]表示以第n个数为结束点的子数列的最大和：dp[] = max(dp[i-1] + A[i], A[i]);
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res = dp[0];
        for(int i:dp){
            res = Math.max(res,i);
        }
        return res;
    }
}
