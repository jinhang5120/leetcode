package stack;

public class MinOperations {
    public int minOperations(String[] logs) {
        int tmp = 0;
        for(String s:logs){
            if(s.equals("../")){
                tmp = Math.max(0,tmp-1);
            }else if(s.equals("./")){

            }else{
                tmp++;
            }
        }
        return tmp;
    }
}
