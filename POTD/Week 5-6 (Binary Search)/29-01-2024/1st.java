/**
 * Link - https://leetcode.com/problems/binary-search/description/
 * 704. Binary Search
Solved
Easy
Topics
Companies
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */

class Solution {
    public int search(int[] nums, int target) {
        //Approach 1
        // int left = 0;
        // int right = nums.length-1;
        // while(left<=right)
        // {
        //     int mid = (left+right)/2;
        //     if(nums[mid]==target)
        //         return mid;
        //     else if(nums[mid]<target)
        //         left = mid+1;
        //     else
        //         right = mid-1;
        // }
        // return -1;
        return isPresent(nums,target,0,nums.length-1);
    }

    // Using Recursion
    static int isPresent(int arr[],int target, int left, int right)
    {
        if(left>right) return -1;
        int mid = (left+right)/2;
        if(arr[mid]==target)
            return mid;
        else if(arr[mid]<target)
            return isPresent(arr,target,mid+1,right);
        else
            return isPresent(arr,target,left,mid-1);
    }
}