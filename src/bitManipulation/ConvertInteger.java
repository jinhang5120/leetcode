package bitManipulation;
/*面试题 05.06. 整数转换
整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。

示例1:

 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 输出：2
示例2:

 输入：A = 1，B = 2
 输出：2*/
public class ConvertInteger {
    public static void main(String[] args) {//测试通过
        int i = new ConvertInteger().convertInteger(826966453, -729934991);
        System.out.println("i = " + i);
        //00110001010010101000000110110101
        //11010100011111100001001101110001
    }
    public int convertInteger(int A, int B) {
        int res = 0;
        while(A!=0||B!=0){
            String s = Integer.toBinaryString(A);
            String s1 = Integer.toBinaryString(B);
            res+=(Math.abs(A%2)^Math.abs(B%2));
            A>>>=1;
            B>>>=1;
        }
        return res;
    }
    public int convertIntege1r(int A, int B) {//异或，然后统计1的个数。
        return Integer.bitCount(A^B);
    }
}
