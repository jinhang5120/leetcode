package string;

import java.util.ArrayList;
import java.util.List;

/*
* 1408. 数组中的字符串匹配
给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。

如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。



示例 1：

输入：words = ["mass","as","hero","superhero"]
输出：["as","hero"]
解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
["hero","as"] 也是有效的答案。
* */
public class StringMatching {//TODO 测试通过
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(String w1:words){
            for(String w2:words){
                if(!w1.equals(w2)&&w2.contains(w1)){
                    res.add(w1);break;
                }
            }
        }
        return res;
    }
}
