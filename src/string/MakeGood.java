package string;
/*
* 1544. 整理字符串
给你一个由大小写英文字母组成的字符串 s 。

一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:

若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。

请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。

注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。



示例 1：

输入：s = "leEeetcode"
输出："leetcode"
解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
* */
public class MakeGood {//TODO 测试通过
    public static void main(String[] args) {
        String leEeetcode = new MakeGood().makeGood("leEeetcode");
    }
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<sb.length()-1;){
                if(Math.abs(sb.charAt(i)-sb.charAt(i+1))==Math.abs('a'-'A')){
                    sb.delete(i,i+2);
                    flag = true;
                }else{
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
