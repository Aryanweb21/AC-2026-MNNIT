/**
 * Link - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 34. Find First and Last Position of Element in Sorted Array
Solved
Medium
Topics
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //APPROACH 1 (TWO POINTERS)
        // int i=0;
        // int j=nums.length-1;
        // while(i<=j){
        //     if(nums[i]==target && nums[j]==target)
        //         break;
        //     if(nums[i]!=target)
        //         i++;
        //     if(nums[j]!=target)
        //         j--;
        // }
        // if(i>j)
        //     return new int[]{-1,-1};
        // else
        //     return new int[]{i,j};

        //APPROACH 2 (BINARY SEARCH)
        int lb = lowerBound(nums,target);
        if(lb==nums.length || nums[lb]!=target)
            return new int[]{-1,-1};
        return new int[]{lb,upperBound(nums,target)-1};
    }

    int lowerBound(int arr[], int x){
        int i=0;
        int j=arr.length-1;
        int ans=arr.length;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]>=x){
                ans=mid;
                j=mid-1;
            }
            else
                i=mid+1;
        }
        return ans;
    }

    static int upperBound(int arr[], int x){
        int i=0;
        int j=arr.length-1;
        int ans=arr.length;
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]>x){
                ans = mid;
                j = mid-1;
            }
            else
                i = mid+1;
        }
        return ans;
    }
}