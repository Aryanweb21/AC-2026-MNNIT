/**
 * Link - https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
 * 2389. Longest Subsequence With Limited Sum
Solved
Easy
Topics
Companies
Hint
You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
Example 2:

Input: nums = [2,3,4,5], queries = [1]
Output: [0]
Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.
 

Constraints:

n == nums.length
m == queries.length
1 <= n, m <= 1000
1 <= nums[i], queries[i] <= 106
 */

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int ans[] = new int[m];
        Arrays.sort(nums);
        int pref[] = new int[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++)
            pref[i] = pref[i-1]+nums[i];

        for(int i=0;i<m;i++){
            int lb = lowerBound(pref,queries[i]);
            if(lb==-1)
                ans[i] = 0;
            else 
                ans[i]=lb+1;
        }

        return ans;
    }

    int lowerBound(int[] arr,int e){
        int ans=-1;
        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]<=e){
                ans = mid;
                l = mid+1;
            }
            else
                r = mid-1;
        }
        return ans;
    }
}