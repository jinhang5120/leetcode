package string;
/*
* 面试题 01.09. 字符串轮转
字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

示例1:

 输入：s1 = "waterbottle", s2 = "erbottlewat"
 输出：True
* */
public class IsFlipedString {//TODO 测试通过
    public boolean isFlipedString(String s1, String s2) {
//        new StringBuilder()
        if(s1.length()==s2.length()){
            if(s1.length()==0) return s2.length()==0;
            for(int i=0;i<s1.length();i++){
                String tmp = s1.substring(i)+s1.substring(0,i);
                if(tmp.equals(s2)) return true;
            }
        }
        return false;
    }
}
