/**
 * Link - https://codeforces.com/problemset/problem/474/B
 * B. Worms
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
It is lunch time for Mole. His friend, Marmot, prepared him a nice game for lunch.

Marmot brought Mole n ordered piles of worms such that i-th pile contains ai worms. He labeled all these worms with consecutive integers: worms in first pile are labeled with numbers 1 to a1, worms in second pile are labeled with numbers a1 + 1 to a1 + a2 and so on. See the example for a better understanding.

Mole can't eat all the worms (Marmot brought a lot) and, as we all know, Mole is blind, so Marmot tells him the labels of the best juicy worms. Marmot will only give Mole a worm if Mole says correctly in which pile this worm is contained.

Poor Mole asks for your help. For all juicy worms said by Marmot, tell Mole the correct answers.

Input
The first line contains a single integer n (1 ≤ n ≤ 105), the number of piles.

The second line contains n integers a1, a2, ..., an (1 ≤ ai ≤ 103, a1 + a2 + ... + an ≤ 106), where ai is the number of worms in the i-th pile.

The third line contains single integer m (1 ≤ m ≤ 105), the number of juicy worms said by Marmot.

The fourth line contains m integers q1, q2, ..., qm (1 ≤ qi ≤ a1 + a2 + ... + an), the labels of the juicy worms.

Output
Print m lines to the standard output. The i-th line should contain an integer, representing the number of the pile where the worm labeled with the number qi is.

Examples
inputCopy
5
2 7 3 4 9
3
1 25 11
outputCopy
1
5
3
 */

import java.util.*;

public class Ques2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int worms[] = new int[n];
        for(int i=0;i<n;i++)
            worms[i] = read.nextInt();
        int m = read.nextInt();
        int q[] = new int[m];
        for(int i=0;i<m;i++)
            q[i] = read.nextInt();

        int prefSum[] = new int[n];
        prefSum[0]=worms[0];
        for(int i=1;i<n;i++)
            prefSum[i] = prefSum[i-1]+worms[i];

        for(int i:q){
            System.out.println(lowerBound(prefSum,i));
        }
    }

    static int lowerBound(int arr[], int target){
        int left = 0;
        int right = arr.length;
        int ans = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>=target){
                ans = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return ans+1;
    }
}