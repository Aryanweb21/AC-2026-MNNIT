/**
 * Link - https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * 1351. Count Negative Numbers in a Sorted Matrix
Solved
Easy
Topics
Companies
Hint
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 

Follow up: Could you find an O(n + m) solution?
 */

class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int n = grid.length;
        for(int i=0;i<n;i++)
            count += binarySearch(grid[i]);
        return count;
    }
    
    int binarySearch(int a[]){
        int count=0;
        int l=0;
        int r = a.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]<0){
                count+= (r-mid+1);
                r = mid-1;
            }
            else
                l = mid+1;
        }
        return count;
    }
}