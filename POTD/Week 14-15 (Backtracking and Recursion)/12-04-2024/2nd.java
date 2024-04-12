/**
 * Link - https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=list&envId=o7km4wrg
 * 17. Letter Combinations of a Phone Number
Solved
Medium
Topics
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0)
            return list;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        solve(map,list,digits,0,sb);
        return list;
    }

    void solve(String[] map, List<String> list, String digit, int idx,StringBuilder sb){
        if(idx>=digit.length()){
            list.add(sb.toString());
            return;
        }
        int n = digit.charAt(idx)-'0';
        String value = map[n];
        for(int i=0;i<value.length();i++){
            sb.append(value.charAt(i));
            solve(map,list,digit,idx+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}