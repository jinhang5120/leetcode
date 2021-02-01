package recursion;
/*剑指 Offer 10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1*/
public class NumWays {
    public int numWays(int n) {//测试通过
        if(n<=1) return 1;
        int[] arr = new int[n+1];
        arr[0] = 1;arr[1] = 1;
        for(int i=2;i<n+1;i++){
            arr[i] = (arr[i-1]+arr[i-2])%1000000007;
        }
        return arr[n];
    }
}
