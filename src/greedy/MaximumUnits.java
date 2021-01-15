package greedy;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;

public class MaximumUnits {
    public static void main(String[] args) {
        int i = new MaximumUnits().maximumUnits(new int[][]{{4,2},{5,5},{4,1},{1,4},{2,5},{1,3},{5,3},{1,5},{5,5},{1,1}},24);
        System.out.println("i = " + i);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        for(int i=boxTypes.length-1;i>0;i--){
//            int max = 0;
//            for(int j=0;j<=i;j++){
//                if(boxTypes[max][1]<boxTypes[j][1]){
//                    max = j;
//                }
//            }
//            if(max!=i){
//                int[] tmp = boxTypes[max];
//                boxTypes[max] = boxTypes[i];
//                boxTypes[i] = tmp;
//            }
//        }
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int res = 0;
        for(int i=boxTypes.length-1;i>=0;i--){
            if(truckSize>=boxTypes[i][0]){
                res+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }else if(truckSize>0&&truckSize<boxTypes[i][0]){
                res+=truckSize*boxTypes[i][1];
                truckSize=0;
            }else{
                break;
            }
        }
        return res;
    }
}
