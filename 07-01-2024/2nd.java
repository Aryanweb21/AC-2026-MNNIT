/*
    A. Short Sort
    Link - https://codeforces.com/contest/1873/problem/A
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
There are three cards with letters a
, b
, c
 placed in a row in some order. You can do the following operation at most once:

Pick two cards, and swap them.
Is it possible that the row becomes abc
 after the operation? Output "YES" if it is possible, and "NO" otherwise.
Input
The first line contains a single integer t
 (1≤t≤6
) — the number of test cases.

The only line of each test case contains a single string consisting of each of the three characters a
, b
, and c
 exactly once, representing the cards.

Output
For each test case, output "YES" if you can make the row abc
 with at most one operation, or "NO" otherwise.

You can output the answer in any case (for example, the strings "yEs", "yes", "Yes" and "YES" will be recognized as a positive answer).

Example
inputCopy
6
abc
acb
bac
bca
cab
cba
outputCopy
YES
YES
YES
NO
NO
YES
Note
In the first test case, we don't need to do any operations, since the row is already abc
.

In the second test case, we can swap c
 and b
: acb→abc
.

In the third test case, we can swap b
 and a
: bac→abc
.

In the fourth test case, it is impossible to make abc
 using at most one operation.
*/

import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[] str = new String[read.nextInt()];
        for(int i=0;i< str.length;i++)
            str[i]= read.next();

        for(String s:str)
        {
            if(isPerfect(s.toCharArray()))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    static boolean isPerfect(char c[])
    {
        if(c[0]=='a')
            return true;
        else if(c[1]=='a' && c[0]=='b')
            return true;
        else if(c[2]=='a' && c[1]=='b')
            return true;
        else
            return false;
    }
}
