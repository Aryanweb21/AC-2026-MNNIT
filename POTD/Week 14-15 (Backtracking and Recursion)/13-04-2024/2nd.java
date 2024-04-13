/**
 * Link - https://leetcode.com/problems/letter-case-permutation/description/
 * 784. Letter Case Permutation
Solved
Medium
Topics
Companies
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 

Constraints:

1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.
 */

class Solution {
    // public List<String> letterCasePermutation(String s) {
    //     int count = 0;
    //     for(char ch : s.toCharArray()){
    //         if(ch>='A' && ch<='Z' || ch>='a' && ch<='z')
    //             count++;
    //     }
    //     List<String> ans = new ArrayList<>();
    //     ans.add(s);
    //     for(int i=1;i<(1<<count);i++){
    //         int skips=0;
    //         StringBuilder sb = new StringBuilder(s);
    //         for(int j=0;j<s.length();j++){
    //             char c = s.charAt(j);
    //             if(!Character.isLetter(c))
    //                 skips++;
    //             else{
    //                 if((i & (1<<(j-skips)))!=0){
    //                     if(c>='A' && c<='Z')
    //                         sb.setCharAt(j,(char)(c+32));
    //                     else
    //                         sb.setCharAt(j,(char)(c-32));
    //                 }
    //             }
    //         }
    //         ans.add(sb.toString());
    //     }
    //     return ans;
    // }

    public List<String> letterCasePermutation(String s){
        List<String> list = new ArrayList<>();
        solve(s,list,new StringBuilder());
        return list;
    }

    void solve(String input, List<String> list,StringBuilder output){
        if(input.length()==0){
            String str = new String(output.toString());
            list.add(str);
            return;
        }
        char c = input.charAt(0);
        if(Character.isLetter(c)){
            StringBuilder sb1 = new StringBuilder(output);
            StringBuilder sb2 = new StringBuilder(output);
            sb1.append(Character.toLowerCase(c));
            sb2.append(Character.toUpperCase(c));
            solve(input.substring(1),list,sb1);
            solve(input.substring(1),list,sb2);
        }
        else{
            output.append(c);
            solve(input.substring(1),list,output);
        }
    }
}