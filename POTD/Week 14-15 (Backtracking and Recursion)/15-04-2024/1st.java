/**
 * Link - https://leetcode.com/problems/subsets-ii/description/
 * 90. Subsets II
Solved
Medium
Topics
Companies
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(list,nums,0,new ArrayList<>());
        return list;
    }

    void solve(List<List<Integer>> list, int[] arr, int idx, List<Integer> curr){
        list.add(new ArrayList<>(curr));
        for(int i=idx;i<arr.length;i++){
            if(i!=idx && arr[i]==arr[i-1])
                continue;
            curr.add(arr[i]);
            solve(list,arr,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}