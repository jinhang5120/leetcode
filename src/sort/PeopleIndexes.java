package sort;

import java.util.ArrayList;
import java.util.List;
/*1452. 收藏清单
给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。

请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。



示例 1：

输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
输出：[0,1,4]
解释：
favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。*/
public class PeopleIndexes {
    public static void main(String[] args) {//测试通过
        List<List<String>> favoriteCompanies = new ArrayList<>();
        ArrayList<String> integers0 = new ArrayList<>();
        ArrayList<String> integers1 = new ArrayList<>();
        ArrayList<String> integers2 = new ArrayList<>();
        ArrayList<String> integers3 = new ArrayList<>();
        ArrayList<String> integers4 = new ArrayList<>();
        integers0.add("leetcode");
        integers0.add("google");
        integers0.add("facebook");
        favoriteCompanies.add(integers0);
        integers1.add("google");
        integers1.add("microsoft");
        favoriteCompanies.add(integers1);
        integers2.add("google");
        integers2.add("facebook");
        favoriteCompanies.add(integers2);
        integers3.add("google");
        favoriteCompanies.add(integers3);
        integers4.add("amazon");
        favoriteCompanies.add(integers4);
        List<Integer> integers = new PeopleIndexes().peopleIndexes(favoriteCompanies);
        System.out.println("integers = " + integers);
    }
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        for(int i=0;i<favoriteCompanies.size();i++){
            favoriteCompanies.get(i).add(""+i);
        }
        favoriteCompanies.sort((a,b)->a.size()-b.size());
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<favoriteCompanies.size();i++){
            List<String> tmp = favoriteCompanies.get(i);
            boolean flag = false;
            for(int j=favoriteCompanies.size()-1;j>i;j--){
                flag = true;
                for(int k=0;k<tmp.size()-1;k++){
                    if(!favoriteCompanies.get(j).contains(tmp.get(k))){
                        flag = false;break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(!flag){
                res.add(Integer.valueOf(tmp.get(tmp.size()-1)));
            }
        }
        return res;
    }
}
