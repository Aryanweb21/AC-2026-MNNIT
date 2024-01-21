/**
 * Link - https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * 438. Find All Anagrams in a String
Solved
Medium
Topics
Companies
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length()) return list;
        int a[] = new int[s.length()];
        int freq[] = new int[26];

        for(int i=0;i<p.length();i++)
            freq[p.charAt(i)-'a']++;

        for(int i=0;i<=s.length()-p.length();i++){
            String str = s.substring(i,i+p.length());
            if(isAnagram(freq,str))
                a[i] = 1;
        }

        for(int i=0;i<a.length;i++){
            if(a[i]==1)
                list.add(i);
        }
        return list;
    }

    boolean isAnagram(int a[],String s){
        int currFreq[] = new int[26];
        for(int i=0;i<s.length();i++)
            currFreq[s.charAt(i)-'a']++;

        for(int i=0;i<26;i++){
            if(currFreq[i]!=a[i])
                return false;
        }
        return true;
    }
}