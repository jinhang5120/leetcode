package dynamicPlan;

import java.util.Arrays;
/*
* 300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。


示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1
* */
public class Solution {//TODO 测试通过，dp[i] = max[1+(if(nums[j]<nums[i]) dp[j])] i为子序列的最后一个的位置
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            Arrays.fill(dp,1);
            for(int i=1;i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[j]<nums[i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            int res = dp[0];
            for(int i:dp){
                res = Math.max(res,i);
            }
            return res;
        }
//dp[i] = max(1+if(nums[j]<nums[i]) dp[j]) i为子序列的最后一个的位置
}
