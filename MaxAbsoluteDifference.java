//https://www.geeksforgeeks.org/maximum-absolute-difference-value-index-sums/
// derive the formulae mathematically

public class Solution {
    public int maxArr(int[] A) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < A.length ; i++) {
            int k = A[i] + i;
            int l = A[i] - i;
            if (max1 < k)
                max1 = k;
            if (min1 > k)
                min1 = k;
            
            if (max2 < l)
                max2 = l;
            if (min2 > l)
                min2 = l;
        }
        
        if ((max1-min1) > (max2-min2))
            return (max1-min1);
            
        return (max2-min2);
    }
}