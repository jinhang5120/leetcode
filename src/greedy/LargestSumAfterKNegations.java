package greedy;
/*1005. K 次取反后最大化的数组和
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）

以这种方式修改数组后，返回数组可能的最大和。



示例 1：

输入：A = [4,2,3], K = 1
输出：5
解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。*/
public class LargestSumAfterKNegations {
    public static void main(String[] args) {//测试通过
        int i = new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        System.out.println("i = " + i);
    }
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] ints = new int[201];
        for(int i:A){
            ints[i+100]++;
        }
        int sum = 0;
        int i=0;
        int maxNegative = 0;
        while(i<100){
            if(K>0&&ints[i]>0){
                if(K>ints[i]){
                    sum+=(100-i)*ints[i];
                    K-=ints[i];
                }else{
                    sum+=(100-i)*K+(i-100)*(ints[i]-K);
                    K=0;
                }
                maxNegative = i;
            }else{
                sum+=(i-100)*ints[i];
            }
            i++;
        }
        K%=2;
        if(K==1){
            int minPositive = 100;
            while(i<201&&ints[i]==0){
                i++;
                minPositive = i;
            }
            if(i==201){
                sum-=2*(100-maxNegative);
            }else{
                if(100-maxNegative<=minPositive-100){
                    sum-=2*(100-maxNegative);
                    sum+=(minPositive-100)*ints[minPositive];
                }else{
                    sum+=(minPositive-100)*(ints[minPositive]-2);
                }
                i++;
                while(i<201){
                    sum+=(i-100)*ints[i];
                    i++;
                }
            }
            return sum;
        }else{
            while(i<201){
                sum+=(i-100)*ints[i];
                i++;
            }
        }
        return sum;
    }
}
