package array;

import java.util.Arrays;
/*
* 通过*/
public class MinIncrementForUnique {
    public static void main(String[] args) {
        int i = minIncrementForUnique(new int[]{1, 2, 2});
        System.out.println("i = " + i);
//        Integer i = 0;
//        i++;
//        System.out.println(i);
    }
    public static int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int[] ints = new int[1];
        unique(A,1,ints);
        return ints[0];
    }
    public static void unique(int[] A,int cur,int[] ints){
        if(cur>=A.length){
            return;
        }
        if(A[cur]>A[cur-1]){
            unique(A,cur+1,ints);
        }else{
            ints[0]+=(A[cur-1]+1-A[cur]);
            A[cur] = A[cur-1]+1;
            unique(A,cur+1,ints);
        }
    }
}
