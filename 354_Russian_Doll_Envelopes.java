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
// Updated Binary searxxh with DP Approach
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
        int max = 0;
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int a = nums[i][1];
            int id = bs(dp,a);

            max = Math.max(max,id);
            if(dp[id]>=a){
                dp[id] = a;
            }
        }
        return max;
    }
    public  int bs(int[] dp,int a){
        int start = 1,end = dp.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(dp[mid]<a){
                start= mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return start;
    }
}
