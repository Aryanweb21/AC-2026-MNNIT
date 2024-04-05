/**
 * Link - https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
 * Check if array is sorted
EasyAccuracy: 39.37%Submissions: 186K+Points: 2
Given an array arr[] of size N, check if it is sorted in non-decreasing order or not. 

Example 1:

Input:
N = 5
arr[] = {10, 20, 30, 40, 50}
Output: 1
Explanation: The given array is sorted.
Example 2:

Input:
N = 6
arr[] = {90, 80, 100, 70, 40, 30}
Output: 0
Explanation: The given array is not sorted.
Your Task:
You don't need to read input or print anything. Your task is to complete the function arraySortedOrNot() which takes the arr[] and N as input parameters and returns a boolean value (true if it is sorted otherwise false).

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 106
- 109 ≤ arr[i] ≤ 109
 */

//THREE DIFFERENT SOLUTIONS
class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
    //     // code here
    //     if(n==1 || n==0)
    //         return true;
    //     if(arr[n-1]<arr[n-2])
    //         return false;
    //     return arraySortedOrNot(arr,n-1);
    // }
    
    // // boolean isSorted(int[] arr, int idx, int n){
    // //     if(idx==n-1)
    // //         return true;
    // //     if(arr[idx]>arr[idx+1])
    // //         return false;
    // //     return isSorted(arr,idx+1,n);
    
    while(--n>0){
        if(arr[n]<arr[n-1])
            return false;
    }
    return true;
    }
}