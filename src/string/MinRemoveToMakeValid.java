package string;
/*
* 1249. 移除无效的括号
给你一个由 '('、')' 和小写字母组成的字符串 s。

你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。

请返回任意一个合法字符串。

有效「括号字符串」应当符合以下 任意一条 要求：

空字符串或只包含小写字母的字符串
可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」


示例 1：

输入：s = "lee(t(c)o)de)"
输出："lee(t(c)o)de"
解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
* */
public class MinRemoveToMakeValid {//TODO 测试通过
    public static void main(String[] args) {
        String s = new MinRemoveToMakeValid().minRemoveToMakeValid("(a(b(c)d)");
        System.out.println("s = " + s);
    }
    public String minRemoveToMakeValid(String s) {
        int[] ints = new int[s.length()+1];
        for(int i=1;i<ints.length;i++){//要一以贯之，既然已经用新数列保存，那就用到底
            if(s.charAt(i-1)=='('){
                ints[i] = ints[i-1]+1;
            }else if(s.charAt(i-1)==')'){
                ints[i] = ints[i-1]-1;
            }else{
                ints[i] = ints[i-1];
            }
        }
        boolean flag = true;
        int tmp = 0;
        for(int i=1;i<ints.length;i++){
            ints[i] +=tmp;
            if(ints[i]==-1){
                ints[i]=0;
                tmp++;
            }
        }
        while(ints[ints.length-1]!=0){
            int i = ints.length-2;
            while(ints[i]>0){
                i--;
            }
            for(int j=i+1;j<ints.length;j++){
                ints[j]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(ints[i]+1==ints[i+1]){
                    sb.append(s.charAt(i));
                }
            }else if(s.charAt(i)==')'){
                if(ints[i]-1==ints[i+1]){
                    sb.append(s.charAt(i));
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
