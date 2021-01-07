package string;
/*
* 面试题 17.13. 恢复空格
哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数



示例：

输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
* */
public class Respace {

    /*
    * 动态规划

思路：直接求最少匹配的字符数比较复杂，所以反过来我们求能匹配的最大字符数。这道题相当于一个 完全0-1背包问题，背包容量为字符串长度，物品（字典中的单词）数量没有限制。我们要做的就是尽可能的填满这个背包。

1.定义状态： dp[i][j] 表示字符串（0~i），字典（0~i）的状态下，匹配的最大字符数。

2.状态转移：从背包末尾开始考虑：

当单词能塞进背包末尾的时候，即 sentence.substring(i-len,i) 与 当前单词相等，len 为单词长度。此时单词有两种状态，塞进背包，和不塞进背包，记住单词可以重复取用，取这两种状态的最大值：dp[i][j] = max(dp[i-len][j]+len,dp[i][j-1])。

当单词不能塞进背包末尾的时候，取字符串(0~i-1)与当前单词的组合dp[i-1][j]，和当前字符串与前一个单词组合dp[i][j-1]这两种组合的最大值。即：dp[i][j] = max(dp[i-1][j],dp[i][j-1]).

3.返回值：sentence.length() - dp[m][n];
    * */
    public int respace(String[] dictionary, String sentence) {//TODO 动态规划，0-1背包问题，能放多少取决于背包容量和物品大小，两个因素条件制约
        int m = sentence.length();
        int[] dp = new int[m+1];
        for(int i=1;i<=m;i++){                 //外层循环字符串
            for(String word:dictionary){             //内层循环字典
                int len = word.length();
                if(i >= len && word.equals(sentence.substring(i-len,i))){
                    dp[i] = Math.max(dp[i],dp[i-len]+len);  //状态转移 //TODO 能放下
                }else{
                    dp[i] = Math.max(dp[i],dp[i-1]); //TODO不能放下
                }
            }
        }
        return m-dp[m];
    }
}
