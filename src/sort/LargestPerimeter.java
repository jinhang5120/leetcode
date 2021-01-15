package sort;

import java.util.Arrays;

/*976. 三角形的最大周长
给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

如果不能形成任何面积不为零的三角形，返回 0。



示例 1：

输入：[2,1,2]
输出：5*/
public class LargestPerimeter {
    public int largestPerimeter(int[] A) {//测试通过
        Arrays.sort(A);
        for(int i=A.length-1;i>1;i--){//最长边
            boolean flag = true;
            for(int j=i-1;flag&&j>0;j--){
                for(int k=j-1;flag&&k>=0;k--){
                    if(A[k]+A[j]>A[i]){
                        return A[k]+A[j]+A[i];
                    }else{
                        flag=false;
                    }
                }
            }
        }
        return 0;
    }
}
