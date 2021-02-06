// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                for (int i=0; i<ans.size(); ++i){
                    System.out.print("("+ans.get(i).get(0)+" "+ans.get(i).get(1)+") ");
                }
            }System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        int buy = 0;
        int sell = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        
        while (i < n) {
            while (i < n-1 && A[i+1] <= A[i])
                i++;
        
            if (i == n-1)
                return ans;
            
            buy = i;
            i++;
            while (i < n-1 && A[i] <= A[i+1])
                i++;
            
            sell = i;
            ArrayList<Integer> ans1 = new ArrayList<Integer>();
            ans1.add(buy);
            ans1.add(sell);

            ans.add(ans1);
        
        }
        
        return ans;
    }
    
    // void transaction (int buy, int sell, int profit) {
    //     profit = profit + (sell-buy);
    // }
}
