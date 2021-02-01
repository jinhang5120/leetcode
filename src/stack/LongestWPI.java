package stack;

public class LongestWPI {
    public static void main(String[] args) {
        int i = new LongestWPI().longestWPI(new int[]{6, 9, 6});
        System.out.println("i = " + i);
    }
    public int longestWPI(int[] hours) {
        int[] dp = new int[hours.length];
        int count = 0;
        if(hours[0]>8){
            dp[0]=1;
            count++;
        }else{
            count--;
        }
        int res = dp[0];
        for(int i=1;i<hours.length;i++){
            if(hours[i]>8){
                count++;
                if(count==1){
                    dp[i] = dp[i-1]+2;
                }else{
                    dp[i] = dp[i-1]+1;
                }
            }else{
                count--;
                if(count>0){
                    dp[i] = dp[i-1]+1;
                }else{
                    dp[i] = 0;
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
