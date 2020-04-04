https://www.interviewbit.com/problems/sum-of-all-submatrices/

public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int total = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j ++) {
                int element = A[i][j];
                int waysForL1 = i+1;
                int whaysForL2 = n-i;
                int waysForR1 = j+1;
                int whaysForR2 = m-j;
                
                int totalWays = waysForL1*whaysForL2*waysForR1*whaysForR2;
                int contri = totalWays * element;
                total = total + contri;
                
            }
        }
        return total;
    }
    
}
