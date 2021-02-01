package union;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {//测试通过
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        l1.add(0);
        l1.add(3);
        l2.add(1);
        l2.add(2);
        l3.add(0);
        l3.add(2);
        pairs.add(l1);
        pairs.add(l2);
        pairs.add(l3);
        String s = new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", pairs);
        System.out.println("s = " + s);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] arr = new int[s.length()];
        for(int i=1;i<arr.length;i++){
            arr[i] = i;
        }
        for(List<Integer> pair:pairs){
            Integer i0 = pair.get(0);
            Integer i1 = pair.get(1);
            int count1 = 0;
            while(arr[i0]!=i0){
                count1++;
                i0 = arr[i0];
            }
            int count2 = 0;
            while(arr[i1]!=i1){
                count2++;
                i1 = arr[i1];
            }
            if(i0!=i1){
                if(count1<=count2){//根据高度值，决定嫁接，要不然会超时
                    arr[i0] = i1;
                }else{
                    arr[i1] = i0;//根据高度值，决定嫁接
                }
            }
        }
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Integer root = i;
            while(arr[root]!=root){
                root = arr[root];
            }
            if(!map.containsKey(root)){
                map.put(root,new PriorityQueue<>());
            }
            map.get(root).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            Integer root = i;
            while(arr[root]!=root){
                root = arr[root];
            }
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
}
