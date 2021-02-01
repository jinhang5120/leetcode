package union;

import java.util.*;
/*952. 按公因数计算最大组件大小
给定一个由不同正整数的组成的非空数组 A，考虑下面的图：

有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记；
只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。
返回图中最大连通组件的大小。



示例 1：

输入：[4,6,15,35]
输出：4*/
public class LargestComponentSize {
    public static void main(String[] args) {//测试未通过，缺少合并操作
        int i = new LargestComponentSize().largestComponentSize(new int[]{4, 6, 15, 35});
        System.out.println("i = " + i);
    }
    public int largestComponentSize(int[] A) {
        primes();
        Set<Integer> leafs = new HashSet<>();
        leafs.add(A[0]);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<A.length;i++){
            Iterator<Integer> it = leafs.iterator();
            boolean flag1 = true;
            while(it.hasNext()){
                Integer leaf = it.next();
                Integer tmp = leaf;
                boolean flag = isConnected(tmp,A[i]);
                if(!flag){
                    while(map.containsKey(tmp)){
                        tmp = map.get(tmp);
                        if(isConnected(tmp,A[i])){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag){
                    map.put(A[i],leaf);
                    it.remove();
                    leafs.add(A[i]);
                    flag1 = false;
                    break;
                }
            }
            if(flag1){
                leafs.add(A[i]);
            }
        }
        int res = 0;
        for(Integer leaf:leafs){
            int count = 1;
            while(map.containsKey(leaf)){
                leaf = map.get(leaf);
                count++;
            }
            res = Math.max(res,count);
        }
        return res;
    }
    public boolean isConnected(int i,int j){
        for(Integer integer:primes){
            if(integer>i/2||integer>j/2){
                break;
            }
            if(i%integer==0&&j%integer==0){
                return true;
            }
        }
        return false;
    }
    Set<Integer> primes = new TreeSet<>();
    public void primes(){
        primes.add(2);
        for(int i=3;i<=100000;i++){
            boolean flag = true;
            for(Integer integer:primes){
                if(i%integer==0){
                    flag = false;
                    break;
                }
                if(integer>i/2){
                    break;
                }
            }
            if(flag){
                primes.add(i);
            }
        }
    }
}
