public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        //System.out.println(n);
        int m = A[0].length;
        //System.out.println(m);
        int total = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j ++) {
                for (int k = i ; k < n ; k++) {
                    for (int l = j ; l < m ; l++) {
                        int sum = 0;
                        for (int o = i ; o <= k ; o++) {
                            for (int p = j ; p <= l ; p++) {
                                sum = sum + A[o][p];
                            }
                        }
                        total = total + sum;
                    }
                }
            }
        }
        return total;
    }
    
}
