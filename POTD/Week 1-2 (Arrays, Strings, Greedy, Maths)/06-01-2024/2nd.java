/*
    45. Jump Game II
    Link - https://leetcode.com/problems/jump-game-ii/description/
Solved
Medium
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/

// SOLUTION : 

/*
    Approach : iterate over each possible path from ith position(Greedy Algorithm)

    Example 1 : nums=[2,3,1,1,4]
    first we take i=0(2):
            set away as max of away(0) and nums[0]+0(2) i.e. 2
            since (i=0)==(currVal=0), currVal=away & jumpsCount=1    <--------
    i++
    we take i=1(3):
            set away as max of away(2) and nums[1]+1(3+1) i.e. 4

    we take i=2(1):
            set away as max of away(4) and nums[2]+2 i.e. 4
            since (i=2)==(currVal=2), currVal=away & jumpsCount=2    <--------
    
    we take i=3(1):
            set away as max of away(4) and nums[3]+3(1+2) i.e. 4
    
    since we've reached n-1, the loop ends
    return the countJumps value as answer
    
*/

class Solution {
    public int jump(int[] nums) {
        // initialize 3 variable with 0
        // countJumps to trace the count of jumps taken
        int countJumps=0;
        // away to get the farthest position we can reach from ith element
        int away=0;
        // currVal to hold the ith value when we check other possible positions where we can reach
        int currVal=0;
        // iterate through the array
        for(int i=0;i<nums.length-1;i++)
        {
            // set away with max of current value of away and the new value where we reached
            away = Math.max(away,nums[i]+i);
            // if at any point i becomes currVal
            if(i==currVal)
            {
                // set currVal to away
                currVal=away;
                // increase countJumps by 1
                countJumps++;
            }
        }
        return countJumps;
    }
}