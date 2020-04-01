class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int k = 1;
        for (int i = 0 ; i < len ; i ++) {
            if (nums[i] < 1 || nums[i] < k)
                continue;
            else if (nums[i] == k)
                k++;
                
            else
                break;
        }
        
        return k;
        
    }
}