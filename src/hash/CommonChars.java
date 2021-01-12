package hash;

import java.util.ArrayList;
import java.util.List;
/*
* 1002. 查找常用字符
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。



示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]*/
public class CommonChars {
    public List<String> commonChars(String[] A) {//测试通过
        List<String> list = new ArrayList<>();
        int[][] ints = new int[A.length][26];
        for(int i=0;i<A.length;i++){
            for(char c:A[i].toCharArray()){
                ints[i][c-'a']++;
            }
        }
        for(int i=0;i<26;i++){
            int min = ints[0][i];
            for(int j=1;j<ints.length;j++){
                min = Math.min(min,ints[j][i]);
            }
            for(int j=0;j<min;j++){
                list.add(String.valueOf((char)('a'+i)));
            }
        }
        return list;
    }
}
