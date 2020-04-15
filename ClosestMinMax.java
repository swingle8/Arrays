// # Given an array of size N. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array and atleast one occurrence of the minimum value of the array. Constraints:
// # 1.   1 <= N <= 2000
// # Input Format An integer array. Output Format Length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array Example Input
// # Array:[1 3 5 2 4 3]
// # Example Output
// # 3

public class Solution {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0 ; i < A.length ; i++) {
            int elem = A[i];
            if (max < elem)
                max = elem;
            if (min > elem)
                min = elem;
        }
        
        if (max == min)
            return 1;
        
        int ans = Integer.MAX_VALUE;
        int min_index = -1;
        int max_index = -1;
        for (int i = 0 ; i < A.length ; i++) {
            int elem = A[i];
            if (elem == max) {
                    max_index = i;
            }
            else if (elem == min) {
                min_index = i;
            }
            
            if (max_index != -1 && min_index != -1) {
                int len = Math.max(max_index, min_index) - Math.min(max_index, min_index) + 1;
                if (len < ans)
                    ans = len;
            }
                
        }
        
        return ans;
    }
}
