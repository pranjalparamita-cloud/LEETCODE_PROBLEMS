import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count how many items exist with each exact factor
        long[] factorCount = new long[maxFactor + 1];
        for (int[] item : items) {
            factorCount[item[0]]++;
        }

        // For each factor d, totalWithMultiples[d] = count of items whose factor is a multiple of d
        long[] totalWithMultiples = new long[maxFactor + 1];
        for (int d = 1; d <= maxFactor; d++) {
            for (int mult = d; mult <= maxFactor; mult += d) {
                totalWithMultiples[d] += factorCount[mult];
            }
        }

        // Collect (price, bonusCopiesCount) pairs where 1 bought copy gives 1 extra free copy
        // (excluding itself via factorCount[f] - 1)
        List<long[]> bonusOffers = new ArrayList<>();
        for (int[] item : items) {
            int f = item[0];
            long price = item[1];
            long gain = totalWithMultiples[f] - 1;
            if (gain > 0 && price < 2L * minPrice) {
                bonusOffers.add(new long[]{price, gain});
            }
        }

        // Greedily buy cheapest bonus offers first
        bonusOffers.sort(Comparator.comparingLong(a -> a[0]));

        long remBudget = budget;
        long totalItems = 0;

        for (long[] offer : bonusOffers) {
            long price = offer[0];
            long available = offer[1];
            if (remBudget < price) {
                break;
            }
            long buy = Math.min(available, remBudget / price);
            // Each of these `buy` copies gives 1 purchased item + 1 free item = 2 items
            totalItems += buy * 2L;
            remBudget -= buy * price;
        }

        // Spend remaining budget on the cheapest item (1 item each)
        totalItems += remBudget / minPrice;

        return (int) totalItems;
    }
}