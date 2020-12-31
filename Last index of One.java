//https://practice.geeksforgeeks.org/problems/last-index-of-1/0
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases -- > 0) {
	        String s = sc.next();
	        int len = s.length();
	        boolean found = false;
	        for (int i = len-1; i >= 0 ; i--) {
	            if (Character.getNumericValue(s.charAt(i)) == 1) {
	                found = true;
	                System.out.println(i);
	                break;
	            }
	        }
	        if (! found)
	            System.out.println(-1);
	    }
	 }
}