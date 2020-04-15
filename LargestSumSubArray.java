//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//ignore the (-) ve values and sum less than zeros. basically ignore the negative values.

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int sum = 0;
        int ans = A[0];
        for (int i = 1 ; i < A.length ; i ++) {
            if (sum < 0)
                sum = 0;
            sum = sum + A[i];
            if (sum > ans){
                ans = sum;
            }
                
        }
        return ans;
    }
}