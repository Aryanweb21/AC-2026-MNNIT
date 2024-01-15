/*
1512. Number of Good Pairs
Link - https://leetcode.com/problems/number-of-good-pairs/description/
Easy
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        // initialize variable count with 0 to store the number of good pairs
        int count=0;

        // initialize 1st loop to iterate through whole array
        for(int i=0;i<nums.length;i++)
        {
            // nested loop to interate all elements other than nums[i]
            for(int j=i+1;j<nums.length;j++)
            {
                // check if nums[i]==nums[j]
                // since we're iterating from 0 to n, it's obvious that i<j will always be true
                if(nums[i]==nums[j]){
                    // if nums[i]==nums[j], increase the count by 1
                    count++;
                }
            }
        }
        // return count as answer
        return count;
    }
}