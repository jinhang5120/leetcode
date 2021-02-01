package stack;

public class MinInsertions {
    public static void main(String[] args) {
        int i = new MinInsertions().minInsertions("( )( )() ))");
        System.out.println("i = " + i);
    }
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==')'&&sb.length()>1&&sb.charAt(sb.length()-2)=='('&&sb.charAt(sb.length()-1)==')'){
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        int res = 0;
        while(sb.length()>1){
            if((sb.charAt(0)=='('&&sb.charAt(1)==')')||(sb.charAt(0)==')'&&sb.charAt(1)==')')){
                res++;
                sb.deleteCharAt(0);
                sb.deleteCharAt(0);
            }else{
                res+=2;
                sb.deleteCharAt(0);
            }
        }
        return sb.length()==0?res:res+2;
    }
}
