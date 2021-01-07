package string;
/*
* 1328. 破坏回文串
给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。

请你返回结果字符串。如果无法做到，则返回一个空串。



示例 1：

输入：palindrome = "abccba"
输出："aaccba"
* */
public class BreakPalindrome {//TODO 测试通过
        public String breakPalindrome(String palindrome) {
            if(palindrome.length()==1) return "";
            boolean flag = true;
            for(int i=0;flag&&i<palindrome.length()-1;i++){
                for(char c='a';c<palindrome.charAt(i);c++){
                    String tmp = new StringBuilder(palindrome).replace(i,i+1,String.valueOf(c)).toString();
                    if(!isValid(tmp)){
                        palindrome = tmp;
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                for(char c='a';c<='z';c++){
                    String tmp = palindrome.substring(0,palindrome.length()-1)+String.valueOf(c);
                    if(!isValid(tmp)){
                        return tmp;
                    }
                }
                return "";
            }else{
                return palindrome;
            }
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
