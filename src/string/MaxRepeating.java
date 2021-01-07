package string;
/*
* 1668. 最大重复子字符串
给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。

给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。



示例 1：

输入：sequence = "ababc", word = "ab"
输出：2
解释："abab" 是 "ababc" 的子字符串。
* */
public class MaxRepeating {//TODO 测试通过
    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        int i = maxRepeating.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba");
        System.out.println("i = " + i);
    }
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        String tmp = word;
        while(sequence.contains(tmp)){
            res++;
            tmp+=word;
            //不能用word+=word这样字符串会翻倍
        }
        return res;
    }
}
