/**
 * Link - https://www.geeksforgeeks.org/problems/insertion-sort/1
 * Insertion Sort
EasyAccuracy: 66.61%Submissions: 125K+Points: 2
The task is to complete the insert() function which is used to implement Insertion Sort.


Example 1:

Input:
N = 5
arr[] = { 4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Example 2:

Input:
N = 10
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output:
1 2 3 4 5 6 7 8 9 10

Your Task: 
You don't have to read input or print anything. Your task is to complete the function insert() and insertionSort() where insert() takes the array, it's size and an index i and insertionSort() uses insert function to sort the array in ascending order using insertion sort algorithm. 

Expected Time Complexity: O(N*N).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N <= 1000
1 <= arr[i] <= 1000


 */

class Solution {
    static void insert(int arr[], int i) {
        if (i <= 0) return;
        insert(arr, i - 1);
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }

    public void insertionSort(int arr[], int n) {
        if (n <= 1) return;
        insertionSort(arr, n - 1);
        insert(arr, n - 1);
    }
}