/*
    796. Rotate String
    Link - https://leetcode.com/problems/rotate-string/
Easy

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
*/

// SOLUTION

class Solution {
    public boolean rotateString(String s, String goal) {
        // initialize a loop from start to end on the string s
        for(int i=0;i<s.length();i++)
        {
            // call the function to rotate the string by 1
            s=leftRotate(s);
            // check if at any instant s==goal, return true if yes
            if(s.equals(goal))
                return true;
        }
        // if the loop ends it means we can't make 'goal' by rotating 's'
        // return false
        return false;
    }

    // function to rotate the string
    String leftRotate(String str)
    {
            // use of reversal algorithm for rotation
            String ans = str.substring(1) + str.substring(0, 1);
            return ans;
    }
}