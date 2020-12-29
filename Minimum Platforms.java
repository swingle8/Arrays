// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Platform().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends


//User function Template for Java

class Platform
{
    static int findPlatform(int arr[], int dep[], int n) {
        int Maxplatforms = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0;
        int j = 0;
        int platforms = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            }
            else {
                j++;
                platforms--;
            }
            if (platforms > Maxplatforms)
                Maxplatforms = platforms;
        }
        
        return Maxplatforms;
    }
    
}

