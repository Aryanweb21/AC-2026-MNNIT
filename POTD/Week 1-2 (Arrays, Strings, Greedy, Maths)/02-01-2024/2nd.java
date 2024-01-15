/*
    Title - Union of two arrays
    Link - https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
*/

/* 
    Given two arrays a[] and b[] of size n and m respectively. The task is to find the number of elements in the union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union.

Note : Elements are not necessarily distinct.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3
Output: 
5
Explanation: 
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.
Example 2:

Input:
6 2 
85 25 1 32 54 6
85 2 
Output: 
7
Explanation: 
85, 25, 1, 32, 54, 6, and
2 are the elements which comes in the
union set of both arrays. So count is 7.
Your Task:
Complete doUnion function that takes a, n, b, m as parameters and returns the count of union elements of the two arrays. The printing is done by the driver code.

Constraints:
1 ≤ n, m ≤ 105
0 ≤ a[i], b[i] < 105

Expected Time Complexity : O(n+m)
Expected Auxilliary Space : O(n+m)
*/

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        //Your code here
        // initialize the Set Data Structure for storing non-duplicate elements from both arrays
        Set<Integer> unionOfArrays = new HashSet<>();
        
        // iterate through 1st array to store elements
        for(int i=0;i<n;i++){
            unionOfArrays.add(a[i]);
        }
        
        // iterate through 2nd array to store the elements
        for(int i=0;i<m;i++)
            unionOfArrays.add(b[i]);

        // return the size of Set containing union of both arrays
        return unionOfArrays.size();
    }
}