package bitManipulation;
/*1318. 或运算的最小翻转次数
给你三个正整数 a、b 和 c。

你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。

「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。



示例 1：



输入：a = 2, b = 6, c = 5
输出：3
解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c*/
public class MinFlips {
    public static void main(String[] args) {//测试通过
        int i = new MinFlips().minFlips(2, 6, 5);
        System.out.println("i = " + i);
    }
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while(a!=0||b!=0||c!=0){
            int tmp1 = 1&a;
            int tmp2 = 1&b;
            int tmp3 = 1&c;
            if((tmp1|tmp2)!=tmp3){
                res+=(tmp1+tmp2+tmp3);
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return res;
    }
}
