package bitManipulation;
/*面试题 05.07. 配对交换
配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。

示例1:

 输入：num = 2（或者0b10）
 输出 1 (或者 0b01)
示例2:

 输入：num = 3
 输出：3*/
public class ExchangeBits {
    public static void main(String[] args) {//测试通过
        String s = Integer.toBinaryString(571603718);
        System.out.println("s = " + s);//10 00 10 00 01 00 01 11 11 10 11 00 00 01 10
        int i = new ExchangeBits().exchangeBits(3);
        System.out.println("i = " + i);
    }
    public int exchangeBits(int num) {
        int res = 0,tmp=1,num1=num;
        while(num1>0){
            res+=((num&tmp)<<1);
            res+=((num&(tmp<<1))>>1);
            tmp<<=2;
            num1>>=2;
        }
        return res;
    }
}
