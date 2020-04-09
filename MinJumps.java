https://www.interviewbit.com/problems/min-jumps-array/

public class Solution {
    public int jump(int[] A) {
       int max = 0;
       int level = 0;
       int end = 0;
       int len = A.length;
       
       for (int i = 0 ; i < len-1 ; i ++) {
           max = Math.max(max, i+A[i]);
          if (max == 0 && len-1 == i)
                break;
          if (max == 0) {
              level = -1;
              break;
          }
           
           if (end == i) {
               level++;
               end = max;
           }
       }
       
       return level;
    }
   
}
