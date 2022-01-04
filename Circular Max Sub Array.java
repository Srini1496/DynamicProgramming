/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
*/
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //Kandane Algorithm
        int curr_max=nums[0];
        int max=nums[0];
        
        int curr_min=nums[0];
        int min=nums[0];
        
        int total=nums[0];
        for(int i=1;i<nums.length;i++){
            total+=nums[i];
            curr_max=Math.max(nums[i],curr_max+nums[i]);
            max=Math.max(max,curr_max);
            
            curr_min=Math.min(nums[i],curr_min+nums[i]);
            min=Math.min(curr_min,min);
        }
        //System.out.println(min +"  "+ total);
        if(max<0)
            return max;
        else
            return Math.max(max,total-min);
        
    }
}
