/*
Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

 

Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
*/
class Solution {
    int ans=0;
    public int countArrangement(int n) {
        helper(1,new LinkedHashSet<Integer>(),n);
        return ans;
    }
    public void helper(int k,LinkedHashSet<Integer> list,int n){
        if(k>n){
            ans++;
            return;
        }        
        for(int i=1;i<=n;i++){            
          if(!list.contains(i) && (i%k==0 || k%i==0)){
              list.add(i);
              helper(k+1,list,n);
              list.remove(i);
          }
        }
    }
}
//Method 2
class Solution {
    int ans=0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(1,visited,n);
        return ans;
    }
    public void helper(int k,boolean[] visited,int n){
        if(k>n){
            ans++;
            return;
        }        
        for(int i=1;i<=n;i++){            
          if(!visited[i] && (i%k==0 || k%i==0)){
              visited[i]=true;
              helper(k+1,visited,n);
              visited[i]=false;
          }
        }
    }
}
