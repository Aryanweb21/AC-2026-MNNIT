/**
 * Link - https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * Fractional Knapsack
MediumAccuracy: 32.46%Submissions: 190K+Points: 4
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item here. 

Example 1:

Input:
N = 3, W = 50
value[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.000000
Explanation:
Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total weight becomes 60+100+80.0=240.0
Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
Example 2:

Input:
N = 2, W = 50
value[] = {60,100}
weight[] = {10,20}
Output:
160.000000
Explanation:
Take both the items completely, without breaking.
Total maximum value of item we can have is 160.00 from the given capacity of sack.
Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size N and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= W <= 109
1 <= valuei, weighti <= 104
 */


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        // array to store value to weight ratio
        double ratio[] = new double[n];
        for(int i=0;i<n;i++)
            ratio[i] = (double)arr[i].value/(double)arr[i].weight;
            
        // lets create a 2D array that will store
        // 1 - ratio
        // 2 - value
        // 3 - weight
        double sort[][] = new double[n][3];
        for(int i=0;i<n;i++)
        {
            sort[i][0] = ratio[i]; // 0th col for ratio
            sort[i][1] = arr[i].value; // 1st col for value
            sort[i][2] = arr[i].weight; // 2nd col for weight
        }
        
        // lets sort the sort[][] array on the basis of ratio
        // since we need high ratio values first
        Arrays.sort(sort, Comparator.comparingDouble(o -> o[0]))
        double sum = 0; // variable to store final ans
        
        for(int i=n-1;i>=0;i--) // since the array is sorted in INC order, we will traverse from reverse
        {
            if(W>sort[i][2]){ // if Weight is > ith weight, then
                sum+=sort[i][1]; // plus sum with ith Item.value
                W-=sort[i][2]; // minus W by ith Item.weight
            }
            else{ // if Weight < ith weight
                sum+= sort[i][0]*W; // sum the ith ratio x W & break the loop
                break;
            }
        }
        return sum;
    }
}