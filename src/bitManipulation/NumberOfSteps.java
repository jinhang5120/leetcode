package bitManipulation;
/*1342. 将数字变成 0 的操作次数
给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。



示例 1：

输入：num = 14
输出：6
解释：
步骤 1) 14 是偶数，除以 2 得到 7 。
步骤 2） 7 是奇数，减 1 得到 6 。
步骤 3） 6 是偶数，除以 2 得到 3 。
步骤 4） 3 是奇数，减 1 得到 2 。
步骤 5） 2 是偶数，除以 2 得到 1 。
步骤 6） 1 是奇数，减 1 得到 0 */
public class NumberOfSteps {
    public int numberOfSteps (int num) {//测试通过
        int res = 0;
        while(num>0){
            res+=(num%2);
            num>>=1;
            if(num>0) res++;
        }
        return res;
    }
}
