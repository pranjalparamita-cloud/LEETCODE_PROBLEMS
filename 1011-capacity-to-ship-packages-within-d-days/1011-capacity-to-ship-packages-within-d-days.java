class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; // Try a smaller capacity
            } else {
                left = mid + 1; // Need more capacity
            }
        }

        return left;
    }

    public boolean canShip(int[] weights, int days, int capacity) {
        int dayneed = 1;
        int Load = 0;

        for (int w : weights) {
            if (Load + w > capacity) {
                dayneed++;
                Load = 0;
            }
            Load += w;
        }

        return dayneed <= days;
    }
}