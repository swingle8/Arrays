// https://practice.geeksforgeeks.org/problems/find-transition-point/1
// You are given a sorted array containing only numbers 0 and 1. Find the transition point efficiently. Transition point is a point where "0" ends and "1" begins.
// Note that, if there is no "1" exists, print -1.
// 
// Input:
// 
// You have to complete the method which takes 2 argument: the array arr[] and size of array N. You should not read any input from stdin/console. There are multiple test cases. For each test cases, this method will be called individually.
// 
// Output:
// 
// Your function should return transition point.
// 
// Constraints:
// 
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 500000
// 0 ≤ C[i] ≤ 1
// Example:
// 
// Input
// 1
// 5
// 0 0 0 1 1
// 
// Output
// 3


import java.util.*;

class SortedArrayTransitionalPoint {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}// } Driver Code Ends

class GfG {
    int transitionPoint(int arr[], int n) {
        int ans = 0;
        int mid = n/2;
        return (findPoint(arr, 0, mid, n-1));
    }
    
    int findPoint(int [] A, int start, int mid, int last) {
        if (A[mid] == 1 && mid == 0)
            return 0;
        
        else if (A[mid] == 1 && A[mid-1] == 0)
            return mid;
        
        else if (last <= start)
            return -1;
        
        if (A[mid] == 0) {
            start = mid+1;
            last = last;
            mid = (last + start)/2;
            return (findPoint (A, start, mid, last));
        }
        else if (A[mid] == 1) {
            start = start; 
            last = mid-1;
            mid = (last + start)/2;
           return (findPoint (A, start , mid , last));
        }
        
        return -1;
    }
}