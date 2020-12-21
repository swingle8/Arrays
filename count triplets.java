// { Driver Code Starts
//Initial Template for Java
// Sort the array first and then O(n^2) get all the possible pairs and sum them and find the sum using Biary search in the sorted array
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);   //nlogn 
        int ans = 0;
        for (int i = 0 ; i < n-1 ; i ++) {
            for (int j = i+1 ; j < n ; j++) {
                int sum = arr[i] + arr[j];  //n2
                if (searchSum(arr, j+1, n-1, sum)) {
                    //System.out.println("yes");
                    ans++;
                }
                
            }
        }
        
        return ans;
    }
    
    boolean searchSum(int [] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > target)
                end = mid-1;
            else if (arr[mid] < target)
                start = mid+1;
            else
                return true;
        }
        return false;
    }
}