class Solution {
    public int longestMountain(int[] arr) {
        int largest = 0;
        
        for (int i = 1 ; i < arr.length-1 ; ) {
            //peak rule
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                //see back
                int index = i;
                int count = 0;
                while (index > 0 && arr[index] > arr[index-1]) {
                    count++;
                    index--;
                }
                
                //see front
                //index = i;
                while (i < arr.length-1 && arr[i] > arr[i+1]) {
                    count++;
                    i++;
                }
                
                count++;
                largest = Math.max(largest, count);
                
            }
            else {
                i++;
            }
            
        }
        
        
        return largest;
    }
}