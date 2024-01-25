/**
 * Link - https://leetcode.com/problems/sort-colors/description/
 * 75. Sort Colors
Solved
Medium
Topics
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

class Solution {
    public void sortColors(int[] nums) {
        // APPROACH 1 (brute-force)
        // for(int i=0;i<nums.length-1;i++)
        // {
        //     boolean flag = false;
        //     for(int j=0;j<nums.length-i-1;j++)
        //     {
        //         if(nums[j]>nums[j+1])
        //         {
        //             int temp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = temp;
        //             flag = true;
        //         }
        //     }
        //     if(!flag) return;
        // }

        // Approach 2(Three pointers) Dutch National Flag Algorithm
        int left=0;
        int mid=0;
        int right=nums.length-1;
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,mid,left);
                mid++; left++;
            }
            else if(nums[mid]==2){
                swap(nums,mid,right);
                right--;
            }
            else
                mid++;
        }
    }

    static void swap(int arr[],int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}