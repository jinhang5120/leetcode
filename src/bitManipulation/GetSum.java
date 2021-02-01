package bitManipulation;
/*371. 两整数之和
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3
示例 2:

输入: a = -2, b = 3
输出: 1*/
public class GetSum {
    public int getSum(int a, int b) {//测试通过
        int sum = a^b;//异或这里可看做是相加但是不显现进位，比如5 ^ 3
        int carry = (a&b)<<1;//相与为了让进位显现出来，比如5 & 3，进位1应该要再往前一位，所以左移一位
        while(carry!=0){//经过上面这两步，如果进位不等于0，那么就是说还要把进位给加上去，所以用了尾递归
            return getSum(sum,carry);
        }
        return sum;
    }
    public int add(int a, int b) {
        while(b!=0){
            int tmp = (a^b);//保存未进位相加结果
            b = ((a&b)<<1);//保存进位
            a = tmp;
        }
        return a;
    }
}
