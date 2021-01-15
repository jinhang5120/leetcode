package binarySearch;
/*
* 面试题 10.05. 稀疏数组搜索
稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。

示例1:

 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 输出：-1
 说明: 不存在返回-1。
示例2:

 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 输出：4
* */
public class FindString {
    public static void main(String[] args) {//测试通过，有序则二分
        int ta = new FindString().findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ta");
        System.out.println("ta = " + ta);
    }
    public int findString(String[] words, String s) {
        return findString(words,s,0,words.length-1);
    }//"" "at" at
    public int findString(String[] words,String s,int left,int right){
        if (left<right) {
            int mid = left+(right-left)/2;
            if(words[mid].length()==0){
                int res1 = findString(words,s,left,mid-1);
                if(res1!=-1) return res1;
                int res2 = findString(words,s,mid+1,right);
                if(res2!=-1) return res2;
            }else{
                int tmp = compare(words[mid],s);
                if(tmp==0){
                    return mid;
                }else if(tmp>0){
                    return findString(words,s,mid+1,right);
                }else{
                    return findString(words,s,left,mid-1);
                }
            }
        }else if(left==right){
            if(words[left].equals((s))) return left;
        }
        return -1;
    }
    public int compare(String s1,String s2){
        for(int i=0;i<s1.length()&&i<s2.length();i++){
            if(s1.charAt(i)<s2.charAt(i)){
                return 1;
            }else if(s1.charAt(i)>s2.charAt(i)){
                return -1;
            }
        }
        if(s1.length()<s2.length()){
            return 1;
        }else if(s1.length()>s2.length()){
            return -1;
        }else{
            return 0;
        }
    }
}
