package hash;

import java.util.Arrays;
/*
* 面试题 16.14. 最佳直线
给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。

设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小的直线返回，S[0]相同则选择S[1]值较小的直线返回。

示例：

输入： [[0,0],[1,1],[1,0],[2,0]]
输出： [0,2]
解释： 所求直线穿过的3个点的编号为[0,2,3]
* */
public class BestLine {
    public static void main(String[] args) {//测试成功
        int[] ints = new BestLine().bestLine(new int[][]{{0, 0}, {-17856, -60134}, {8928, 30067}, {-8928, -30067}, {31062, -2766}, {14640, 41105}, {16161, 8407}, {1260, 19580}, {-13641, 30753}});
        System.out.println(Arrays.toString(ints));
    }
    public int[] bestLine(int[][] points) {
        int max = 2;
        int[] res = new int[]{0, 1};
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int tmp = 2;
                for (int k = j + 1; k < points.length; k++) {
                    if (isLine(points[i], points[j], points[k])) {
                        tmp++;
                    }
                }
                if (max < tmp) {
                    max = tmp;
                    res = new int[]{i, j};
                }
            }
        }
        return res;
    }
    public boolean isLine(int[] a,int[] b,int[] c){
        long A1 = a[0]-b[0];
        long A2 = a[1]-b[1];
        long B1 = a[0]-c[0];
        long B2 = a[1]-c[1];
        return (A1*B1+A2*B2)*(A1*B1+A2*B2) == (A1*A1+A2*A2)*(B1*B1+B2*B2);
    }
}
