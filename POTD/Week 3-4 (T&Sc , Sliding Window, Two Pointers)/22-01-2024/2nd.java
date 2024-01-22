/**
 * Link - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=list&envId=rrssge1g
 * 3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
Companies
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int i=0;
        int j=0;
        int maxLen=0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while (map.get(s.charAt(j)) > 1){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        
        return maxLen;
    }
}