/**
 * Link - https://leetcode.com/problems/di-string-match/description/
 * 942. DI String Match
Solved
Easy
A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.

 

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: s = "III"
Output: [0,1,2,3]
Example 3:

Input: s = "DDI"
Output: [3,2,0,1]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'I' or 'D'.
 */

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length(); // get length of the string
        int[] arr = new int[n+1]; // create n+1 array as count starts with 0
        // get the elements in n+1 array using TWO POINTERS APPROACH
        int left = 0; // 1st pointer
        int right = n; // 2nd pointer
        int idx=0; // curr index(where to store)
        for(char c : s.toCharArray()){
            if(c=='I') // if current char is 'I', add left at the idxTh index
                arr[idx++] = left++;
            else
                arr[idx++] = right--; 
        }
        if(s.charAt(n-1)=='I') // for the n+1Th element, if last element was 'I' then 'left'
        //otherwise 'right'
            arr[n] = left;
        else
            arr[n] = right;
        
        return arr; // return the sorted array
    }
}