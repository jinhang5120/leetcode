package doublePointer;

import java.util.Arrays;

public class CountPairs {
    public static void main(String[] args) {
        int i = new CountPairs().countPairs(new int[]{1,1,1,3,3,3,7});
        System.out.println("i = " + i);
    }
    public int countPairs(int[] deliciousness) {
        Arrays.sort(deliciousness);
        int res = 0;
        int tmp = 1;
        for(int i=0;i<32;i++){
            tmp*=2;
            res+=twoSum(deliciousness,0,deliciousness.length-1,tmp);
        }
        return res;
    }
    public int twoSum(int[] deliciousness,int left,int right,int target){
        int res = 0;
        int i=left,j=right;
        while(i<j){
            if(deliciousness[i]+deliciousness[j]<target){
                if(deliciousness[j-1]+deliciousness[j]<target){
                    break;
                }
                i++;
            }else if(deliciousness[i]+deliciousness[j]>target){
                if(deliciousness[i]+deliciousness[i+1]>target){
                    break;
                }
                j--;
            }else{
                int tmp1=1,tmp2=1;

            }
        }
        return res;
    }
}
