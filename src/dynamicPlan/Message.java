package dynamicPlan;

/*
* 数组非相邻元素的最大和
*
* 输入： [2,1,4,5,3,1,1,3]
输出： 12
解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。


*
* */
public class Message {//TODO 测试通过，dp[i] = Max(dp[i-1],dp[i-2]+nums[i])  i表示结尾为第i个元素的最大和
    public int massage(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[dp.length-1];
    }
}
