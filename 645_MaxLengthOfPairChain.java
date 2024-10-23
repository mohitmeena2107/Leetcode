class Solution {
    public int findLongestChain(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums,(a,b)->{
            return a[0]-b[0];
        });
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j][1]<nums[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);

        }
        return max;
    }
}
