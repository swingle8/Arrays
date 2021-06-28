5780. Remove One Element to Make the Array Strictly Increasing

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int len = nums.length;
        int prev = nums[0];
        boolean flag = false;
        for (int i = 1 ; i < len ; i++) {
            int curr = nums[i];
            if (prev < curr) {
                prev = curr;
            }
            else {
                if (! flag)
                    flag = true;
                else
                    return false;
                if (i-2 >= 0 && nums[i-2] < curr && i+1 < len && curr < nums[i+1])
                        prev = curr;
                else if (i-2 >= 0 && nums[i-2] < prev && i+1 < len && prev < nums[i+1])  
                        continue;
                else if (i-2 < 0 && i+1 < len && curr < nums[i+1])
                        prev = curr;
                else if (i-2 < 0 && i+1 < len && prev < nums[i+1])
                    continue;
            }
        }
        return true;
    }
}