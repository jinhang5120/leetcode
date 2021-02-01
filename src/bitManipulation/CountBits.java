package bitManipulation;
/*338. 比特位计数
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]*/
public class CountBits {//测试通过
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=0;i<=num;i++){
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
    public int[] countBits1(int num) {
        int []dp = new int[num+1];

        dp[0] = 0;                  //dp[i/2]:判断i右移一位之后有几个1； i%2：判断i的最后一位是否是1
        for(int i = 0;i<=num;i++){
            dp[i] = dp[i/2] + i%2;
        }
        return dp;
    }
}
