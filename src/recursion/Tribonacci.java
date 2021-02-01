package recursion;
/*1137. 第 N 个泰波那契数
泰波那契序列 Tn 定义如下：

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数 n，请返回第 n 个泰波那契数 Tn 的值。



示例 1：

输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4*/
public class Tribonacci {
    public int tribonacci(int n) {//测试通过，如果直接递归，容易超时
        if(n<=1) return n;
        if(n==2) return 1;
        if(n==3) return 2;
        return 2*tribonacci(n-1)-tribonacci(n-4);
    }
}
