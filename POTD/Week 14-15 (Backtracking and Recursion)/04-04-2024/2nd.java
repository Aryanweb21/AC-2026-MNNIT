/**
 * Link - https://www.geeksforgeeks.org/problems/sum-of-array2326/1
 * Sum of Array
SchoolAccuracy: 74.98%Submissions: 92K+Points: 0
Given an integer array arr[] of size n. The task is to find sum of it.

Example 1:

Input:
n = 4
arr[] = {1, 2, 3, 4}
Output: 10
Explanation: 1 + 2 + 3 + 4 = 10.
Example 2:

Input:
n = 3
arr[] = {1, 3, 3}
Output: 7
Explanation: 1 + 3 + 3 = 7.
Your Task:
Complete the function sum() which takes array arr and single integer n, as input parameters and returns an integer denoting the answer. You don't have to print answer or take inputs.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= arr[i] <= 104

 
 */

class Solution {
    // int sum(int arr[], int n) {
    //     // code here
    //     return getSum(arr,0,n-1);
    // }
    
    // int getSum(int[] arr, int sum, int n){
    //     if(n==0)
    //         return arr[0];
    //     return arr[n]+getSum(arr,sum,n-1);
    // }
    int sum(int arr[], int n){
        if(n==1)
            return arr[0];
        return arr[n-1]+sum(arr,n-1);
    }
}