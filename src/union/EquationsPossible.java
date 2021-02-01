package union;

import java.util.HashMap;
import java.util.Map;
/*990. 等式方程的可满足性
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。



示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。*/
public class EquationsPossible {
    public static void main(String[] args) {
        String[] res = new String[]{"Jon","John","Johnny"};
        String trueName = "Jon";
        for(String s:res){
            trueName = trueName.compareTo(s)<0?trueName:s;
        }
        System.out.println("trueName = " + trueName);
    }
    public boolean equationsPossible(String[] equations) {//测试通过

        Map<Character,Character> map = new HashMap<>();
        for(String s:equations){
            if(s.charAt(1)=='='){
                char c1 = s.charAt(0);
                char c2 = s.charAt(3);
                while(map.containsKey(c1)){
                    c1 = map.get(c1);
                }
                while(map.containsKey(c2)){
                    c2 = map.get(c2);
                }
                if(c1!=c2){
                    map.put(c2,s.charAt(0));
                }
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                char c1 = s.charAt(0);
                char c2 = s.charAt(3);
                while(map.containsKey(c1)){
                    c1 = map.get(c1);
                }
                while(map.containsKey(c2)){
                    c2 = map.get(c2);
                }
                if(c1==c2){
                    return false;
                }
            }
        }
        return true;
    }
}
