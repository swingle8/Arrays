// { Driver Code Starts
import java.io.*;
import java.util.*;

class Equilibrium {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            EquilibriumPoint obj = new EquilibriumPoint();
            
            //calling equilibriumPoint() function
            System.out.println(obj.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends


class EquilibriumPoint {

    // Function to find equilibrium point
    // a: input array
    // n: size of array
    public static int equilibriumPoint(long arr[], int n) {
        int start = 0;
        int end = n-1;
        long sumLeft = arr[start];
        long sumRight = arr[end];
        
        while (start < end) {
            if (sumLeft < sumRight) {
                start++;
                sumLeft = sumLeft + arr[start]; 
            }
            else {
                end--;
                sumRight = sumRight + arr[end];
            }
        }
        if (sumLeft == sumRight)
            return start+1;
        return -1;
    }
}
