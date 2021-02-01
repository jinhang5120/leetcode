package sort;

import java.util.Arrays;
/*1647. 字符频次唯一的最小删除次数
如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。

给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。

字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。



示例 1：

输入：s = "aab"
输出：0
解释：s 已经是优质字符串。*/
public class MinDeletions {
    public static void main(String[] args) {//测试通过
        int aab = new MinDeletions().minDeletions("bbcebab");
        System.out.println("aab = " + aab);
    }
    public int minDeletions(String s) {/*统计每个单词的词频，然后排序。从大到小遍历，使得数组中元素唯一。*/
        if(s.length()==1) return 0;
        int[] ints = new int[26];
        for(char c:s.toCharArray()){
            ints[c-'a']++;
        }
        Arrays.sort(ints);
        int res = ints[ints.length-1];
        int i = ints.length-2;
        while(i>=0&&ints[i]>0){
            if(ints[i]>=ints[i+1]){
                ints[i] = ints[i+1]-1;
            }
            if(ints[i]==0) break;
            res+=ints[i];
            i--;
        }
        return s.length()-res;
    }
}
