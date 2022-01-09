/*
LeetCode 42
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

*/
class Solution {
    public int trap(int[] height) {
        int[] leftMax=new int[height.length];
        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i-1]);          
        }
        int[] rightMax=new int[height.length];
        for(int i=height.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        }
        int[] res=new int[height.length];
        for(int i=0;i<height.length;i++){
            res[i]=Math.max(Math.min(leftMax[i],rightMax[i])-height[i],0);
        }
        int ans=0;
        for(int i=0;i<height.length;i++)
            ans+=res[i];
        return ans;
    }
}
