package dynamicPlan;
/*
* 474. 一和零
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。



示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
* */
public class FindMaxForm {
/*
* //dp[i][j][k] = max(dp[i - 1][j][k], dp[i - 1][j - numOfZero(i)][k - numOfOne(i)] + 1);
//i代表前i个元素的集合
//j代表0最多的个数
//k代表1最多的个数
//dp值代表在三个因素限制下的子集长度
//动态规划思路：分析受制因素的个数
* */
    public int findMaxForm(String[] strs, int m, int n) {//TODO 测试通过
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++){
            int numOfZero = count0(strs[i-1]);
            int numOfOne = strs[i-1].length()-numOfZero;
            for(int j=0;j<dp[i].length;j++){
                for(int k=0;k<dp[i][j].length;k++){
                    if(j>=numOfZero&&k>=numOfOne){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-numOfZero][k-numOfOne]+1);
                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    public int count0(String s){
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                res++;
            }
        }
        return res;
    }
}
