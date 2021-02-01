package recursion;
/*剑指 Offer 16. 数值的整数次方
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。



示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25*/
public class MyPow {
    public static void main(String[] args) {//测试通过
        double v = new MyPow().myPow(1.0, -2147483648);
        System.out.println("v = " + v);
    }
    public double myPow(double x, int n) {
        if(n>=0){
            return pow(x,n);
        }else{
            return 1/pow(x,-(long) n);//注意边界问题，-2147483648不能转化成对应的int正数
        }
    }
    public double pow(double x,long n){
        if(n== 0L) return 1.0;
        if(n%2== 0L){
            return pow(x*x,n>>1);
        }else{
            return x*pow(x*x,(n-1)>>1);
        }
    }
}
