https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
    Set<Integer> hm = new HashSet<Integer>(); 
    int val = -1;
    for (int i = 0 ; i < nums.length ; i++) {
        int num = nums[i];
        if (hm.contains(num)) {
            return num;
        }
        
        hm.add(num);
    }

    return val;
}
}