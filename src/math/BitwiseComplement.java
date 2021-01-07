package math;
/*
* 1009. 十进制整数的反码
每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。

二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。

给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。



示例 1：

输入：5
输出：2
解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
* */
public class BitwiseComplement {//TODO 测试通过
    public int bitwiseComplement(int N) {
        if(N==0) return 1;
        String s = "";
        while(N!=0){
            s=N%2+s;
            N/=2;
        }
        int res = 0;
        for(int i=0;i<s.length();i++){
            res*=2;
            if(s.charAt(i)=='0'){
                res++;
            }
        }
        return res;
    }
}
