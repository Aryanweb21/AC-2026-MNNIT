/**
 * Link - https://leetcode.com/problems/k-th-symbol-in-grammar/description/?envType=list&envId=o7km4wrg
 * 779. K-th Symbol in Grammar
Solved
Medium
Topics
Companies
Hint
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

 

Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
 

Constraints:

1 <= n <= 30
1 <= k <= 2n - 1
 */

class Solution {
    // public int kthGrammar(int n, int k) {
    //     String s = getGrammer(n,1,new StringBuilder("0"));
    //     int ans = s.charAt(k-1)-'0';
    //     return ans;
    // }

    // String getGrammer(int n, int x, StringBuilder in){
    //     if(x==n){
    //         // String ans = new String(sb.toString());
    //         return in.toString();
    //     }
    //     StringBuilder out = new StringBuilder();
    //     for(int i=0;i<in.length();i++){
    //         if(in.charAt(i)=='0'){
    //             out.append("01");
    //         }else{
    //             out.append("10");
    //         }
    //     }
    //     return getGrammer(n,x+1,out);
    // }

    public int kthGrammar(int n, int k){
        if(n == 1 && k == 1){
            return 0;
        }

        int mid = (int)Math.pow(2,n-1)/2;

        if(k <= mid)
            return kthGrammar(n-1, k);
        else{
            int result = kthGrammar(n-1, k-mid);
            return (result == 0) ? 1 : 0;

        }
    }
}