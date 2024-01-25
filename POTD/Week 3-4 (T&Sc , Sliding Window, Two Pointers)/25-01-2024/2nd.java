/**
 * Link - https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/
 * 2799. Count Complete Subarrays in an Array
Solved
Medium
Topics
Companies
Hint
You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

 

Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
Example 2:

Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2000
 */

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(nums[i]);
        int k = set.size();
        if(k==1)
            return (n*(n+1))/2;
        int count=0;      
        for(int i=0;i<n;i++){
            Set<Integer> s = new HashSet<>();
            for(int j=i;j<n;j++){
                s.add(nums[j]);
                if(s.size()==k)
                    count++;
            }
        }     
        return count;
    }
}