package bitManipulation;
/*面试题 05.03. 翻转数位
给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

示例 1：

输入: num = 1775(110111011112)
输出: 8
示例 2：

输入: num = 7(01112)
输出: 4*/
public class ReverseBits {
    public static void main(String[] args) {//测试通过
        int i = new ReverseBits().reverseBits(-1);
        int maxValue = Integer.MAX_VALUE;
        System.out.println("maxValue = " + maxValue);
        System.out.println("i = " + i);//1 11111 11111 11111 11111 11111 11111
    }
    public int reverseBits(int num) {
        String s = Integer.toBinaryString(num);
        int i=0,j=0,countZero=0,res=0;
        System.out.println("s.length() = " + s.length());
        while(i<s.length()&&j<s.length()){//滑动窗口
            if(s.charAt(j)=='0'){
                countZero++;
                if(countZero>=2){
                    while(i<s.length()&&s.charAt(i)=='1'){//判断要加数组越界判断
                        i++;
                    }
                    i++;countZero--;
                }
            }
            res = Math.max(res,j-i+1);
            j++;
        }
        return res+(num<0?0:(1-countZero));//正数首位还要考虑，负数则不用
    }
}
