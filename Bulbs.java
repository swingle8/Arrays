public class Solution {
    public int bulbs(int[] A) {
        int len = A.length;
        int count = 0;
        boolean flag = true;
        
        for (int i = 0 ; i < len ; i ++) {
            if (flag && A[i] == 0) {
                count++;
                flag = false;
            }
            else if (!flag && A[i] == 1) {
                    count++;
                    flag = true;
                }
            }
        return count;
    }
}