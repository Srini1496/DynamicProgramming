/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
*/
class Solution {
    public int jump(int[] nums) {
       
        Integer[] dp=new Integer[nums.length];
        return helpJumper(nums,0,dp);
    }
    public int helpJumper(int[] nums,int i,Integer[] dp){
        if(i>=nums.length)
            return Integer.MAX_VALUE-1000;
        else if(i==nums.length-1)
            return 0;
        else if(nums[i]==0)
            return Integer.MAX_VALUE-1000;
        if(dp[i]!=null)
                return dp[i];
       
        int min=Integer.MAX_VALUE;
        
        for(int j=1;j<=nums[i];j++){
          
            dp[i]=1+helpJumper(nums,i+j,dp);
            min=Math.min(dp[i],min);
            dp[i]=min;
                
        }
        return min;
    }
}
