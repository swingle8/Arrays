https://www.interviewbit.com/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together/

public class Solution {
    public int solve(int[] A, int B) {
        int len = A.length;
        if (len == 1)
            return 0;
        
        int smaller = 0;
        for (int i = 0 ; i < len ; i ++) {
            if (A[i] <= B)
                smaller++;
        }
       
        int window = smaller;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int k = -1;
        for (int i = 0 ; i < len ; i++) {
            if (i >= window) {
                if (count > max)
                    max = count;
                
                k++;
                if (A[k] <= B)
                    count--;
                
                if (A[i] <= B)
                    count++;
            }
           
            else if (A[i] <= B ) {
            count++;
            if (count == window)
                return 0;
            }
        }
       
       int iterations = window - max;
       return iterations;
    }
    
}
