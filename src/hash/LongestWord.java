package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
* 720. 词典中最长的单词
给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

若无答案，则返回空字符串。



示例 1：

输入：
words = ["w","wo","wor","worl", "world"]
输出："world"
解释：
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
* */
public class LongestWord {
    public static void main(String[] args) {
        String s = new LongestWord().longestWord(new String[]{"rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"});
        System.out.println("s = " + s);
    }

    public String longestWord(String[] words) {//测试通过，及时切换思维，思路不对耗功夫
        Arrays.sort(words);//单词按字典序排序
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                set.add(s);
                res = s.length() > res.length() ? s : res;
            }
        }
        return res;
    }
}
