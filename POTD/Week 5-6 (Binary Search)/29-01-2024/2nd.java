/**
 * Link - https://leetcode.com/problems/search-insert-position/description/
 * 35. Search Insert Position
Solved
Easy
Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int lb=0;
        int ub=nums.length-1;
        while(lb<=ub)
        {
            int mid = (lb+ub)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                lb++;
            else
                ub--;
        }
        return lb;
    }
}