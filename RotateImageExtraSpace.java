https://leetcode.com/problems/rotate-image/
class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] newMat = new int[rows][cols];
        
        for (int i = 0 ; i < rows ; i ++) {
            int newcol = cols-i-1;
            for (int j = 0 ; j < cols ; j ++) {
                newMat[j][newcol] = matrix[i][j];
            }
        }
        
        for (int i = 0 ; i < rows ; i ++) {
            for (int j = 0 ; j < cols ; j ++) {
                matrix[i][j] = newMat[i][j];
            }
        }
    }
}