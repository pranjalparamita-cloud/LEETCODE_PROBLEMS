class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int profit=0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                profit=profit+(prices[r]-prices[l]);
            }
            l++;
            r++;
        }
        return profit;
    }
}