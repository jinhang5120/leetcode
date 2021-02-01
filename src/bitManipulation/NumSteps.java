package bitManipulation;
/*1404. 将二进制表示减到 1 的步骤数
给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：

如果当前数字为偶数，则将其除以 2 。

如果当前数字为奇数，则将其加上 1 。

题目保证你总是可以按上述规则将测试用例变为 1 。



示例 1：

输入：s = "1101"
输出：6
解释："1101" 表示十进制数 13 。
Step 1) 13 是奇数，加 1 得到 14
Step 2) 14 是偶数，除 2 得到 7
Step 3) 7  是奇数，加 1 得到 8
Step 4) 8  是偶数，除 2 得到 4
Step 5) 4  是偶数，除 2 得到 2
Step 6) 2  是偶数，除 2 得到 1 */
public class NumSteps {
    public static void main(String[] args) {//测试通过
        int i = new NumSteps().numSteps("1101");
        System.out.println("i = " + i);
    }
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        while(sb.length()>1){//要读题意
            if(sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                int i = sb.length()-1;
                while(i>=0&&sb.charAt(i)=='1'){
                    sb.setCharAt(i,'0');
                    i--;
                }
                if(i>=0){
                    sb.setCharAt(i,'1');
                }else{
                    sb.insert(0,'1');
                }
            }
            res++;
        }
        return res;
    }
}
