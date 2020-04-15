// https://www.geeksforgeeks.org/trapping-rain-water/
//precalculate maxRight and MaxLeft for each index.

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int len = A.length;
        int [] maxRight = new int[len];
        maxRight[len-1] = A[len-1]; 
        for (int i = len-2 ; i >= 0 ; i--) {
            maxRight[i] = Math.max(A[i], maxRight[i+1]);
        }
        
        
        
        int ans = 0;
        int maxLeft = A[0];
        for (int i = 1 ; i < len-1 ; i ++) {
            maxLeft = Math.max(maxLeft, A[i-1]);
            int surr = Math.min(maxLeft, maxRight[i]);
            if (A[i] < surr)
                ans = ans + (surr-A[i]);
        }
        
        return ans;
        
    }
}
