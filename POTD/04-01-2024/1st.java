/*
    14. Longest Common Prefix
    Link - https://leetcode.com/problems/longest-common-prefix/
Easy
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // sort the array
        Arrays.sort(strs);
        String ansString="";
        // we can check 1st and last string in the array, since the array is sorted,
        // it means, the prefix 1st and last string having will also be present in other strings in between
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        // start a loop from 0 to length of s1 or s2 (which one is of minimum length)
        for(int i=0;i<Math.min(s1.length(),s2.length());i++)
        {
            // if the chracter is same, add it to string, otherwise break the loop
            if(s1.charAt(i)==s2.charAt(i))
                ansString+=s1.charAt(i);
            else
                break;
        }
        // return the answer string
        return ansString;
    }
}