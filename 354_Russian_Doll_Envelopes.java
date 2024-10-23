class Solution {
    public int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            else{
                return a[0]-b[0];
            }
        });
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[j][0]<nums[i][0]&&nums[j][1]<nums[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;

    }
}
