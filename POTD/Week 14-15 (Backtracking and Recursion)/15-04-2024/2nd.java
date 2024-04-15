/**
 * Link - https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
 * Consecutive 1's not allowed
MediumAccuracy: 27.46%Submissions: 108K+Points: 4
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s. Output your answer modulo 109 + 7.

Example 1:

Input:
N = 3
Output: 5
Explanation:
5 strings are (000,
001, 010, 100, 101).
Example 2:

Input:
N = 2
Output: 3
Explanation: 
3 strings are (00,01,10).
Your Task:
You don't have to print answer or take inputs. Complete the function countStrings() which takes single integer n, as input parameters and returns an integer denoting the answer. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
 */

class Solution {
    long countStrings(int n) {
        // code here
        if(n==2)
            return 3;
        if(n==1)
            return 2;
        long ans = countStrings(n-1)+countStrings(n-2);
        return ans%1000000007;
    }
}

//RECURSION + MEMOIZATION (DP)
class Solution {
    long[] memo;
    
    long countStrings(int n) {
        memo = new long[n + 1];
        return countStringsRecursive(n);
    }
    
    long countStringsRecursive(int n) {
        if (n <= 2)
            return n == 1 ? 2 : 3;
        
        if (memo[n] != 0)
            return memo[n];
        
        memo[n] = (countStringsRecursive(n - 1) + countStringsRecursive(n - 2)) % 1000000007;
        return memo[n];
    }
}