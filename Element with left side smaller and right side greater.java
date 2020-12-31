//https://practice.geeksforgeeks.org/problems/unsorted-array/0#
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    
	    while (cases --> 0) {
	        int n = sc.nextInt();
	        int [] arr = new int [n];
	        for (int i = 0 ; i < n ; i++) {
	            arr[i] = sc.nextInt();
	        }
	        
	        int [] arrRight = new int[n];
	        arrRight[n-1] = arr[n-1];
	        for (int i = n-2 ; i >= 0 ; i--)
	            arrRight[i] = Math.min(arr[i], arrRight[i+1]);
	       
	        int max = arr[0];
	        boolean found = false;
	        for (int i = 1 ; i < n-1 ; i++) {
	            max = Math.max(max, arr[i]);
	            if (arr[i] >= max && arr[i] <= arrRight[i]) {
	                System.out.println(arr[i]);
	                found = true;
	                break;
	            }
	        }
	        
	        if (! found) {
	            System.out.println(-1);
	        }
	    }
	 }
}