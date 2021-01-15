package greedy;
/*1578. 避免重复字母的最小删除成本
给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。

返回使字符串任意相邻两个字母不相同的最小删除成本。

请注意，删除一个字符后，删除其他字符的成本不会改变。



示例 1：

输入：s = "abaac", cost = [1,2,3,4,5]
输出：3
解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。*/
public class MinCost {
    public static void main(String[] args) {//测试通过
        int i = new MinCost().minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1});
        System.out.println("i = " + i);
    }
    public int minCost(String s, int[] cost) {//可以尝试原地修改数组，更快！更方便！
        int res = 0;
        if(s.length()==1) return res;
        int i=0,j=1;
        while(j<=s.length()){
            if(j>=s.length()||s.charAt(i)!=s.charAt(j)){
                if(j-i>1){
                    int min = cost[i];
                    for(int k=i+1;k<j;k++){
                        if(min<cost[k]){
                            res+=min;
                            min= cost[k];
                        }else{
                            res+=cost[k];
                        }
                    }
                    i=j;
                    j=i+1;
                }else{
                    i++;j++;
                }
            }else{
                j++;
            }
        }
        return res;
    }
}
