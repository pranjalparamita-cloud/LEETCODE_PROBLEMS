class Solution {
public int numSubarraysWithSum(int[] nums, int goal) {
return atMost(nums, goal)- atMost(nums, goal- 1);
}
// Counts subarrays with sum <= target in O(n) time and O(1) space
private int atMost(int[] nums, int target) {
if (target < 0) return 0;
int left = 0, currentSum = 0, count = 0;
for (int right = 0; right < nums.length; right++) {
currentSum += nums[right];
while (currentSum > target) {
currentSum-= nums[left++];
}
// Every subarray ending at 'right' starting from [left .. right] is valid
count += (right- left + 1);
}
return count;
}
}