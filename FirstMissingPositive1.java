class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int hashmapKey = 0;;
        for (int i = 0 ; i < len ; i ++) {
            int curr = nums[i];
            if (curr > 0 && curr < len+2) {
                hm.put(hashmapKey, curr);
                hashmapKey++;
            }
        }
        
        int k = 1;
        for (int i = 0 ; i < hm.size() ; i++) {
           if(hm.containsValue(k))
               k++;
            else
                break;
        }
        
        return k;
    }
}