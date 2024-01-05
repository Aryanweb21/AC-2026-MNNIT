/*
    Link - https://codeforces.com/contest/1829/problem/A
    A. Love Story
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
Timur loves codeforces. That's why he has a string s
 having length 10
 made containing only lowercase Latin letters. Timur wants to know how many indices string s
 differs from the string "codeforces".

For example string s=
 "coolforsez" differs from "codeforces" in 4
 indices, shown in bold.

Help Timur by finding the number of indices where string s
 differs from "codeforces".

Note that you can't reorder the characters in the string s
.

Input
The first line contains a single integer t
 (1≤t≤1000
) — the number of test cases.

Each test case is one line and contains the string s
, consisting of exactly 10
 lowercase Latin characters.

Output
For each test case, output a single integer — the number of indices where string s
 differs.

Example
inputCopy
5
coolforsez
cadafurcie
codeforces
paiuforces
forcescode
outputCopy
4
5
0
4
9

*/

import java.util.*;

public class Ques2 {
    public static void main(String[] args) {
        // object of scanner class to read the input
        Scanner read = new Scanner(System.in);
        // string array to store input strings
        String[] str = new String[read.nextInt()];
        for(int i=0;i< str.length;i++)
            str[i] = read.next();
        // loop to traverse each string in str
        for(String sh:str)
            System.out.println(countDiff(sh)); // call countDiff() function and print the return values
    }

    // function to count the different indices 
    static int countDiff(String str)
    {
        // lets create the string 'codeforces' to which we will compare all the strings one by one
        String s = "codeforces";
        // initialize the variable count=0 to store the no. of different indices values
        int count=0;
        // traverse through each character in str
        for(int i=0;i<str.length();i++)
        {
            // if the ith character of str is not the same as ith character of s, increase count by 1
            if(s.charAt(i)!=str.charAt(i))
                count++;
        }
        // return count as ans
        return count;
    }
}

