// https://practice.geeksforgeeks.org/problems/counts-zeros-xor-pairs/0
// 
// Given an array A[] of size N. Find the number of pairs (i, j) such that  A_i  XOR  A_j  = 0, and 1 <= i < j <= N.
// 
// Input:
// The first line of the input contains a single integer T denoting the number of test cases. The first line of each test case contains N. followed by N separate integers. 
// 
// Output:
// For each test case, output a single integer i.e counts of Zeros Xors Pairs
// 
// Constraints
// 1 ≤ T ≤ 200
// 2 ≤ N ≤ 10^5
// 1 ≤ A[i] ≤ 10^5
// 
// Example:
// Input :
// 2
// 5
// 1 3 4 1 4
// 
// 3
// 2 2 2
// 
// Output :
// 
// 2
// 3
// 
// Explanation :
// 
// Test Case 1: Index( 0, 3 ) and (2 , 4 ) are only pairs whose xors is zero so count is 2.
// 
// 
// Approach : 
// 1. Sort the Array.
// 2. count the no. of elemts having same value.
// 3. Mathematiocally derived formulae to calculate the no. of XORs
// 
// Formulae :
// 3 3 3 3 => 0 index forms pair with (1, 2, 3) = (n-1)
// 		   1 index forms pair with (2, 3) = (n-2)
// 		   2 index forms pair with (3) = (n-3)
// 		   3 can't form pair = (n-n)
// 	(n-1) + (n-2) + (n-3) +  . . . .  . + (n-n)
// 	n - 1 + n - 2 + n - 3 + n -4 + .... + n - n 
// 	n*n - (1 + 2 + 3 + 4 + . .  . . + n)
// 	n*n - (n (n + 1)/2)
// 	n*n - n*n/2 - n/2
// 	n*n/2 - n/2
// 	
// 	n ((n-1)/2) 

import java.util.*;
import java.lang.*;
import java.io.*;
public class ZeroXORPairs
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    
	    while (cases --> 0) {
	        int len = sc.nextInt();
	        int [] A = new int[len];
	        
	        for (int i = 0 ; i < len ; i++)
	            A[i] = sc.nextInt();
	       
	        System.out.println(Xor(A, len));
	    }
	 }
	 
	 public static int Xor (int [] A, int len) {
	     Arrays.sort(A);
	     int sum = 0;
	     int prev = A[0];
	     int count = 1;
	     for (int i = 1; i < len ; i++) {
	         if (prev == A[i]) {
	             count++;
	         }
	         else {
	             if (count > 1) {
	                 sum = sum + (count * (count - 1))/2;
	             }
	             
	             prev = A[i];
	             count = 1;
	         }
	     }
	     
	     if (count > 1)
	        sum = sum + (count * (count - 1))/2;
	     
	     return sum;
	 }
}