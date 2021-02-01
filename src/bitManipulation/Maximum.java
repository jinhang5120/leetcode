package bitManipulation;

public class Maximum {
    /*面试题 16.07. 最大数值
编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

示例：

输入： a = 1, b = 2
输出： 2*/
    public int maximum(int a, int b) {//测试通过，比大小用减法，用差的高位判断
        long dif = (long)a-(long)b;
        int k = (int)(dif>>>63);//无符号右移，高位补0
        return a*(k^1)+b*k;
    }
}
