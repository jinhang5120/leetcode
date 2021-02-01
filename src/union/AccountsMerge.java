package union;

import java.util.*;
/*721. 账户合并
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。



示例 1：

输入：
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
输出：
[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
解释：
第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。*/
public class AccountsMerge {
    public static void main(String[] args) {//测试通过
        List<String> l1 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        List<String> l2 = new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"));
        List<String> l3 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        List<String> l4 = new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<List<String>> lists = new AccountsMerge().accountsMerge(list);
        System.out.println("lists = " + lists);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] arr = new int[accounts.size()];
        for(int i=1;i<arr.length;i++){
            arr[i] = i;
        }
        for(int i=1;i<accounts.size();i++){
            for(int j=0;j<i;j++){
                List<String> account1 = accounts.get(j);
                List<String> account2 = accounts.get(i);
                if(account1.get(0).equals(account2.get(0))){
                    if(isSame(account1,account2)){
                        int root = j;
                        while(arr[root]!=root){
                            int tmp = arr[root];
                            arr[root] = i;//此步是压缩树结构
                            root = tmp;

                        }
                        arr[root] = i;
                    }
                }
            }
        }
        Map<Integer,Set<String>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int root = i;
            while(arr[root]!=root){
                root = arr[root];
            }
            if(!map.containsKey(root)){
                map.put(root,new TreeSet<>());
                map.get(root).addAll(accounts.get(root));
            }
            map.get(root).addAll(accounts.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for(Integer root:map.keySet()){
            String name = accounts.get(root).get(0);
            Set<String> set = map.get(root);
            set.remove(name);
            List<String> l = new ArrayList<>(set);
            l.add(0,name);
            res.add(l);
        }
        return res;
    }
    public boolean isSame(List<String> list1,List<String> list2){
        for(int i=1;i<list1.size();i++){
            if(list2.contains(list1.get(i))){
                return true;
            }
        }
        return false;
    }
}
