//https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1/?company[]=Goldman%20Sachs&company[]=Salesforce&page=1&query=company[]Goldman%20Sachscompany[]Salesforcepage1
// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long a[]=new long[n];
		  long b[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      a[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      b[i]=sc.nextLong();
		  }
		  
		  System.out.println(check(a,b,n)==true?"1":"0");
		  
		  
		}
	}

 // } Driver Code Ends


//User function Template for Java


public static boolean check(long arr[],long brr[],int n)
{
    HashMap<Long, Integer> map = new HashMap<Long, Integer> ();
    for (int i = 0 ; i < n ; i ++) {
        long num = arr[i];
        if (! map.containsKey(num))
            map.put(num, 0);
        int newVal = map.get(num) + 1;
        map.put(num, newVal);
    }
    int len = n;
    
    for (int i = 0 ; i < n ; i ++) {
        long num = brr[i];
        if (map.containsKey(num) && map.get(num) > 0) {
            int newVal = map.get(num) - 1;
            map.put(num, newVal);
            len--;
        }
        else
            return false;
    }
    if (len == 0)
        return true;
    return false;

}

// { Driver Code Starts.
	    



}  // } Driver Code Ends