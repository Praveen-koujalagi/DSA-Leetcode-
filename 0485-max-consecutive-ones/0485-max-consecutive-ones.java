class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int result =0 ;
        int count = 0;
        for(int i=0; i< n; i++){
           if(nums[i] == 1){
            count++;
            result = Math.max(result,count);
        }else{
            count = 0;
        }        
    } 
    return result;
  }
}