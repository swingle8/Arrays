class GFG
{
    static void rotate(int matrix[][]) 
    {
        int n = matrix[0].length;
        
        for (int j = 0 ; j < n/2 ; j++) {    
            for (int i = j ; i < n-1-j ; i++) {
                int num = matrix[j][i];
                
                int temp = matrix[n-1-i][j];
                matrix[n-1-i][j] = num;
                num = temp;
                
                temp = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = num;
                num = temp;
                
                temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = num;
                num = temp;
                
                temp = matrix[j][i];
                matrix[j][i] = num;
            }
        }
    }
}