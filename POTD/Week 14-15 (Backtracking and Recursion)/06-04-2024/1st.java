/**
 * Link - https://www.geeksforgeeks.org/problems/searching-a-number0324/1
 * Searching a number
BasicAccuracy: 37.29%Submissions: 115K+Points: 1
Given an array arr of n elements and a integer k. Your task is to return the position of first occurence of k in the given array and if element k is not present in the array then return -1 .
Note: Position of first element is considered as 1.

Example 1:

Input:
n = 5
k = 16
arr = {9, 7, 2, 16, 4}
Output: 4
Explanation: k = 16 is found in the given array at position 4.
Example 2:

Input:
n = 7
k = 98
arr = {1, 22, 57, 47, 34, 18, 66}
Output: -1
Explanation: k = 98 isn't found in the given array.
Your Task:
Complete the function search() which takes two integers n , k and an array arr, as input parameters and returns an integer denoting the answer. Return -1 if the number is not found in the array. You don't have to print answers or take inputs.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 106
1 <= k <= 106
1 <= arr[i] <= 109
 */

class Solution {
    public static int search(int n, int k, int[] arr) {
        // code here
        return helper(n,0,k,arr);
    }
    
    static int helper(int n, int idx, int k, int[] arr){
        if(idx==n)
            return -1;
        if(arr[idx]==k)
            return idx+1;
        return helper(n,idx+1,k,arr);
    }
}