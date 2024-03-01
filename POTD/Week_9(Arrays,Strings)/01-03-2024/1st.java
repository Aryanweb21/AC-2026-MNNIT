/**
 * Link - https://leetcode.com/problems/find-and-replace-pattern/description/
 * 890. Find and Replace Pattern
Solved
Medium
Topics
Companies
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(isPossible(word,pattern))
                ans.add(word);
        }
        return ans;
    }

    private boolean isPossible(String word, String pattern){
        char[] p2w = new char[26];
        char[] w2p = new char[26];

        for(int i=0;i<word.length();i++){
            char wChar = word.charAt(i);
            char pChar = pattern.charAt(i);

            if(p2w[pChar-'a']==0)
                p2w[pChar-'a'] = wChar;
            if(w2p[wChar-'a']==0)
                w2p[wChar-'a']=pChar;

            if(p2w[pChar-'a']!=wChar || w2p[wChar-'a']!=pChar)
                return false;
        }
        return true;
    }
}