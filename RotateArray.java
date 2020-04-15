//https://practice.geeksforgeeks.org/problems/reversal-algorithm/0
//Rotating an Array


import java.util.*;
import java.lang.*;
import java.io.*;
public class RotateArray
 {
	public static void main (String[] args)
	 {
	 Scanner sc = new Scanner(System.in);
	 int cases = sc.nextInt();
	 
	 while (cases --> 0) {
	     int size = sc.nextInt();
	     int [] ar = new int[size];
	     
	     for (int i = 0 ; i < size ; i++)
	         ar[i] = sc.nextInt();
	     
	     int k = sc.nextInt();
	     ar = getChanged(ar, k, size);
	     
	     for (int j = 0 ; j < size ; j++)
	        System.out.print(ar[j] + " ");
	        
	   
	 }
	 }
	 
	 public static int [] getChanged (int [] A, int k, int n) {
	     A = flip (A, 0, k-1);
	     A = flip (A, k, n-1);
	     A = flip (A, 0, n-1);
	     return A;
	 }
	 
	 public static int [] flip (int [] A, int start, int end) {
	     while (start < end) {
	         int temp = A[start];
	         A[start] = A[end];
	         A[end] = temp;
	         start++;
	         end--;
	     }
	     
	     return A;
	 }
}