package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestCity {//TODO 测试通过
    public static void main(String[] args) {
        String s = "a";
    }
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();
        for(List<String> list:paths){
            from.add(list.get(0));
            to.add(list.get(1));
        }
        for(String s:to){
            if(from.contains(s)){
                return s;
            }
        }
        return null;
    }
}
