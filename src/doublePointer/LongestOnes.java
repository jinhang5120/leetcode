package doublePointer;
/*1004. 最大连续1的个数 III
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。



示例 1：

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。*/
public class LongestOnes {
    public int longestOnes(int[] A, int K) {
        //测试通过，用滑动窗口表示可全部变成1的窗口，因此要记录窗口中现有1的最多数目，判断加上变化次数后是否不小于现有窗口长度，进而判断窗口是否滑动
        if(A.length<=K) return K;
        int i=0,j=K,numOfOne=0;
        for(int h=i;h<=K;h++){
            if(A[h]==1) numOfOne++;
        }
        int res = 0;
        while(j<A.length){
            if(numOfOne+K<j-i+1){
                if(A[i]==1){
                    numOfOne--;
                }
                i++;
            }else{
                res = Math.max(res,j-i+1);
                j++;
                if(j<A.length&&A[j]==1){
                    numOfOne++;
                }
            }
        }
        return res;
    }
}
