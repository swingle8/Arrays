// https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0
// 
// Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.
// 
// Input:
// First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.
// 
// Output:
// Single line output to print the sorted array.
// 
// Constraints:
// 1<=T<=100
// 1<=N<=100
// 1<=K<=N
// 
// Example:
// Input:
// 2
// 3 3
// 2 1 3
// 6 3
// 2 6 3 12 56 8
// Output:
// 1 2 3
// 2 3 6 8 12 56

// O(n^2) approach


import java.util.*;
import java.lang.*;
import java.io.*;
class NearlySortedAlgorithm
 {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    
	    while (cases --> 0) {
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        
	        int [] arr = new int[n];
	        for (int i=0 ; i < n ; i++) {
	            arr[i] = sc.nextInt();
	        }
	        
	        fixArray(arr, n, k);
	    }
	}
	
	public static void fixArray (int [] A, int n, int k) {
	   for (int i = 0 ; i < n-1 ; i++) {
	       int elem = A[i];
	       int min = Integer.MAX_VALUE;
	       int index = -1;
	       for (int j = i+1 ; j <= i+k ; j++) {
	           if (j >= n)
	            break;
	           if (A[j] < min) {
	            min = A[j];
	            index = j;
	           }
	       }
	       if (min < elem) {
	           int temp = A[i];
	           A[i] = A[index];
	           A[index] = temp;
	       }
	   }
	    
	    for (int i = 0 ; i < n ; i ++) {
	        System.out.print(A[i] + " ");
	    }
	    
	    System.out.println();
	}
}