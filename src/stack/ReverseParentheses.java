package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*1190. 反转每对括号间的子串
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。



示例 1：

输入：s = "(abcd)"
输出："dcba"
示例 2：

输入：s = "(u(love)i)"
输出："iloveu"*/
public class ReverseParentheses {//测试通过
    public static void main(String[] args) {
        String s = new ReverseParentheses().reverseParentheses("(u(love)i)");
        System.out.println("s = " + s);
        ArrayList<Integer> integers = new ArrayList<>();
    }
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        List<Stack<Character>> list = new ArrayList<>();
        list.add(new Stack<Character>());
        for(char c:s.toCharArray()){
            if(c=='('){
                list.add(new Stack<Character>());
            }else if(c==')'){
                Stack<Character> stack1 = list.get(list.size()-1);
                Stack<Character> stack2 = list.get(list.size()-2);
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                list.remove(list.size()-1);//记得要删除
            }else{
                Stack<Character> stack1 = list.get(list.size()-1);
                stack1.push(c);
            }
        }
        Stack<Character> stack = list.get(0);
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
