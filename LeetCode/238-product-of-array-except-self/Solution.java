class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        double product = 1;
        int numZeros = 0;
        
        for (int num : nums) {
            if (num == 0) {
                numZeros++;
            } else {
                product = product*num;
            }
        }
        
        if (numZeros == 0) {  // CASE ONE: all items are nonzeros
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int)(product*(Math.pow((double)nums[i],-1.0))); // emulates "product/nums[i]"
            }
        } else if (numZeros == 1) { // CASE TWO: there is one zero
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = (int)product;
                } else {
                    result[i] = 0;
                }
            }
        } else { // CASE THREE: more than one item is zero
            for (int i = 0; i < nums.length; i++) {
                result[i] = 0;
            }
        }
        return result;
    }
}
