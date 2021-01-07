package string;
/*
* 1189. “气球” 的最大数量
给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。

字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。



示例 1：



输入：text = "nlaebolko"
输出：1
* */
public class MaxNumberOfBalloons {//TODO 测试通过
    public int maxNumberOfBalloons(String text) {
        int[] ints = new int[26];
        for(char c:text.toCharArray()){
            ints[c-'a']++;
        }
        int res = ints['a'-'a'];
        res = Math.min(res,ints['b'-'a']);
        res = Math.min(res,ints['l'-'a']/2);
        res = Math.min(res,ints['o'-'a']/2);
        res = Math.min(res,ints['n'-'a']);
        return res;
    }
}
