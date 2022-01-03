/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/
class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        if(nums.length==1)
            return true;
        for(int i=0;i<nums.length;i++)
            max=Math.max(nums[i],max);
        Boolean[] dp=new Boolean[nums.length];
        return helpJumper(nums,0,dp);
    }
    public boolean helpJumper(int[] nums,int i,Boolean[] dp){
        if(i>=nums.length)
            return false;
        else if(i==nums.length-1)
            return true; 
        else if(nums[i]==0)
            return false;
        if(dp[i]!=null)
               return dp[i];
        for(int j=1;j<=nums[i];j++){            
           
            dp[i]=helpJumper(nums,i+j,dp);
            
            if(dp[i]){
                return true;
            }
                
        }
        return false;
    }
}
