package math;
/*
* 1037. 有效的回旋镖
回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。



示例 1：

输入：[[1,1],[2,3],[3,2]]
输出：true
* */
public class IsBoomerang {//测试通过
    public boolean isBoomerang(int[][] points) {
        int i = 1 ^ 0;
        int x = 1;
        int y = 2;
        int i1 = x ^ y;

        int a1 = points[0][0]-points[1][0];
        int b1 = points[0][1]-points[1][1];
        int a2 = points[0][0]-points[2][0];
        int b2 = points[0][1]-points[2][1];
        return (a1*a2+b1*b2)*(a1*a2+b1*b2)!=(a1*a1+b1*b1)*(a2*a2+b2*b2);
    }
}
