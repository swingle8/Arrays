//https://www.interviewbit.com/problems/add-one-to-number/

public class Solution {
    public int[] plusOne(int[] A) {
        int len = A.length;
        boolean increaseLength = false;
        for (int i = len-1 ; i >= 0 ; i--) {
            A[i] = A[i]+1;
            if (A[i] == 10) {
                A[i] = 0;
                if (i == 0) {
                    increaseLength = true;
                }
                continue;
            }
            else
                break;
        }
        
        if (increaseLength) {
            int [] B = new int[len+1];
            B[0]  = 1;
            int k = 1;
            for (int i = 0 ; i < len ;i ++) {
                B[k] = A[i];
                k++;
            }
            
            return B;
        }
        
        int decrease = 0;
        for (int i = 0 ; i < len ;i ++) {
            if (A[i] == 0)
               decrease++;
            else
                break;
        }
        
        int [] B = new int[len-decrease];
        int k = 0;
        for (int i = decrease ; i < len ;i ++) {
            B[k] = A[i];
            k++;
        }
        
        return B;
    }
}
