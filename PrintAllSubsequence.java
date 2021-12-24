//Function to print all the subsequences of a string.
class Solution {
    public void printAllSubsequence(String s) {
        String curr="";
        helper(s,-1,s.length(),curr);       
    }
    public void helper(String s,int x,int y,String curr){
        if(x==y){
            return;
        }
        if(!curr.isEmpty())
            System.out.println(curr);
        for(int i=x+1;i<y;i++){
            curr=curr+s.charAt(i);
            helper(s,i,y,curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
