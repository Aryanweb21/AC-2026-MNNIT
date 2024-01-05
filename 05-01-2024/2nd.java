/*
    242. Valid Anagram
    Link - https://leetcode.com/problems/valid-anagram/
Easy
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        // check if both strings have same length, if no then return false
        if(s.length()!=t.length())
            return false;
        // initialize a frequency array to store the frequency of characters in both strings
        int freq[] = new int[26];
        // loop to taverse the strings(since both have same length, we can take any of their lengths)
        for(int i=0;i<s.length();i++)
        {
            // increase the frequency of character at ith index in s
            freq[s.charAt(i)-'a']++;
            // decrease the frequency of character at ith index in t
            freq[t.charAt(i)-'a']--;
        }
        // after the completion of 1st loop, we will get a array containing zeros since we've incremented
        // and decremented the values at the same time, therefore if both strings are anagram,
        // the array should contain only 0
        // lets traverse the array to check the same
        for(int i:freq)
        {
            // if any value other than 0 encountered, return false
            if(i!=0)
                return false;
        }
        // return true since the strings are anagrams
        return true;
    }
}