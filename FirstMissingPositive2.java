class Solution {
    public int firstMissingPositive(int[] nums) {
      
        int len = nums.length;
        int [] next = new int[len];
       
        for (int i = 0 ; i < len ; i ++) {
            int curr = nums[i];
            if (curr > 0 && curr < len+1) {
                next[curr-1] = curr;
            }
        }
       
        
        int k = 1;
        for (int i = 0 ; i < len ; i ++) {
            if (next[i] == k)
                k++;
            else
                break;
        }
        
        return k;
    }
}