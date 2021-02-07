// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Josephus obj=new Josephus();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}

// } Driver Code Ends


class Josephus
{
   public int josephus(int n, int k)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0 ; i < n ; i++)
            al.add(i+1);
        int weaponIndex = 0;
        while (al.size() != 1) {
            int killIndex = weaponIndex + k - 1;
            int size = al.size();
            if (killIndex >= size)
                killIndex = killIndex%size;
            
            weaponIndex = killIndex;
            al.remove(killIndex);
        }
        
        return al.get(0);
    }

}

