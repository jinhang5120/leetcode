package bitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarrayBitwiseORs {
    public static void main(String[] args) {
        int i = new SubarrayBitwiseORs().subarrayBitwiseORs(new int[]{39, 19, 30, 56, 79, 50, 19, 70, 30});
        System.out.println("i = " + i);
    }
    public int subarrayBitwiseORs(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i:arr){
            if(list.size()==0||list.get(list.size()-1)!=i){
                list.add(i);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            int tmp = 0;
            for(int j=i;j<list.size();j++){
                tmp|=list.get(j);
                set.add(tmp);
            }
        }
        return set.size();
    }
}
