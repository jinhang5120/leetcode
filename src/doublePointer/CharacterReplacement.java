package doublePointer;
/*424. 替换后的最长重复字符
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意:
字符串长度 和 k 不会超过 104。

示例 1:

输入:
s = "ABAB", k = 2

输出:
4

解释:
用两个'A'替换为两个'B',反之亦然。*/
public class CharacterReplacement {
    public static void main(String[] args) {//测试通过
        int r = new CharacterReplacement().characterReplacement("AABABBA", 1);
        System.out.println("r = " + r);
    }
    public int characterReplacement(String s, int k) {//窗口定义为潜在重复子串，记录窗口中出现次数最多那个字符，判断该次数+k和滑动窗口长度的关系
        /*思路 滑动窗口核心的，窗口左右边界如何增减，当满足条件时右边增，不满足条件时左边减，
        如此变化窗口大小，得出当前窗口的解，并往前移动窗口直至移动到队列尾部扫描一遍，问题得到最终解决。
        对应于此题，滑动窗口右边不断增长，需要考虑满足增长的条件，以及不满足条件时，窗口左边如何减。*/
        if(s.length()<=k) return s.length();
        int i=0,j=k;
        int[] count = new int[26];
        char charMaxNum = 'A';
        for(int h=i;h<=j;h++){
            count[s.charAt(h)-'A']++;
            if(count[charMaxNum-'A']<count[s.charAt(h)-'A']){
                charMaxNum = s.charAt(h);
            }
        }
        int res = k;
        while(j<s.length()){
            if(count[charMaxNum-'A']<=count[s.charAt(j)-'A']){
                charMaxNum = s.charAt(j);
            }
            if(count[charMaxNum-'A']+k>=j-i+1){
                res = Math.max(res,j-i+1);
                j++;
                if(j<s.length()){
                    count[s.charAt(j)-'A']++;
                }
            }else{
                count[s.charAt(i)-'A']--;
                i++;
            }
        }
        return res;
    }
}
