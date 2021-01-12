package hash;

/*
* 1640. 能否连接形成数组
给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。

如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
* */
public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        return formArray(arr,pieces,0);
    }
    public boolean formArray(int[] arr,int[][] pieces,int cur){
        if(cur>=arr.length){
            return true;
        }
        for(int[] piece:pieces){
            if(piece[0]==arr[cur]){
                for(int i=1;i<piece.length;i++){
                    if(arr[cur+i] != piece[i]){
                        return false;
                    }
                }
                return formArray(arr,pieces,cur+piece.length);
            }
        }
        return false;
    }
}
