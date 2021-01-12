package hash;

import java.util.*;

/*面试题 10.02. 变位词组
编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

注意：本题相对原题稍作修改

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {//测试通过
        List<List<String>> res = new ArrayList<>();
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            List<Integer> l = map.getOrDefault(tmp,new ArrayList<Integer>());
            l.add(i);
            map.put(tmp,l);
        }
        for(String key:map.keySet()){
            List<String> tmp = new ArrayList<>();
            for(int i:map.get(key)){
                tmp.add(strs[i]);
            }
            res.add(tmp);
        }
        return res;
    }
}
