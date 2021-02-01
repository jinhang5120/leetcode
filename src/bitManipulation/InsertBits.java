package bitManipulation;
/*面试题 05.01. 插入
给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。

编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。



题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。



示例1:

 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 输出：N = 1100(10001001100)*/
public class InsertBits {
    public int insertBits(int N, int M, int i, int j) {//测试通过
        int res = 0;
        int k=0,tmp=1;
        while(N>0||k<=j){
            if(i<=k&&k<=j){
                res=(M%2)*tmp+res;
                M/=2;
                N/=2;
            }else{
                res=(N%2)*tmp+res;
                N/=2;
            }
            k++;
            tmp*=2;
        }
        return res;
    }
}
