https://leetcode.com/problems/rotate-image/submissions/

class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int totalCycles = rows/2;
        int cycle = 1;
        while (cycle <= totalCycles) {
        for (int i = cycle-1 ; i < rows-cycle ; i ++) {
            int element = matrix[cycle-1][i];
            
            int element2 = matrix[i][cols-cycle];
            matrix[i][cols-cycle] = element;
            
            int element3 = matrix[rows-cycle][cols-1-i];
            matrix[rows-cycle][cols-1-i] = element2;
            
            int element4 = matrix[rows-1-i][cycle-1];
            matrix[rows-1-i][cycle-1] = element3;
            
            matrix[cycle-1][i] = element4;
            
        }
        cycle++;
        }
        
       
    }
}