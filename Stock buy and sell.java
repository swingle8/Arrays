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
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        int j = 1;
        int maxProfit = 0;
        while (j <= n-1) {
            if (A[j] - A[i] < 0) {
                if (maxProfit > 0) {
                    maxProfit = 0;
                    putinAns (ans, i, j-1); 
                }
                i = j;
                j++;
            }
            else if (A[j] - A[i] == 0) {
                if (maxProfit > 0) {
                    maxProfit = 0;
                    putinAns (ans, i, j-1); 
                }
                i = j;
                j++;
            }
            else if (A[j] - A[i] > 0) {
                if (maxProfit <= A[j] - A[i]) {
                    maxProfit = A[j] - A[i];
                    j++;
                }
                else {
                    maxProfit = 0;
                    putinAns (ans, i, j-1);
                    i = j;
                    j++;
                }
            }
        }
        
        if (maxProfit > 0)
            putinAns (ans, i, j-1);

        return ans;
    }
    
    void putinAns (ArrayList<ArrayList<Integer>> ans, int i, int j) {
        ArrayList<Integer> put = new ArrayList<Integer>();
        put.add(i);
        put.add(j);
        ans.add(put);
    }
}
