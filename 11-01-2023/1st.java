/*
B. File Name
Link - https://codeforces.com/problemset/problem/978/B
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
You can not just take the file and send it. When Polycarp trying to send a file in the social network "Codehorses", he encountered an unexpected problem. If the name of the file contains three or more "x" (lowercase Latin letters "x") in a row, the system considers that the file content does not correspond to the social network topic. In this case, the file is not sent and an error message is displayed.

Determine the minimum number of characters to remove from the file name so after that the name does not contain "xxx" as a substring. Print 0 if the file name does not initially contain a forbidden substring "xxx".

You can delete characters in arbitrary positions (not necessarily consecutive). If you delete a character, then the length of a string is reduced by 1
. For example, if you delete the character in the position 2
 from the string "exxxii", then the resulting string is "exxii".

Input
The first line contains integer n
 (3≤n≤100)
 — the length of the file name.

The second line contains a string of length n
 consisting of lowercase Latin letters only — the file name.

Output
Print the minimum number of characters to remove from the file name so after that the name does not contain "xxx" as a substring. If initially the file name dost not contain a forbidden substring "xxx", print 0.

Examples
inputCopy
6
xxxiii
outputCopy
1
inputCopy
5
xxoxx
outputCopy
0
inputCopy
10
xxxxxxxxxx
outputCopy
8
Note
In the first example Polycarp tried to send a file with name contains number 33
, written in Roman numerals. But he can not just send the file, because it name contains three letters "x" in a row. To send the file he needs to remove any one of this letters.
 */
*/

import java.util.*;

public class 1st{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        String s = read.next();
        int ans=0;
        for(int i=0;i<n-2;i++)
        {
            /*
                Since we need to find three consecutive 'x' in string, we can clearly say that it will never appear in less
                than 3 elements, so we can start a loop from 0 to n-2 and check if there is any consecutive occurrence of 'x'
                and if 'YES' we can increase the ans by 1.
                ans is holding the number of times we encounter a 'xxx' and need to remove 'x'.
            */
            if(s.charAt(i)=='x' && s.charAt(i+1)=='x' && s.charAt(i+2)=='x')
                ans++;
        }
        System.out.println(ans);
    }
}
