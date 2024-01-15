/*
    Link - https://codeforces.com/problemset/problem/1758/B
    B. XOR = Average
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
You are given an integer n
. Find a sequence of n
 integers a1,a2,…,an
 such that 1≤ai≤109
 for all i
 and
a1⊕a2⊕⋯⊕an=a1+a2+⋯+ann,
where ⊕
 represents the bitwise XOR.

It can be proven that there exists a sequence of integers that satisfies all the conditions above.

Input
The first line of input contains t
 (1≤t≤104
) — the number of test cases.

The first and only line of each test case contains one integer n
 (1≤n≤105
) — the length of the sequence you have to find.

The sum of n
 over all test cases does not exceed 105
.

Output
For each test case, output n
 space-separated integers a1,a2,…,an
 satisfying the conditions in the statement.

If there are several possible answers, you can output any of them.

Example
inputCopy
3
1
4
3
outputCopy
69
13 2 8 1
7 7 7
Note
In the first test case, 69=691=69
.

In the second test case, 13⊕2⊕8⊕1=13+2+8+14=6
.


*/

import java.util.*;

public class Ques2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt(); // no of testcases
        int[] arrTestCases = new int[n]; // array to store testcases
        for(int i=0;i<n;i++)
            arrTestCases[i] = read.nextInt(); // input testcases in array

        for(int i:arrTestCases) // loop to iterate over each testcase
        {
                /*
                    since there is no compulsion of particular output, we can return any output that matches the given
                    conditions.
                    Thus, if testcase is odd, we can print 1 i times because 1^oddtimes will give 1 &
                    average of 1s is always 1

                    similarly, if testcase is even, we can print 1&3 first and then print 2 i-2 times because
                    1^3 is 2 and 2^eventimes will always give 0 thus 2^0=2
                    the average will always be 2
                */
            if(i%2!=0){ // if testcase(i) is odd, we can print 1 i times
                for(int j=1;j<=i;j++)
                    System.out.print("1 ");
            }
            else{
                System.out.print("1 "+"3 ");
                for(int j=3;j<=i;j++)
                    System.out.print("2 ");
            }
            System.out.println();
        }
    }
}
