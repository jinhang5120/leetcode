package stack;

import java.util.ArrayList;
import java.util.List;
/*1021. 删除最外层的括号
有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。



示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。*/
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {//测试通过
        List<String> list = new ArrayList<>();
        int tmp = 1;
        int start = 0;
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)=='('){
                tmp++;
            }else{
                tmp--;
            }
            if(tmp==0){
                list.add(S.substring(start,i+1));
                start = i+1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s:list){
            sb.append(s.substring(1,s.length()-1));
        }
        return sb.toString();
    }
}
