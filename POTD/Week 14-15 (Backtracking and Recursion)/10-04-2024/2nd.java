/**
 * Link - https://leetcode.com/problems/subsets/?envType=list&envId=o7km4wrg
 * 78. Subsets
Solved
Medium
Topics
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

class Solution {
    //USING BIT MANIPULATION
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = 1 << nums.length;
        for(int i=0;i<n;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0)
                    curr.add(nums[j]);
            }
            ans.add(curr);
        }
        return ans;
    }

    //USING RECURION/BACKTRACK
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,ans,0, new ArrayList<>());
        return ans;
    }    

    void solve(int[] nums, List<List<Integer>> ans, int idx,List<Integer> list){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        solve(nums,ans,idx+1,list);
        list.remove(list.size()-1);
        solve(nums,ans,idx+1,list);
    }
}