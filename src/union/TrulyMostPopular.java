package union;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*面试题 17.07. 婴儿名字
每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。

在结果列表中，选择 字典序最小 的名字作为真实名字。



示例：

输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
输出：["John(27)","Chris(36)"]*/
public class TrulyMostPopular {
    public static void main(String[] args) {
        String[] strings = new TrulyMostPopular().trulyMostPopular(new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)" },
                new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)" });
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));
    }
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String,String> map = new HashMap<>();//并查集
        for(String s:synonyms){
            String name1 = s.substring(1,s.indexOf(","));
            String name2 = s.substring(s.indexOf(",")+1,s.length()-1);
            String root1 = name1;
            String root2 = name2;
            while(map.containsKey(root1)){
                root1 = map.get(root1);
            }
            while(map.containsKey(root2)){
                root2 = map.get(root2);
            }
            if(!root1.equals(root2)){
                map.put(root2,name1);
            }
        }
        Map<String,Integer> nameCount = new HashMap<>();//根的计数
        Map<String,String> nameMap = new HashMap<>();//根对应的数据，因为要用字典序进行排序
        for(String n:names){
            String name = n.substring(0,n.indexOf("("));
            Integer count = Integer.valueOf(n.substring(n.indexOf("(")+1,n.length()-1));
            String rootName = name;
            while(map.containsKey(rootName)){
                rootName = map.get(rootName);
            }
            nameCount.put(rootName,nameCount.getOrDefault(rootName,0)+count);
            String trueName = nameMap.getOrDefault(rootName,rootName);
            trueName = name.compareTo(trueName)<0?name:trueName;
            nameMap.put(rootName,trueName);
        }
        String[] res = new String[nameCount.size()];
        int i=0;
        for(String key:nameCount.keySet()){
            Integer count = nameCount.get(key);
            res[i] = nameMap.get(key) + "(" + count + ")";
            i++;
        }
        return res;
    }
}
