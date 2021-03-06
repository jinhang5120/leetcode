package hash;
/*
*剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "
* */
public class FirstUniqChar {//测试通过
    public char firstUniqChar(String s) {
        int[] ints  = new int[26];
        for(char c:s.toCharArray()){
            ints[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(ints[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        return ' ';
    }
}
