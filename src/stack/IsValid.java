package stack;

public class IsValid {
    public static void main(String[] args) {
        boolean valid = new IsValid().isValid("aabcbc");
        System.out.println("valid = " + valid);
    }
    public boolean isValid(String s) {
        if(s.length()<3) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)=='c'&&sb.charAt(sb.length()-1)=='b'&&sb.charAt(sb.length()-2)=='a'){
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.length()==0;
    }
}
