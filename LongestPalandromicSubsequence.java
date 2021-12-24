//Function to find longest palandromic subsequence
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        Integer[][] dp = new Integer[n][n];       
        return helper(s,0,s.length()-1,dp);
    }
    public int helper(String s,int x,int y,Integer[][] dp){
        if(x>y)
            return 0;
        if(x==y)
            return 1;
        if(dp[x][y]!=null)
            return dp[x][y];
        if(s.charAt(x)==s.charAt(y))
            return dp[x][y]=2+helper(s,x+1,y-1,dp);
        else
            return dp[x][y]=Math.max(helper(s,x+1,y,dp),helper(s,x,y-1,dp));
    }
}
