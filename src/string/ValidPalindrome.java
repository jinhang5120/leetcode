package string;
/*
* 680. 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符
* */
public class ValidPalindrome {//TODO 测试通过
    public boolean validPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                StringBuilder sb1 = new StringBuilder(s);
                StringBuilder sb2 = new StringBuilder(s);
                sb1.delete(i,i+1);
                sb2.delete(s.length()-1-i,s.length()-i);
                return isValid(sb1.toString())||isValid(sb2.toString());
            }
        }
        return true;
    }
    public boolean isValid(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
