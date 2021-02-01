package bitManipulation;
/*1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
给你一个二进制字符串 s 和一个整数 k 。

如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 True ，否则请返回 False 。



示例 1：

输入：s = "00110110", k = 2
输出：true
解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。*/
import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {
    public boolean hasAllCodes(String s, int k) {//测试通过
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()+1-k;i++){
            set.add(s.substring(i,i+k));
            if(set.size()==Math.pow(2,k)) return true;
        }
        return false;
    }
}
