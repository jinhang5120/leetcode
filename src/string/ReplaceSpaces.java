package string;

/*
* 面试题 01.03. URL化
URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）



示例 1：

输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"
* */
public class ReplaceSpaces {//TODO 测试通过
    public static void main(String[] args) {

    }
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(length>0){
                if(S.charAt(i)==' '){
                    sb.append("%20");
                }else{
                    sb.append(S.charAt(i));
                }
                length--;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
