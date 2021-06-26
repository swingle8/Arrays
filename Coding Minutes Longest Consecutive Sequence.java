class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0 ; i < nums.length ; i++)
            set.add(nums[i]);
        
        for (int i = 0 ; i < nums.length ; i++) {
            int curr = nums[i];
            if (set.contains(curr-1))
                continue;
            else {
                int next = curr+1;
                int subLen = 1;
                while (set.contains(next)) {
                    subLen++;
                    next++;
                }
                len = Math.max(len, subLen);
            }
        }
        return len;
    }
}