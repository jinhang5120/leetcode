package string;
/*
* 1446. 连续字符
给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

请你返回字符串的能量。



示例 1：

输入：s = "leetcode"
输出：2
解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
* */
public class MaxPower {//TODO 测试通过
    public int maxPower(String s) {
        if(s.length()==1) return 1;
        int i=0,j=1;
        int max = 1;
        while(j<s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                max = Math.max(max,j-i);
                i=j;
                j=i+1;
            }else{
                j++;
            }
        }
        max = Math.max(max,j-i);
        return max;
    }
}
